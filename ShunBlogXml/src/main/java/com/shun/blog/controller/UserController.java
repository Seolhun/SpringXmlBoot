package com.shun.blog.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.internet.MimeMessage;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.shun.blog.commons.authentification.CommonFnDAOService;
import com.shun.blog.commons.authentification.Constant;
import com.shun.blog.model.user.UserService;

@Controller("userController")
public class UserController {
	
    @Autowired
    private UserService userService;
    
    @Autowired
	private JavaMailSender mailSender;

	@Autowired
	CommonFnDAOService CommonFnDAOService;
	
	String language_code = Constant.LANGUAGE_CODE;

	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		//model.addAttribute("user", getPrincipal());
		return "admin";
	}
	
	@RequestMapping(value = "/admin2", method = RequestMethod.GET)
	public String adminPage2(ModelMap model) {
		//model.addAttribute("user", getPrincipal());
		return "admin2";
	}

	@RequestMapping(value = "/dba", method = RequestMethod.GET)
	public String dbaPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "dba";
	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}

	@RequestMapping(value = "/loginDo")
	public String loginPage(ModelMap model) {
		// 언어 설정 선택
		model.addAttribute("language_code", language_code);
		String user_name = CommonFnDAOService.getPrincipal();

		if (!user_name.equals("anonymousUser")) {
			String sub_title = "관리자 페이지";
			model.addAttribute("sub_title", sub_title);
			return "admin";
		} else {
			return "main/main";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}
	
	@RequestMapping(value = "/signDo")
	public String userInsert(String signEmail, String signPwd) throws Exception{
		Map map=new HashMap();
		map.put("signEmail", signEmail);
		map.put("signPwd", signPwd);
		map.put("userRole", "ROLE_USER");
		userService.userInsert(map);
		userService.userRoleInsert(map);
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/checkEmail")
	public void sendMail(String signEmail, ServletResponse res, HttpSession session) throws IOException {
		String emailregex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		String from = "onm10114@gmail.com";
		String subject = "안녕하세요 고객님. (주)아이메디신의 iSyncBrain 회원가입 인증메일입니다.";
		if(signEmail.matches(emailregex)){
			try {
				MimeMessage message = mailSender.createMimeMessage();
				//true로서 멀티파트 메세지라는 의미
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				messageHelper.setFrom(from);
				messageHelper.setTo(signEmail);
				messageHelper.setSubject(subject);
				
				int authentication=(int)(Math.random()*1000000);
				session.setAttribute("authentication", authentication);
				session.setMaxInactiveInterval(3*60);//Session 3분 유지하기 
				
				messageHelper.setText(""
						+ "<html><body><img src='cid:Google_Logo'>"
						+ "<div style='text-align : center; font-color:black; font-size : 14px;'>"
						+ "<p>안녕하세요.</p>"
						+ "<p>iSyncBrain 회원가입 인증메일입니다.</p>"
						+ "<p>확인 버튼을 통해서 이메일 인증 후 가입해주시기 바랍니다.</p>"
						+"<p>"+authentication+"</p>"
						+ "<button>이메일 인증 완료</buttn>"
						+ "</div></body></html>",true);
				//파일첨부하기 하지만, Url위치가 틀려서 파일을 찾을 수 없다고 에러가 발생...수정 요망
				//FileSystemResource fileImage=new FileSystemResource("/resources/img/google.png");
				//messageHelper.addAttachment("Google Png", fileImage);
				
				//로고 넣기
				//ClassPathResource image=new ClassPathResource("/resources/img/google.png");
				//messageHelper.addInline("Google_Logo", image);
				
				mailSender.send(message);
				res.getWriter().write("emailOK");
			} catch(Exception e){
				e.printStackTrace();
			}
		} else {
			res.getWriter().write("emailFail");
		}
	}
	
	@RequestMapping(value = "/authentication")
	public String auth(@RequestParam @Valid String auth){
		return "main/main";
	}
}
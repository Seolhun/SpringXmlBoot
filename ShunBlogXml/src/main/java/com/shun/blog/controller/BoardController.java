package com.shun.blog.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shun.blog.board.BoardReplyVO;
import com.shun.blog.board.BoardService;
import com.shun.blog.board.BoardVO;


@Controller("boardController")
public class BoardController {
	Logger log=Logger.getLogger(this.getClass());
	
    @Autowired
    private BoardService boardService;
	
	@RequestMapping("/board")
	//public ModelAndView board_list(String curPage, String block, String searchType, String searchContent, Model model) {
	public ModelAndView boardList(Map<String, Object> Map, String curPage, String block, Model model) throws Exception {
		ModelAndView mv=new ModelAndView("board");
		if (curPage == null) {
			curPage = "1";
		}
		if (block == null) {
			block = "1";
		}
		int currentBlock = Integer.parseInt(block); // 현재 위치한 페이 블록
		int moveBlock = (currentBlock * 5) - 4; // block으로 1,6,11
		int totalPage = boardService.boardTotalPage(); // 총 페이지 1페이지씩 세어보았을
		int blockNum = (int) (Math.ceil(((double) totalPage) / 5)); // 페이지 블록 개수
		int lastPage = (totalPage % 5) - 1; // 마지막 남은 페이지 개수
		
		int startPage = Integer.parseInt(curPage); // 현재 위치한 페이지
		int start = (startPage - 1) * 10;
		List<Map<String, Object>> list = boardService.boardAllData(start);
		model.addAttribute("list", list);
		model.addAttribute("startPage", startPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("currentBlock", currentBlock);
		model.addAttribute("moveBlock", moveBlock);
		model.addAttribute("blockNum", blockNum);
		return mv; //콜백
	}
	
	@RequestMapping("/boardSearch")
	public ModelAndView boardSearch(@RequestParam String searchCurPage,@RequestParam String searchBlock,@RequestParam String searchType,@RequestParam String searchContent ,Model model){
		ModelAndView mv=new ModelAndView("boardSearch");
		if (searchCurPage == null) {
			searchCurPage = "1";
		}
		if (searchBlock == null) {
			searchBlock = "1";
		}
		Map map=new HashMap();
		map.put("searchContent", searchContent);
		map.put("searchType", searchType);
		int searchCurrentBlock = Integer.parseInt(searchBlock); // 현재 위치한 페이 블록
		int searchMoveBlock = (searchCurrentBlock * 5) - 4; 	// block으로 1,6,11 (다음 이전시 5개씩 가감)
		int searchStartPage = Integer.parseInt(searchCurPage); // 현재 위치한 페이지
		int searchStart = (searchStartPage - 1) * 10;
		map.put("searchStart", searchStart);
		int searchTotalPage = boardService.boardSearchTotalPage(map);// 총 페이지 1페이지씩 세워보았을 때에
		int searchBlockNum = (int)(Math.ceil(((double)searchTotalPage)/5)); // 페이지 블록 개수
		int searchLastPage = (searchTotalPage % 5) - 1; 		// 마지막 남은 페이지 개수
		List<Map<String, Object>> searchList = boardService.boardSearch(map);
		model.addAttribute("searchList", searchList);
		model.addAttribute("searchStartPage", searchStartPage);
		model.addAttribute("searchTotalPage", searchTotalPage);
		model.addAttribute("searchLastPage", searchLastPage);
		model.addAttribute("searchCurrentBlock", searchCurrentBlock);
		model.addAttribute("searchMoveBlock", searchMoveBlock);
		model.addAttribute("searchBlockNum", searchBlockNum);
		model.addAttribute("searchType", searchType);
		model.addAttribute("searchContent", searchContent);
		return mv;
	}

	// 게시판 글쓰기
	// boardno, userno,subject,content,regdate,hit,blike,depth
	@RequestMapping("/boardInsert")
	public String boardInsert(String boardAccount, String boardSubject, String smartEditor, ServletResponse res, HttpServletRequest req) throws Exception {
		Map map = new HashMap();
		map.put("boardAccount", boardAccount);
		map.put("boardSubject", boardSubject);
		map.put("smartEditor", smartEditor);
		boardService.boardInsert(map, req);
		return "redirect:/board";
	}

	//게시글 내용보기 
	@RequestMapping("/boardDetail")
	public ModelAndView boardDetail(int boardNo, HttpSession session, Model model) {
		ModelAndView mv=new ModelAndView("boardModify");
		BoardVO bVo = boardService.boardDetail(boardNo);
		List<BoardReplyVO> replyList =boardService.boardReplyList(boardNo);
		String logAccount = (String)session.getAttribute("logAccount");
		try {
			if (logAccount.equals(bVo.getAccount()) || logAccount == null) {

			} else {
				boardService.boardHitIncrement(boardNo);
			}
		} catch (Exception e) {
			System.out.println("회원가입하지 않은 유저입니다.");
		}
		model.addAttribute("bVo", bVo);
		model.addAttribute("replyList", replyList);
		return mv;
	}
	
	//게시글 댓글 달기 
	@RequestMapping("/boardReplyInsert")
	public void boardReplyInsert(@RequestParam String reTextarea, @RequestParam int boardNo, HttpSession session ,Model model, ServletResponse res) throws IOException {
//		<!-- boardReplyNo,boardNo,account,replyContent,replyRegDate,boardLikeNum --> 
		try {
			String logAccount=(String)session.getAttribute("logAccount");
			if(logAccount==null){
				res.getWriter().write("noid");
				return;
			}
			Map map=new HashMap();
			map.put("boardNo", boardNo);
			map.put("logAccount", logAccount);
			map.put("replyContent", reTextarea);
			boardService.boardReplyInsert(map);
			res.getWriter().write("ok");
			boardService.boardDepthIncrement(boardNo);
		} catch (Exception e) {
			System.out.println("boardReplyInsert 예외처리 오류");
			e.printStackTrace();
		}
	}
	
	//게시글 삭제하기
	@RequestMapping("/boardDelete")
	public void boardDelete(int boardNo, ServletResponse res) throws IOException{
		int checkReplyNum=boardService.checkReplyNum(boardNo); //댓글 갯수 확인 
		if(checkReplyNum<1){
			boardService.boardDelete(boardNo);
		} else {
			res.getWriter().write("fail");
		}
	}
	
	//게시글 답변 삭제하기
	@RequestMapping("/boardReplyDelete")
	public void boardReplyDelete(int reBoardNo,int boardReplyNo, ServletResponse res) throws IOException{
		try {
			Map map=new HashMap();
			map.put("reBoardNo", reBoardNo);
			map.put("boardReplyNo", boardReplyNo);
			boardService.boardReplyDelete(map);
			boardService.boardDepthDecrement(reBoardNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		res.getWriter().write("success");
	}

	// 라이크 기능 잠시보류 - 생각 더 필요
	@RequestMapping("/boardLike")
	public void boardLike(int boardNo, String logAccount) {
		Map map = new HashMap();
		map.put("boardNo", boardNo);
		map.put("logAccount", logAccount);
		boardService.boardLikeChange(map);
	}
	
	// 게시판 수정하기
	@RequestMapping("/boardModify")
	public ModelAndView boardModify(int boardNo, Model model){
		ModelAndView mv=new ModelAndView("boardModify");
		BoardVO bVO=boardService.boardModify(boardNo);
		model.addAttribute("bVO", bVO);
		return mv;
	}
	
	// 게시판 수정하여 입력하기 
	// boardno, userno,subject,content,regdate,hit,blike,depth
	@RequestMapping("/boardModifyInsert")
	public void boardModifyInsert(@RequestParam String boardModifyNo, @RequestParam String boardModifySubject,@RequestParam String smartEditor, ServletResponse res) throws IOException {
		try {
			Map map = new HashMap();
			map.put("boardModifyNo", boardModifyNo);
			map.put("boardModifySubject", boardModifySubject);
			map.put("smartEditor", smartEditor);
			boardService.boardModifyInsert(map);
			res.getWriter().write("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	// 단일 파일업로드
//	@RequestMapping("/photoUpload")
//	public String photoUpload(HttpServletRequest request, PhotoVO vo){
//	    String callback = vo.getCallback();
//	    String callback_func = vo.getCallback_func();
//	    String file_result = "";
//	    try {
//	        if(vo.getFiledata() != null && vo.getFiledata().getOriginalFilename() != null && !vo.getFiledata().getOriginalFilename().equals("")){
//	            //파일이 존재하면
//	            String original_name = vo.getFiledata().getOriginalFilename();
//	            String ext = original_name.substring(original_name.lastIndexOf(".")+1);
//	            //파일 기본경로
//	            String defaultPath = request.getSession().getServletContext().getRealPath("/");
//	            //파일 기본경로 _ 상세경로
//	            String path = defaultPath + "resource" + File.separator + "photo_upload" + File.separator;              
//	            File file = new File(path);
//	            System.out.println("path:"+path);
//	            //디렉토리 존재하지 않을경우 디렉토리 생성
//	            if(!file.exists()) {
//	                file.mkdirs();
//	            }
//	            //서버에 업로드 할 파일명(한글문제로 인해 원본파일은 올리지 않는것이 좋음)
//	            String realname = UUID.randomUUID().toString() + "." + ext;
//	        ///////////////// 서버에 파일쓰기 ///////////////// 
//	            vo.getFiledata().transferTo(new File(path+realname));
//	            file_result += "&bNewLine=true&sFileName="+original_name+"&sFileURL=/SE2/photo_upload/"+realname;
//	        } else {
//	            file_result += "&errstr=error";
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	    return "redirect:" + callback + "?callback_func="+callback_func+file_result;
//	}
//	
//	//다중파일업로드
//	@RequestMapping("/multiplePhotoUpload")
//	public void multiplePhotoUpload(HttpServletRequest request, HttpServletResponse response){
//	    try {
//	         //파일정보
//	         String sFileInfo = "";
//	         //파일명을 받는다 - 일반 원본파일명
//	         String filename = request.getHeader("file-name");
//	         //파일 확장자
//	         String filename_ext = filename.substring(filename.lastIndexOf(".")+1);
//	         //확장자를소문자로 변경
//	         filename_ext = filename_ext.toLowerCase();
//	         //파일 기본경로
//	         String dftFilePath = request.getSession().getServletContext().getRealPath("/");
//	         //파일 기본경로 _ 상세경로
//	         String filePath = dftFilePath + "resource" + File.separator + "photo_upload" + File.separator;
//	         File file = new File(filePath);
//	         if(!file.exists()) {
//	            file.mkdirs();
//	         }
//	         String realFileNm = "";
//	         SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
//	         String today= formatter.format(new java.util.Date());
//	         realFileNm = today+UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
//	         String rlFileNm = filePath + realFileNm;
//	         ///////////////// 서버에 파일쓰기 ///////////////// 
//	         InputStream is = request.getInputStream();
//	         OutputStream os=new FileOutputStream(rlFileNm);
//	         int numRead;
//	         byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
//	         while((numRead = is.read(b,0,b.length)) != -1){
//	            os.write(b,0,numRead);
//	         }
//	         if(is != null) {
//	            is.close();
//	         }
//	         os.flush();
//	         os.close();
//	         ///////////////// 서버에 파일쓰기 /////////////////
//	         // 정보 출력
//	         sFileInfo += "&bNewLine=true";
//	         // img 태그의 title 속성을 원본파일명으로 적용시켜주기 위함
//	         sFileInfo += "&sFileName="+ filename;;
//	         sFileInfo += "&sFileURL="+"/SE2/photo_upload/"+realFileNm;
//	         PrintWriter print = response.getWriter();
//	         print.print(sFileInfo);
//	         print.flush();
//	         print.close();
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	}

	// Contact 이메일 보내기
	@RequestMapping("/contactMail")
	public void contactMail(@RequestParam String account, @RequestParam String subject, @RequestParam String ir1,
			@RequestParam String email1, @RequestParam String email2, ServletResponse res) throws IOException {
		String emailCheck = email2.substring(email2.length() - 4, email2.length());
		System.out.println(emailCheck);
		if (emailCheck.equals(".com") || emailCheck.equals(".net")) {
			String to = "onm10114@gmail.com";
			String from = "onm10114@gmail.com";
			String host = "smtp.gmail.com";
			String password = "qawsedrf@";
			String from_name = account;
			Properties props = new Properties();
			props.put("mail.smtps.auth", "true");
			Session session = Session.getInstance(props);
			try {
				MimeMessage msg = new MimeMessage(session);
				msg.setFrom(new InternetAddress(from, MimeUtility.encodeText(from_name, "UTF-8", "B")));
				msg.setSubject(subject);
				msg.setContent("문의자 내용" + ir1 + "<br>" + "<h2>문의자 이메일 주소 : " + email1 + "@" + email2 + "<h2>",
						"text/html;charset=UTF-8");
				InternetAddress address = new InternetAddress(to);
				msg.setRecipient(Message.RecipientType.TO, address);

				Transport transport = session.getTransport("smtps");
				transport.connect(host, from, password);
				transport.sendMessage(msg, msg.getAllRecipients());
				Transport.send(msg);
				transport.close();
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
			res.getWriter().write("ok");
		} else {
			res.getWriter().write("false");
		}
	}
}
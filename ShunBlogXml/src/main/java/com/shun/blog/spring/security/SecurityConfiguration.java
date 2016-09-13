package com.shun.blog.spring.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomSuccessHandler customSuccessHandler;
	
	@Autowired
	DataSource dataSource;

	//DB가 있을 때, JDBC로 연결한다.
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		  auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery(
				"SELECT account,pwd,joindata,grade,isAccountNonExpired,isAccountNonLocked,isCredentialsNonExpired,isEnabled FROM userVO where account=?")
			.authoritiesByUsernameQuery(
				"SELECT account,userRole FROM userRoleVO where account=?")
			.passwordEncoder(new StandardPasswordEncoder("53cr3t"));
	}
	//account,pwd,joindata,grade,isAccountNonExpired,isAccountNonLocked,isCredentialsNonExpired,isEnabled
	//account_role_idx,account,userRole
	
	//권한 부여한것
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  http.authorizeRequests()
	  	.antMatchers("/admin/**").access("hasRole('ADMIN')")
	  	.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
	  	.antMatchers("/main","/board/*").access("hasRole('USER')")
	  	.and()
	  		.formLogin().loginPage("/login").successHandler(customSuccessHandler)
	  		.usernameParameter("logAccount").passwordParameter("logPwd")
	  	.and()
	  		.exceptionHandling().accessDeniedPage("/accessDenied")
  		.and()
  			.csrf()	
	  	.and()
	  		.logout().logoutSuccessUrl("/login?logout?");
	  	
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}
}

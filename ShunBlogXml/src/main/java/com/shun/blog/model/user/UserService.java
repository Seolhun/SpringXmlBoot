package com.shun.blog.model.user;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
	//회원가입하기 
	void userInsert(Map map);
	
	void userRoleInsert(Map map);
	
	//로그인하기 
	String userLogin(String logAccount);
	
	//회원 가입시 중복확인 
	int accountCheck(String signAccount);
	
	//로그인시 회원 확인 
	int userAccountCheck(String logAccount);
}
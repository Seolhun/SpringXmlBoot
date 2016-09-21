package com.shun.blog.model.user;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
	//회원가입하기 
	void userInsert(UserVO userVO);
	
	//user역할 - 페이지 권한 부여 
	void userRoleInsert(UserRoleVO userRoleVO);
	
	//회원 가입시 중복확인 
	int ownUserCheck(String signEmail);
	
	//로그인하기
	UserVO userLogin(String signEmail);

	//로그인시 회원 확인 
	int userLoginCheck(Map map);
}
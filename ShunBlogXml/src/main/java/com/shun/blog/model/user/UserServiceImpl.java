package com.shun.blog.model.user;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service(value = "userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	
	//회원 가입하기 
	public void userInsert(UserVO userVO){
		userDAO.userInsert(userVO);
	}
	
	//회원역할 넣기
	@Override
	public void userRoleInsert(UserRoleVO userRoleVO) {
		userDAO.userRoleInsert(userRoleVO);
	} 
	
	//회원인지 확인
	@Override
	public int ownUserCheck(String signEmail) {
		return userDAO.ownUserCheck(signEmail);
		
	}

	@Override
	public UserVO userLogin(String signEmail) {
		return userDAO.userLogin(signEmail);
	}
	
	@Override
	public int userLoginCheck(Map map) {
		return userDAO.userLoginCheck(map);
	}
	
}
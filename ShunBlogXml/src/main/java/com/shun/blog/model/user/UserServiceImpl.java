package com.shun.blog.model.user;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userServiceImple")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	//회원 가입하기 
	@Override
	public void userInsert(Map map) {
		userDAO.userInsert(map);
	}
	//회원역할 넣기
	@Override
	public void userRoleInsert(Map map) {
		userDAO.userRoleInsert(map);
	} 

	@Override
	public String userLogin(String logAccount) {
		return userDAO.userLogin(logAccount);
	}

	@Override
	public int accountCheck(String signAccount) {
		return userDAO.accountCheck(signAccount);
	}

	@Override
	public int userAccountCheck(String logAccount) {
		return userDAO.userAccountCheck(logAccount);
	}

	
}
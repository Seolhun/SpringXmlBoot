package com.shun.blog.model.user;

import org.springframework.stereotype.Repository;
import com.shun.blog.commons.dao.AbstractDAO;
import java.util.*;

@Repository
public class UserDAO extends AbstractDAO {

	public void userInsert(UserVO userVO) {
		insert("user.userInsert", userVO);
	}
	
	public void userRoleInsert(UserRoleVO userRoleVO) {
		insert("user.userRoleInsert", userRoleVO);
	}
	
	public int ownUserCheck(String signEmail){
		return (int)selectOne("user.ownUserCheck", signEmail);
	}
	
	public UserVO userLogin(String signEmail){
		return (UserVO)selectOne("user.userLogin", signEmail);
	}
	
	public int userLoginCheck(Map map){
		return (Integer) selectOne("user.userLoginCheck", map);
	}
}

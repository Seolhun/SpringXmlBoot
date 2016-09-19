package com.shun.blog.model.user;

import org.springframework.stereotype.Repository;
import com.shun.blog.commons.dao.AbstractDAO;
import java.util.*;

@Repository
public class UserDAO extends AbstractDAO {

	public void userInsert(Map map) {
		insert("user.userInsert", map);
	}
	
	public void userRoleInsert(Map map) {
		insert("user.userRoleInsert", map);
	}
	
	public String userLogin(String logAccount){
		return (String)selectOne("user.userLogin", logAccount);
	}
	
	public int accountCheck(String signAccount){
		return (Integer)selectOne("user.accountCheck", signAccount);
	}
	
	public int userAccountCheck(String logAccount){
		return (Integer) selectOne("user.userAccountCheck", logAccount);
	}}

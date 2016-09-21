package com.shun.blog.model.usersercurity.dao;

import java.util.List;

import com.shun.blog.model.usersercurity.model.UserProfile;

public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}

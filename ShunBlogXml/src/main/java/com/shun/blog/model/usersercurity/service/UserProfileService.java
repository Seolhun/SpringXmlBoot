package com.shun.blog.model.usersercurity.service;

import java.util.List;

import com.shun.blog.model.usersercurity.model.UserProfile;

public interface UserProfileService {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}

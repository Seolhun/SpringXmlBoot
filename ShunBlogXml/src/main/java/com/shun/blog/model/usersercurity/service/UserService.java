package com.shun.blog.model.usersercurity.service;

import com.shun.blog.model.usersercurity.model.User;

public interface UserService {

	void save(User user);

	void update(User user);

	User findById(int id);

	User findBySso(String sso);

}
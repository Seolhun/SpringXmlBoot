package com.shun.blog.model.usersercurity.dao;

import com.shun.blog.model.usersercurity.model.User;

public interface UserDao {

	void save(User user);

	void update(User user);

	User findById(int id);

	User findBySSO(String sso);

}

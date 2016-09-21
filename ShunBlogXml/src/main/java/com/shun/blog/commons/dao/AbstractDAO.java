package com.shun.blog.commons.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public Object insert(String queryId, Object params) {
		return sqlSessionTemplate.insert(queryId, params);
	}

	public Object update(String queryId, Object params) {
		return sqlSessionTemplate.update(queryId, params);
	}

	public Object delete(String queryId, Object params) {
		return sqlSessionTemplate.delete(queryId, params);
	}

	public Object selectOne(String queryId) {
		return sqlSessionTemplate.selectOne(queryId);
	}

	public Object selectOne(String queryId, Object params) {
		return sqlSessionTemplate.selectOne(queryId, params);
	}

	@SuppressWarnings("rawtypes")
	public List selectList(String queryId) {
		return sqlSessionTemplate.selectList(queryId);
	}

	@SuppressWarnings("rawtypes")
	public List selectList(String queryId, Object params) {
		return sqlSessionTemplate.selectList(queryId, params);
	}
}
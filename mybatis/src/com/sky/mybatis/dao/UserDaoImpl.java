package com.sky.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sky.mybatis.pojo.User;

/**
 * Dao
 * @author sky
 *
 */
public class UserDaoImpl implements UserDao {

	
	//注入
	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}
	//通过用户ID查询一个用户
	public User selectUserById(Integer id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectOne("test.findUserById", id);
	}
	
}

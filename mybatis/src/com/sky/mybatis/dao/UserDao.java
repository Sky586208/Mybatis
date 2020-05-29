package com.sky.mybatis.dao;

import com.sky.mybatis.pojo.User;

public interface UserDao {

	//通过用户ID查询一个用户
		public User selectUserById(Integer id);
	
}

package com.sky.mybatis.junit;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.sky.mybatis.mapper.OrderMapper;
import com.sky.mybatis.mapper.UserMapper;
import com.sky.mybatis.pojo.Orders;
import com.sky.mybatis.pojo.QueryVo;
import com.sky.mybatis.pojo.User;

public class MybatisMapperTest {

	
	@Test
	public void testMapper() throws Exception{
		
		//���غ��������ļ�
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		
		//SqlSession��������һ��ʵ���� �����ӿڣ�
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		User user = userMapper.findUserById(10);
		System.out.println(user);
		
	}
	
	@Test
	public void testMapperQueryVo() throws Exception{
		
		//���غ��������ļ�
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		
		//SqlSession��������һ��ʵ���� �����ӿڣ�
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		QueryVo vo = new QueryVo();
		User user = new User();
		user.setUsername("��");
		vo.setUser(user);
		
		List<User> us = userMapper.findUserByQueryVo(vo);
		
		for (User u : us) {
		
			System.out.println(u);
		}
	}
	
	@Test
	public void testMapperQueryVoCount() throws Exception{
		
		//���غ��������ļ�
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		
		//SqlSession��������һ��ʵ���� �����ӿڣ�
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		
		  Integer i = userMapper.countUser();
		
			System.out.println(i);
	}
	
	
	//��ѯ������������
	@Test
	public void testOrderList() throws Exception{
		//���غ��������ļ�
				String resource = "sqlMapConfig.xml";
				InputStream in = Resources.getResourceAsStream(resource);
				//����SqlSessionFactory
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
				//����SqlSession
				SqlSession sqlSession = sqlSessionFactory.openSession();
				
				OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
				
				List<Orders> ordersList = mapper.selectOrderList();
				for(Orders orders : ordersList) {
					System.out.println(orders);
				}
	}
	
	//�����Ա�����ֲ�ѯ�û�
	@Test
	public void testfindUserBySexAndUsername() throws Exception{
		//���غ��������ļ�
				String resource = "sqlMapConfig.xml";
				InputStream in = Resources.getResourceAsStream(resource);
				//����SqlSessionFactory
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
				//����SqlSession
				SqlSession sqlSession = sqlSessionFactory.openSession();
				
				UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
				
				User user = new User();
				user.setSex("1");
				user.setUsername("��С��");
				List<User> users = userMapper.selectUserBySexAndUsername(user);
				
				for(User user2 : users) {
					System.out.println(user2);
				}
	}
	//���ID
	@Test
	public void testfindUserIds() throws Exception{
		//���غ��������ļ�
				String resource = "sqlMapConfig.xml";
				InputStream in = Resources.getResourceAsStream(resource);
				//����SqlSessionFactory
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
				//����SqlSession
				SqlSession sqlSession = sqlSessionFactory.openSession();
				
				UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
				
				List<Integer> ids = new ArrayList<>();
				ids.add(16);
				ids.add(22);
				ids.add(24);
				QueryVo vo = new QueryVo();
				vo.setIdsList(ids);
				
				List<User> users = userMapper.selectUserByIds(vo);
		/*
		 * Integer[] ids =new Integer[3]; ids[0] = 16; ids[1] = 22; ids[2] = 24;
		 * List<User> users = userMapper.selectUserByIds(ids);
		 */
				
				for(User user2 : users) {
					System.out.println(user2);
				}
	}
}

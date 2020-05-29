package com.sky.mybatis.junit;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.sky.mybatis.pojo.User;

public class MybatisFirstTest {

	
	@Test
	public void testMybatis() throws Exception{
		//���غ��������ļ�
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//ִ��Sql���
		User user = sqlSession.selectOne("test.findUserById", 10);
		
		System.out.println(user);
	}
	
	//�����û���ģ����ѯ�û��б�
	@Test
	public void testfindByUsername() throws Exception{
		//���غ��������ļ�
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//ִ��Sql���
		List<User> users = sqlSession.selectList("test.findUserByUsername", "��");
		for (User user2 : users) {
			
		    System.out.println(user2);
		
		}
	}
	
	//����û�
		@Test
		public void testInsertUser() throws Exception{
			//���غ��������ļ�
			String resource = "sqlMapConfig.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			//����SqlSessionFactory
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
			//����SqlSession
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			//ִ��Sql���
			User user = new User();
			user.setUsername("����");
			user.setBirthday(new Date());
			user.setSex("��");
			user.setAddress("adaf");
				
	       int i = sqlSession.insert("test.insertUser", user);
	       sqlSession.commit();
	       
	       System.out.println(user.getId());
			
		}
		
	    //�޸��û�id
				@Test
				public void testUpdateUserById() throws Exception{
					//���غ��������ļ�
					String resource = "sqlMapConfig.xml";
					InputStream in = Resources.getResourceAsStream(resource);
					//����SqlSessionFactory
					SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
					//����SqlSession
					SqlSession sqlSession = sqlSessionFactory.openSession();
					
					//ִ��Sql���
					User user = new User();
					user.setId(29);
					user.setUsername("����292929");
					user.setBirthday(new Date());
					user.setSex("��");
					user.setAddress("adafas");
						
			       int i = sqlSession.update("test.updateUserById", user);
			       sqlSession.commit();
			      	
			}
				
			//ɾ���û�id
				@Test
				public void testDeleteUserById() throws Exception{
					//���غ��������ļ�
					String resource = "sqlMapConfig.xml";
					InputStream in = Resources.getResourceAsStream(resource);
					//����SqlSessionFactory
					SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
					//����SqlSession
					SqlSession sqlSession = sqlSessionFactory.openSession();
					
					//ִ��Sql���
				
			       sqlSession.delete("test.deleteUserById", 29);
			       sqlSession.commit();
			      	
				}
	
}

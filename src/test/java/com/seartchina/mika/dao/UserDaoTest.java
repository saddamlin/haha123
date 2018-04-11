package com.seartchina.mika.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.seartchina.mika.dao.user.UserDao;
import com.seartchina.mika.dao.user.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class UserDaoTest {
	
	@Autowired
	UserDao userDao;

	@Test
	public void testInsert() {
		User user = new User();
		user.setOpenId("test_open_id");
		user.setUserName("test_user");
		user.setGender("u");
		userDao.insertUser(user);
		System.out.println(user.getUserId());
		User user2 = userDao.getUser(1);
		System.out.println(user2.getUserId());
		System.out.println(user2.getUserName());
		System.out.println(user2.getGender());
		System.out.println(user2.getOpenId());
	}

}

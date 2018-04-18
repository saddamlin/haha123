package com.seartchina.mika.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seartchina.mika.dao.user.UserDao;
import com.seartchina.mika.dao.user.UserSessionDao;
import com.seartchina.mika.dao.user.pojo.User;
import com.seartchina.mika.dao.user.pojo.UserSession;
import com.seartchina.mika.service.constants.UserFriendStatus;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserSessionDao userSessionDao;

	public Integer userLogin(String openId, String userName, String gender, String description
			, String phone, Date dateOfBirth, String avatarUrl
			, Integer latitude, Integer longtitude, Integer accuracy) {
		User user = userDao.selectUserByOpenId(openId);
		Integer retUserId;
		if(user == null) {
			User newUser = new User();
			newUser.setOpenId(openId);
			newUser.setUserName(userName);
			newUser.setGender(gender);
			newUser.setDescription(description);
			newUser.setPhone(phone);
			newUser.setDateOfBirth(dateOfBirth);
			newUser.setAvatarUrl(avatarUrl);
			userDao.insertUser(newUser);
			retUserId = newUser.getUserId();
		}else {
			user.setOpenId(openId);
			user.setUserName(userName);
			user.setGender(gender);
			user.setDescription(description);
			user.setPhone(phone);
			user.setDateOfBirth(dateOfBirth);
			user.setAvatarUrl(avatarUrl);
			userDao.updateUser(user);
			retUserId = user.getUserId();
		}
		
		UserSession userSession = new UserSession();
		userSession.setUserId(retUserId);
		userSession.setStartTime(new Date());
		userSession.setLatitude(latitude);
		userSession.setLongtitude(longtitude);
		userSession.setAccuracy(accuracy);
		userSessionDao.insertSession(userSession);
		return retUserId;	
	}
	
	public User searchUserByUserId(Integer userId) {
		return userDao.selectUser(userId);
	}
	
	public List<User> searchUserByUserName(String userName){
		return userDao.selectUserByUserName(userName);
	}
	
	public void initFriendRequest(Integer userId, Integer friendUserId) {
		userDao.insertFriend(userId, friendUserId);
	}
	
	
	public void acceptFriendRequest(Integer userId, Integer friendUserId) {
		userDao.updateFriendStatus(userId, friendUserId, UserFriendStatus.ACCEPTED);
	}
	
	
	public void rejectFriendRequest(Integer userId, Integer friendUserId) {
		userDao.updateFriendStatus(userId, friendUserId, UserFriendStatus.REJECTED);
	}
	
	
	
}
package com.seartchina.mika.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.seartchina.mika.dao.user.UserDao;
import com.seartchina.mika.dao.user.UserSessionDao;
import com.seartchina.mika.dao.user.pojo.User;
import com.seartchina.mika.dao.user.pojo.UserSession;
import com.seartchina.mika.service.constants.UserFriendStatus;
import com.seartchina.mika.service.exception.UnauthorizedException;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserSessionDao userSessionDao;
	
	public Pair<String,String> wxLogin(String authCode) throws URISyntaxException, ClientProtocolException, IOException {
		HttpClient httpclient = HttpClients.createDefault();
		URI uri = new URIBuilder()
		        .setScheme("http")
		        .setHost("api.weixin.qq.com")
		        .setPath("/sns/jscode2session")
		        .setParameter("appid", "")
		        .setParameter("secret", "")
		        .setParameter("js_code", authCode)
		        .setParameter("grant_type", "authorization_code")
		        .build();
		HttpGet httpget = new HttpGet(uri);
		HttpResponse resp = httpclient.execute(httpget);
		HttpEntity entity = resp.getEntity();
		JSONObject respJson = JSONObject.parseObject(EntityUtils.toString(entity)) ;
	    String sessionKey = respJson.getString("session_key");
	    String openId = respJson.getString("open_id");
	    return Pair.of(openId, sessionKey);
	}
	
	public Pair<Integer,Integer> userLogin(String openId, String sessionKey) {
		User user = userDao.selectUserByOpenId(openId);
		Integer retUserId;
		if(user == null) {
			User newUser = new User();
			newUser.setOpenId(openId);
			userDao.insertUser(newUser);
			retUserId = newUser.getUserId();
		}else {
			retUserId = user.getUserId();
		}
	    UserSession userSession = new UserSession();
		userSession.setUserId(retUserId);
		userSession.setStartTime(new Date());
		userSessionDao.insertSession(userSession);
		Integer sessionId = userSession.getSessionId();
		return Pair.of(retUserId, sessionId);	
	}
	
	public Integer checkLogin(Integer sessionId) {
		UserSession userSession = userSessionDao.selectUserSessionById(sessionId);
		if(userSession == null) {
			throw new UnauthorizedException();
		} else {
			return userSession.getUserId();
		}
	}

//	public Integer userLogin(String openId, String userName, String gender, String description
//			, String phone, Date dateOfBirth, String avatarUrl
//			, Integer latitude, Integer longtitude, Integer accuracy) {
//		User user = userDao.selectUserByOpenId(openId);
//		Integer retUserId;
//		if(user == null) {
//			User newUser = new User();
//			newUser.setOpenId(openId);
//			newUser.setUserName(userName);
//			newUser.setGender(gender);
//			newUser.setDescription(description);
//			newUser.setPhone(phone);
//			newUser.setDateOfBirth(dateOfBirth);
//			newUser.setAvatarUrl(avatarUrl);
//			userDao.insertUser(newUser);
//			retUserId = newUser.getUserId();
//		}else {
//			user.setOpenId(openId);
//			user.setUserName(userName);
//			user.setGender(gender);
//			user.setDescription(description);
//			user.setPhone(phone);
//			user.setDateOfBirth(dateOfBirth);
//			user.setAvatarUrl(avatarUrl);
//			userDao.updateUser(user);
//			retUserId = user.getUserId();
//		}
//		
//		UserSession userSession = new UserSession();
//		userSession.setUserId(retUserId);
//		userSession.setStartTime(new Date());
//		userSession.setLatitude(latitude);
//		userSession.setLongtitude(longtitude);
//		userSession.setAccuracy(accuracy);
//		userSessionDao.insertSession(userSession);
//		return retUserId;	
//	}
	
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
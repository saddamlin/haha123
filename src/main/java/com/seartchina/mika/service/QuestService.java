package com.seartchina.mika.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seartchina.mika.dao.quest.QuestDao;
import com.seartchina.mika.dao.quest.QuestUserMapDao;
import com.seartchina.mika.dao.quest.pojo.Quest;
import com.seartchina.mika.dao.quest.pojo.QuestUserMap;
import com.seartchina.mika.dao.user.UserDao;
import com.seartchina.mika.dao.user.UserElementDao;
import com.seartchina.mika.dao.user.UserNotificationDao;
import com.seartchina.mika.dao.user.UserSessionDao;
import com.seartchina.mika.dao.user.pojo.UserNotification;
import com.seartchina.mika.service.constants.QuestNotification;
import com.seartchina.mika.service.constants.QuestStatus;
import com.seartchina.mika.service.constants.QuestType;
import com.seartchina.mika.service.constants.QuestUserStatus;
import com.seartchina.mika.service.constants.QuestUserType;
import com.seartchina.mika.service.util.ElementManager;
import com.seartchina.mika.service.util.ElementManager.ElementReward;
import com.seartchina.mika.service.util.NotificationUtils;

@Service
public class QuestService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserSessionDao userSessionDao;
	
	@Autowired
	private UserNotificationDao userNotificationDao;
	
	@Autowired
	private QuestDao questDao;
	
	@Autowired
	private QuestUserMapDao questUserMapDao;
	
	@Autowired
	private NotificationUtils notificationUtils;
	
	@Autowired
	private ElementManager elementManager;
	
	public void initQuest(Integer userId, List<Integer> friendIds) {
		Quest quest = new Quest();
		if(friendIds.size() > 0) {
			quest.setQuestType(QuestType.COLLABORATION);
		}else {
			quest.setQuestType(QuestType.SINGLE);
		}
		quest.setQuestStatus(QuestStatus.INIT);
		questDao.insertQuest(quest);
		for(Integer friendId:friendIds) {
			QuestUserMap userMap = new QuestUserMap();
			userMap.setUserId(friendId);
			userMap.setUserType(QuestUserType.PARTICIPANT);
			userMap.setUsetStatus(QuestUserStatus.INIT);
			questUserMapDao.insertQuestUserMap(userMap);
			
			UserNotification userNotification = new UserNotification();
			String message = notificationUtils.questInitParticipant(friendId);
			userNotification.setMessage(message);
			userNotification.setUserId(friendId);
			userNotification.setNotificationType(QuestNotification.QUEST_SUCCESS);
			userNotificationDao.addNotification(userNotification);
		}
		
		QuestUserMap ownerMap = new QuestUserMap();
		ownerMap.setUserId(userId);
		ownerMap.setUserType(QuestUserType.OWNER);
		ownerMap.setUsetStatus(QuestUserStatus.ACCEPTED);
		questUserMapDao.insertQuestUserMap(ownerMap);
		
		UserNotification userNotification = new UserNotification();
		String message = notificationUtils.questInitParticipant(userId);
		userNotification.setMessage(message);
		userNotification.setUserId(userId);
		userNotification.setNotificationType(QuestNotification.QUEST_SUCCESS);
		userNotificationDao.addNotification(userNotification);
	}
	
	public void acceptQuest(Integer userId, Integer questId) {
		QuestUserMap questUserMap = new QuestUserMap();
		questUserMap.setQuestId(questId);
		questUserMap.setUserId(userId);
		questUserMap.setUsetStatus(QuestUserStatus.ACCEPTED);
		questUserMapDao.updateQuestUserMap(questUserMap);
		
		Quest quest = questDao.selectQuestById(questId);
		
		List<QuestUserMap> questUserMaps = quest.getQuestUserMaps();
		Boolean questStatus = true;
		for(QuestUserMap map:questUserMaps) {
			if (!QuestUserStatus.ACCEPTED.equals(map.getUsetStatus())) {
				questStatus = false;
			}
		}
		
		if(questStatus) {
			// update quest info
			
			quest.setQuestStatus(QuestStatus.SUCCEEDED);
			questDao.updateQuest(quest);
			
			for(QuestUserMap userMap:questUserMaps) {
				// generate reward
				ElementReward reward = elementManager.genElementReward();
				
				// update notification info
				UserNotification userNotification = new UserNotification();
				String message = notificationUtils.questSuccess(userId, reward.elementId, reward.quantity);
				userNotification.setMessage(message);
				userNotification.setUserId(userMap.getUserId());
				userNotification.setNotificationType(QuestNotification.QUEST_SUCCESS);
				userNotificationDao.addNotification(userNotification);
				
				// update user element info
				
				elementManager.addElement(userMap.getUserId(), reward.elementId, reward.quantity);
			}
		}
		
	}
	
	public void rejectQuest(Integer userId, Integer questId) {
		QuestUserMap questUserMap = new QuestUserMap();
		questUserMap.setQuestId(questId);
		questUserMap.setUserId(userId);
		questUserMap.setUsetStatus(QuestUserStatus.REJECTED);
		questUserMapDao.updateQuestUserMap(questUserMap);
		
		Quest quest = questDao.selectQuestById(questId);
		quest.setQuestStatus(QuestStatus.FAILED);
		questDao.updateQuest(quest);
		
		List<QuestUserMap> questUserMaps = quest.getQuestUserMaps();
		
		for(QuestUserMap userMap:questUserMaps) {
			UserNotification userNotification = new UserNotification();
			String message = notificationUtils.questFailure(userId);
			userNotification.setMessage(message);
			userNotification.setUserId(userMap.getUserId());
			userNotification.setNotificationType(QuestNotification.QUEST_FAILURE);
			userNotificationDao.addNotification(userNotification);
		}
		
	}
	

}

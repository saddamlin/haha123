package com.seartchina.mika.dao.user;

import java.util.List;

import javax.management.Notification;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.seartchina.mika.dao.user.pojo.UserNotification;

public interface UserNotificationDao {
	
	@Insert("insert into user_notification (user_id, notification_type, message) values (#{userId}, #{notificationType}, #{message})")
	public void addNotification(UserNotification userNotification);
	
	@Select("select * from user_notification where user_id = #{userId}")
	@Results({
		@Result(id=true,property="notificationId",column="notification_id"),
		@Result(property="userId",column="user_id"),
		@Result(property="notificationType",column="notification_type"),
		@Result(property="message",column="message"),
		@Result(property="createdDate",column="created_date"),
		@Result(property="lastUpdateDate",column="last_update_date")
	})
	public List<Notification> selectNoticationsByUserId(Integer userId);

}

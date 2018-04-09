package com.seartchina.mika.dao.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.seartchina.mika.dao.user.pojo.UserSession;

public interface UserSessionDao {
	
	@Insert("insert into user_session(user_id,start_time,latitude,longtitude,accuracy) values (#{userId},#{startTime},#{latitude},#{longtitude},#{accuracy})")
	public void insertSession(UserSession userSession);
	
	@Update("update user_session set end_time=#{endTime} where user_id=#{userId}")
	public void updateUserSession(UserSession userSession);
	
	@Select("select * from user_session where user_id=#{userId} and end_time is null order by session_id desc")
	@Results({
		@Result(id=true, property="", column="session_id"),
		@Result(property="userId", column="user_id"),
		@Result(property="startTime", column="start_time"),
		@Result(property="endTime", column="end_time"),
		@Result(property="latitude", column="latitude"),
		@Result(property="longtitude", column="longtitude"),
		@Result(property="accuracy", column="accuracy"),
		@Result(property="createdDate", column="created_date"),
		@Result(property="lastUpdateDate", column="last_update_date")
	})
	public UserSession selectUserLatestSession(Integer userId);

}

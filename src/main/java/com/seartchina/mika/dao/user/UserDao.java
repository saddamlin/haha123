package com.seartchina.mika.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.seartchina.mika.dao.user.pojo.User;

public interface UserDao {

	@Select("select * from user_info where user_id = #{id}")
	@Results({
			@Result(id=true, property="userId", column="user_id"),
			@Result(property="openId", column="open_id"),
			@Result(property="userName", column="user_name"),
			@Result(property="gender", column="gender"),
			@Result(property="description", column="description"),
			@Result(property="phone", column="phone"),
			@Result(property="dateOfBirth", column="date_of_birth"),
			@Result(property="avatarUrl", column="avatar_url"),
			@Result(property="createdDate", column="created_date"),
			@Result(property="lastUpdateDate", column="last_update_date")
	})
	public User selectUser(Integer id);
	
	@Select("select * from user_info where open_id=#{openId}")
	@Results({
		@Result(id=true, property="userId", column="user_id"),
		@Result(property="openId", column="open_id"),
		@Result(property="userName", column="user_name"),
		@Result(property="gender", column="gender"),
		@Result(property="description", column="description"),
		@Result(property="phone", column="phone"),
		@Result(property="dateOfBirth", column="date_of_birth"),
		@Result(property="avatarUrl", column="avatar_url"),
		@Result(property="createdDate", column="created_date"),
		@Result(property="lastUpdateDate", column="last_update_date")
    })
	public User selectUserByOpenId(String openId);
	
	@Select("select * from user_info where user_name like '%#{openId}%'")
	@Results({
		@Result(id=true, property="userId", column="user_id"),
		@Result(property="openId", column="open_id"),
		@Result(property="userName", column="user_name"),
		@Result(property="gender", column="gender"),
		@Result(property="description", column="description"),
		@Result(property="phone", column="phone"),
		@Result(property="dateOfBirth", column="date_of_birth"),
		@Result(property="avatarUrl", column="avatar_url"),
		@Result(property="createdDate", column="created_date"),
		@Result(property="lastUpdateDate", column="last_update_date")
    })
	public List<User> selectUserByUserName(String userName);

	@Insert("insert into user_info (user_id, open_id, user_name, gender, description, phone, date_of_birth, avatarUrl)"
			+ "values (#{userId}, #{openId}, #{userName}, #{gender}, #{description}, #{phone}, #{dateOfBirth}, #{avatarUrl})")
	@Options(useGeneratedKeys=true, keyProperty="userId")
	public void insertUser(User user);
	
	@Update("update user_info set user_name=#{userName} and gender=#{gender} and description=#{description} and phone=#{phone} and date_of_birth=#{dateOfBirth} and avatar_url=#{avatarUrl} "
			+ "where userId=#{userId}")
	public void updateUser(User user);
	
	@Insert("insert into user_relationship (user_id, friend_id, rel_status) values (#{userId}, #{friendId}, 0}) ")
	public void insertFriend(@Param("userId")Integer userId, @Param("friendId")Integer friendId);
	
	@Update("update user_relationship set status = #{status} where user_id = #{userId} and friend_user_ud = #{friendId}")
	public void updateFriendStatus(@Param("userId")Integer userId, @Param("friendId")Integer friendId, @Param("status")Integer status);
	
}

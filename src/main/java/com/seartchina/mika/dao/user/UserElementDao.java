package com.seartchina.mika.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.seartchina.mika.dao.user.pojo.UserElement;

public interface UserElementDao {
	
	@Select("select * from user_element where user_id=#{userId}")
	@Results({
		@Result(property="userId",column="user_id"),
		@Result(property="elementId",column="element_id"),
		@Result(property="quantity",column="quantity"),
		@Result(property="createdDate",column="created_date"),
		@Result(property="lastUpdateDate",column="last_update_date")
	})
	public List<UserElement> selectUserElementsByUserId(Integer userId);
	
	@Select("select * from user_element where user_id=#{userId} and element_id=#{elementId}")
	@Results({
		@Result(property="userId",column="user_id"),
		@Result(property="elementId",column="element_id"),
		@Result(property="quantity",column="quantity"),
		@Result(property="createdDate",column="created_date"),
		@Result(property="lastUpdateDate",column="last_update_date")
	})
	public UserElement selectUserElement(@Param("userId")Integer userId, @Param("elementId")Integer elementId);
	
	@Insert("insert into user_element(user_id,element_id,quantity) values (#{userId},#{elementId),#{quantity}")
	public void insertUserElement(UserElement userElement);
	
	@Update("update user_element set quantity=#{quantity} where user_id=#{userId} and element_id=#{elementId}")
	public void updateUserElement(UserElement userElement);

}

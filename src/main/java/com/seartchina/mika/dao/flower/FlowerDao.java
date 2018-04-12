package com.seartchina.mika.dao.flower;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.seartchina.mika.dao.flower.pojo.Flower;

public interface FlowerDao {
	
	@Select("select * from flower_info where flower_id=#{id}")
	@Results({
		@Result(id=true,property="flowerId",column="flower_id"),
		@Result(property="userId",column="user_id"),
		@Result(property="flowerStatus",column="flower_status"),
		@Result(property="flowerLevel",column="flower_level"),
		@Result(property="flowerExp",column="flower_exp"),
		@Result(property="createdDate",column="created_date"),
		@Result(property="lastUpdateDate",column="last_update_date"),
	})
	public Flower selectFlowerById(Integer id);
	
	@Select("select * from flower_info where user_id=#{userId}")
	@Results({
		@Result(id=true,property="flowerId",column="flower_id"),
		@Result(property="userId",column="user_id"),
		@Result(property="flowerStatus",column="flower_status"),
		@Result(property="flowerLevel",column="flower_level"),
		@Result(property="flowerExp",column="flower_exp"),
		@Result(property="createdDate",column="created_date"),
		@Result(property="lastUpdateDate",column="last_update_date"),
	})
	public List<Flower> selectFlowersByUserId(Integer userId);
	
	@Insert("insert into flower_info(user_id,flower_status,flower_level,flower_exp) values(#{userId},#{flowerStatus},#{flowerLevel},#{flowerExp})")
	@Options(useGeneratedKeys=true, keyProperty="flowerId")
	public void insertFlower(Flower flower);

}

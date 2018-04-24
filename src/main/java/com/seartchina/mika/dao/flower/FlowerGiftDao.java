package com.seartchina.mika.dao.flower;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.seartchina.mika.dao.flower.pojo.FlowerGift;

public interface FlowerGiftDao {
	
	@Select("select * from flower_gift where gift_id=#{giftId}")
	@Results({
		@Result(id=true, property="giftId", column="gift_id"),
		@Result(property="flowerId", column="flower_id"),
		@Result(property="userId", column="user_id"),
		@Result(property="giftType", column="gift_type"),
		@Result(property="giftDetails", column="gift_details"),
		@Result(property="giftStatus", column="gift_status"),
		@Result(property="createdDate", column="created_date"),
		@Result(property="lastUpdateDate", column="last_update_date")
	})
	public FlowerGift selectFlowerGiftById(Integer giftId);
	
	@Select("select * from flower_gift where user_id=#{userId}")
	@Results({
		@Result(id=true, property="giftId", column="gift_id"),
		@Result(property="flowerId", column="flower_id"),
		@Result(property="userId", column="user_id"),
		@Result(property="giftType", column="gift_type"),
		@Result(property="giftDetails", column="gift_details"),
		@Result(property="giftStatus", column="gift_status"),
		@Result(property="createdDate", column="created_date"),
		@Result(property="lastUpdateDate", column="last_update_date")
	})
	public List<FlowerGift> selectFlowerGiftByUserId(Integer userId);
	
	@Insert("insert into flowerGift(flower_id,user_id,gift_type,gift_details,gift_status) values(#{flowerId},#{userId},#{giftType},#{giftDetails},#{giftStatus})")
	@Options(useGeneratedKeys=true, keyProperty="giftId")
	public void insertFlowerGift(FlowerGift flowerGift);
	
	@Update("update flower_gift set gift_status=#{giftStatus} where gift_id=#{giftId}")
	public void updateFlowerGiftStatus(@Param("giftId")Integer giftId, @Param("giftStatus")Integer giftStatus);
	
	@Update("update flower_gift set user_id=#{userId} where gift_id=#{giftId}")
	public void updateFlowerGiftOwner(@Param("giftId")Integer giftId, @Param("userId")Integer userId);


}

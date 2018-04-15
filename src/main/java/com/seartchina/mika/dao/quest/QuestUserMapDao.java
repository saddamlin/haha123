package com.seartchina.mika.dao.quest;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.seartchina.mika.dao.quest.pojo.QuestUserMap;

public interface QuestUserMapDao {
	
	@Select("select * from quest_user_map where quest_id=#{questId}")
	@Results({
		@Result(property="questId",column="quest_id"),
		@Result(property="userId",column="user_id"),
		@Result(property="userType",column="user_type"),
		@Result(property="userStatus",column="user_status"),
		@Result(property="elementId",column="element_id"),
		@Result(property="quantity",column="quantity"),
		@Result(property="createdDate",column="created_date"),
		@Result(property="lastUpdateDate",column="last_update_date")
	})
	public List<QuestUserMap> selectQuestUserMapsByQuestId(Long questId);
	
	@Insert("insert into quest_user_map(quest_id,user_id,user_type,user_status,element_id,quantity)"
			+ "values (#{questId},#{userId},#{userType},#{userStatus},#{elementId},#{quantity})")
	public void insertQuestUserMap(QuestUserMap questUserMap);
	
	@Update("update quest_user_map set element_id=#{elementId},quantity=#{quantity} where quest_id=#{questId} and user_id=#{userId}")
	public void updateQuestUserMap(QuestUserMap questUserMap);

}

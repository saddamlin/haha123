package com.seartchina.mika.dao.quest;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.seartchina.mika.dao.quest.pojo.Quest;

public interface QuestDao {
	
	@Select("select * from quest_info where quest_id=#{questId}")
	@Results({
		@Result(id=true, property="questId", column="quest_id"),
		@Result(property="questType", column="quest_type"),
		@Result(property="questStatus", column="quest_status"),
		@Result(property="createdDate", column="created_date"),
		@Result(property="lastUpdateDate", column="last_update_date"),
		@Result(property="questUserMaps", column="quest_id"
		, many=@Many(select="com.seartchina.mika.dao.quest.QuestUserMapDao.selectQuestUserMapsByQuestId") )
	})
	public Quest selectQuestById(Integer questId);
	
	@Insert("insert into quest_info(quest_id,quest_type,quest_status) values(#{questId},#{questType},#{questStatus})")
	@Options(useGeneratedKeys=true, keyProperty="questId")
	public void insertQuest(Quest quest);
	
	@Update("update quest_info set quest_status=#{questStatus} where quest_id=#{questId}")
	public void updateQuest(Quest quest);
	
}

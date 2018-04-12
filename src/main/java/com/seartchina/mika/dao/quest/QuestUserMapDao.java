package com.seartchina.mika.dao.quest;

import java.util.List;

import com.seartchina.mika.dao.quest.pojo.QuestUserMap;

public interface QuestUserMapDao {
	
	
	public List<QuestUserMap> selectQuestUserMapsByQuestId(Long questId);

}

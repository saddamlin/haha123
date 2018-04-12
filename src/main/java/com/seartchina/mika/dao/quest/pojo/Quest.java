package com.seartchina.mika.dao.quest.pojo;

import java.util.Date;
import java.util.List;

public class Quest {
	
	private Integer questId;
	private Integer questType;
	private Integer questStatus;
	private Date createdDate;
	private Date lastUpdateDate;
	private List<QuestUserMap> questUserMaps;
	public Integer getQuestId() {
		return questId;
	}
	public void setQuestId(Integer questId) {
		this.questId = questId;
	}
	public Integer getQuestType() {
		return questType;
	}
	public void setQuestType(Integer questType) {
		this.questType = questType;
	}
	public Integer getQuestStatus() {
		return questStatus;
	}
	public void setQuestStatus(Integer questStatus) {
		this.questStatus = questStatus;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public List<QuestUserMap> getQuestUserMaps() {
		return questUserMaps;
	}
	public void setQuestUserMaps(List<QuestUserMap> questUserMaps) {
		this.questUserMaps = questUserMaps;
	}

}

package com.seartchina.mika.dao.flower;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.seartchina.mika.dao.flower.pojo.FlowerElement;

public interface FlowerElementDao {
	
	@Select("select * from flower_element where flower_id=#{flowerId}")
	@Results({
		@Result(property="flowerId",column="flower_id"),
		@Result(property="elementId",column="element_id"),
		@Result(property="quantity",column="quantity"),
		@Result(property="createdDate",column="created_date"),
		@Result(property="lastUpdateDate",column="last_update_date")
	})
	public List<FlowerElement> selectFlowerElementsByFlowerId(Integer flowerId);
	
	@Select("select * from flower_element where flower_id=#{flowerId} and element_id=#{elementId}")
	@Results({
		@Result(property="flowerId",column="flower_id"),
		@Result(property="elementId",column="element_id"),
		@Result(property="quantity",column="quantity"),
		@Result(property="createdDate",column="created_date"),
		@Result(property="lastUpdateDate",column="last_update_date")
	})
	public FlowerElement selectFlowerElementsByFlowerIdAndElementId(@Param("flowerId")Integer flowerId, @Param("elementId")Integer elementId);
	
	@Insert("insert into flower_element(flower_id,element_id,quantity) values (#{flowerId},#{elementId},#{quantity})")
	public void insertFlowerElement(FlowerElement flowerElement);
	
	@Update("update flower_element set quantity=#{quantity} where flower_id=#{flowerId} and element_id=#{elementId}")
	public void updateFlowerElement(FlowerElement flowerElement);

}

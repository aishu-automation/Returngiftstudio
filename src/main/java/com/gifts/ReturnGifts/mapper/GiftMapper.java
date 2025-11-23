package com.gifts.ReturnGifts.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.gifts.ReturnGifts.model.Gift;

@Mapper
public interface GiftMapper {
	
	  @Select("SELECT * FROM gifts")
	    List<Gift> getAllGifts();

	    @Select("SELECT * FROM gifts WHERE id = #{id}")
	    Gift getGiftById(int id);

}

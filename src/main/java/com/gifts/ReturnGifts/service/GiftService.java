package com.gifts.ReturnGifts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gifts.ReturnGifts.mapper.GiftMapper;
import com.gifts.ReturnGifts.model.Gift;

@Service
public class GiftService {
	
	 @Autowired
	    private GiftMapper giftMapper;

	    public List<Gift> getAllGifts() { return giftMapper.getAllGifts(); }

	    public Gift getGiftById(int id) { return giftMapper.getGiftById(id); }
	

}
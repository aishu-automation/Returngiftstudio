package com.gifts.ReturnGifts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gifts.ReturnGifts.model.Gift;
import com.gifts.ReturnGifts.service.GiftService;



@RestController
@RequestMapping("/api/gifts")
// Allow both localhost and your IP for development
@CrossOrigin(origins = {"http://localhost:3000", "http://10.10.10.126:3000"})
public class GiftController {
    
    @Autowired
    private GiftService giftService;

    @GetMapping
    public List<Gift> getGifts() {
        return giftService.getAllGifts();
    }

    @GetMapping("/{id}")
    public Gift getGift(@PathVariable int id) {
        return giftService.getGiftById(id);
    }

}

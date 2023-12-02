package com.tomjun.tomjunmenuservice.service;

import com.tomjun.tomjunmenuservice.entity.CartItem;
import com.tomjun.tomjunmenuservice.util.KafkaConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private KafkaTemplate<String, List<CartItem>> kafkaTemplate;

    public void submit(Long cartId) {
//        fetch cart from db

        CartItem c1 = new CartItem();
        c1.setMenuId(1L);
        c1.setQuantity(5);
        c1.setRemarks("Less sugar");
        List<CartItem> cartItems = List.of(c1);

        kafkaTemplate.send(KafkaConstants.TOMJUN_ORDER, cartItems);
    }
}

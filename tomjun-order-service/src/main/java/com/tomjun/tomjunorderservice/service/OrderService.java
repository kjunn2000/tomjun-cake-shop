package com.tomjun.tomjunorderservice.service;

import com.tomjun.tomjunorderservice.entity.OrderItem;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @KafkaListener(topics = "tomjun-order", groupId = "tomjun-order-g1", containerFactory = "orderItemListener")
    private void getOrder(List<OrderItem> orderItemList) {
        orderItemList.forEach(
                i -> {
                    System.out.printf("Menu Id: %s", i.getMenuId());
                    System.out.printf("Quantity: %d", i.getQuantity());
                    System.out.printf("Remark: %s", i.getRemarks());
                }
        );
    }
}

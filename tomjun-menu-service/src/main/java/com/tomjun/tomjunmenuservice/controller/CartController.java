package com.tomjun.tomjunmenuservice.controller;

import com.tomjun.tomjunmenuservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/{cartId}")
    public ResponseEntity<String> submitCart(@PathVariable Long cartId) {
        cartService.submit(cartId);
        return new ResponseEntity<>("Cart ID: 120 is submitted.", HttpStatus.OK);
    }
}

package com.tomfrank.PetFuneral.controller;

import com.tomfrank.PetFuneral.dto.*;
import com.tomfrank.PetFuneral.service.ShopService;
import com.tomfrank.PetFuneral.util.JwtUtil;
import com.tomfrank.PetFuneral.util.ResponseWrapper;
import io.jsonwebtoken.Claims;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/shop")
@CrossOrigin(origins = "http://49.232.9.128")
public class ShopController {

    private final ShopService shopService;
    private final JwtUtil jwtUtil;

    @Autowired
    public ShopController(ShopService shopService, JwtUtil jwtUtil) {
        this.shopService = shopService;
        this.jwtUtil = jwtUtil;
    }

    // 商品购买接口
    @PostMapping("/buy")
    public ResponseWrapper<Void> buy(@RequestHeader("Authorization") String authHeader,
                                     @Validated @RequestBody BuyRequest req) {
        String token = authHeader.replace("Bearer", "");
        Claims claims = jwtUtil.parseToken(token);
        Integer userId = Integer.valueOf(claims.getSubject());
        req.setUserId(userId);
        shopService.buy(req);
        return ResponseWrapper.ok();
    }

    // 查询商品库存接口
    @GetMapping("/query")
    public ResponseWrapper<Integer> query(@Validated QueryRequest req) {
        int stock = shopService.query(req);
        return ResponseWrapper.ok(stock);
    }
}
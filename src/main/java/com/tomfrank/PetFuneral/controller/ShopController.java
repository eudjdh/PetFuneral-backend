package com.tomfrank.PetFuneral.controller;

import com.tomfrank.PetFuneral.dto.*;
import com.tomfrank.PetFuneral.service.ShopService;
import com.tomfrank.PetFuneral.util.ResponseWrapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/shop")
@CrossOrigin(origins = "http://localhost:8080")
public class ShopController {

    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    // 商品购买接口
    @PostMapping("/buy")
    public ResponseWrapper<Void> buy(@Validated @RequestBody BuyRequest req) {
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
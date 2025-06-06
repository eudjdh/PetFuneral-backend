package com.tomfrank.PetFuneral.controller;

import com.tomfrank.PetFuneral.dto.*;
import com.tomfrank.PetFuneral.service.UserService;
import com.tomfrank.PetFuneral.util.ResponseWrapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://49.232.9.128")
public class AuthController {

    private final UserService userService;
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseWrapper<Void> register(
            @Validated @RequestBody RegisterRequest req) {
        userService.register(req);
        return ResponseWrapper.ok();
    }

    @PostMapping("/login")
    public ResponseWrapper<String> login(
            @Validated @RequestBody LoginRequest req) {
        String token = userService.login(req);
        return ResponseWrapper.ok(token);
    }
}

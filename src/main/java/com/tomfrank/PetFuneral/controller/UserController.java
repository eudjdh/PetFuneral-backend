package com.tomfrank.PetFuneral.controller;

import com.tomfrank.PetFuneral.dto.*;
import com.tomfrank.PetFuneral.service.UserService;
import com.tomfrank.PetFuneral.util.JwtUtil;
import com.tomfrank.PetFuneral.util.ResponseWrapper;
import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://49.232.9.128")
public class UserController {
    private final UserService userService;
    private final JwtUtil jwtUtil; // 1. 声明jwtUtil为成员变量

    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/profile")
    public ResponseWrapper<UserProfileVO> profile(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        Claims claims = jwtUtil.parseToken(token);
        Integer userId = Integer.valueOf(claims.getSubject());
        return ResponseWrapper.ok(userService.getProfile(userId));
    }
}

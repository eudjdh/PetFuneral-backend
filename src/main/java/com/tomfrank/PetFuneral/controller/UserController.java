package com.tomfrank.PetFuneral.controller;

import com.tomfrank.PetFuneral.dto.*;
import com.tomfrank.PetFuneral.service.UserService;
import com.tomfrank.PetFuneral.util.ResponseWrapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) { this.userService = userService; }

    @GetMapping("/profile")
    public ResponseWrapper<UserProfileVO> profile(
            @RequestAttribute("userId") Integer userId) {
        return ResponseWrapper.ok(userService.getProfile(userId));
    }
}

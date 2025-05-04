package com.tomfrank.PetFuneral.service;

import com.tomfrank.PetFuneral.dto.*;

public interface UserService {
    void register(RegisterRequest req);
    String login(LoginRequest req);            // 返回 JWT token
    UserProfileVO getProfile(Integer userId);
}

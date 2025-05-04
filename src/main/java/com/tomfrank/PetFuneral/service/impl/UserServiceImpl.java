package com.tomfrank.PetFuneral.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tomfrank.PetFuneral.dto.*;
import com.tomfrank.PetFuneral.entity.User;
import com.tomfrank.PetFuneral.exception.BusinessException;
import com.tomfrank.PetFuneral.mapper.UserMapper;
import com.tomfrank.PetFuneral.service.UserService;
import com.tomfrank.PetFuneral.util.JwtUtil;
import com.tomfrank.PetFuneral.util.PasswordEncoderUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.BeanUtils;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final JwtUtil jwtUtil;

    public UserServiceImpl(UserMapper userMapper, JwtUtil jwtUtil) {
        this.userMapper = userMapper;
        this.jwtUtil = jwtUtil;
    }

    @Override
    @Transactional
    public void register(RegisterRequest req) {
        if (userMapper.selectCount(
                new QueryWrapper<User>().eq("username", req.getUsername())) > 0) {
            throw new BusinessException("用户名已存在");
        }

        User u = new User();
        BeanUtils.copyProperties(req, u);
        // 对密码加盐哈希
        String hash = PasswordEncoderUtil.hash(req.getPassword());
        u.setPassword(hash);

        userMapper.insert(u);
    }

    @Override
    public String login(LoginRequest req) {
        User u = userMapper.selectOne(
                new QueryWrapper<User>().eq("username", req.getUsername()));
        if (u == null || !PasswordEncoderUtil.matches(req.getPassword(), u.getPassword())) {
            throw new BusinessException("用户名或密码错误");
        }
        // 生成 JWT，载荷可放 userId、username
        return jwtUtil.generateToken(u.getUserId(), u.getUsername());
    }

    @Override
    public UserProfileVO getProfile(Integer userId) {
        User u = userMapper.selectById(userId);
        if (u == null) throw new BusinessException("用户不存在");
        UserProfileVO vo = new UserProfileVO();
        BeanUtils.copyProperties(u, vo);
        return vo;
    }
}

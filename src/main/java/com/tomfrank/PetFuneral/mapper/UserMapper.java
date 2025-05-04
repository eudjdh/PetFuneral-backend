package com.tomfrank.PetFuneral.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tomfrank.PetFuneral.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    // 如果用纯 MyBatis，可写手动 SQL：
    // @Insert("INSERT INTO user(...) VALUES(...)")
    // int insertUser(User user);
    //
    // @Select("SELECT * FROM user WHERE username=#{username}")
    // User findByUsername(String username);
}

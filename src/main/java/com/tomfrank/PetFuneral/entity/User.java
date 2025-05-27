package com.tomfrank.PetFuneral.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@TableName("user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @TableId("user_id")
    private Integer userId;
    private String username;    // 对应 username 列
    private String password;
    private String realName;    // 需开启驼峰映射或用 @TableField("real_name")
    private String phone;
    private String email;
    private String address;
}

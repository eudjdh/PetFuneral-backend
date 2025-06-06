package com.tomfrank.PetFuneral.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    @TableId("pet_id")
    private Integer petId;
    private Integer userId;
    private String name;
    private String species;
    private String breed;
    private Date birthDate;
    private Date deathDate;
    private String photoUrl;
}

package com.tomfrank.PetFuneral;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tomfrank.PetFuneral.mapper")
public class PetFuneralApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetFuneralApplication.class, args);
	}

}

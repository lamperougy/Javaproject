package com.tmf.bbs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan("com.tmf.bbs.dao")
public class BBSMainApplication {
	public static void main(String[] args) {
		SpringApplication.run(BBSMainApplication.class, args);
	}
}

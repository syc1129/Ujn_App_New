package com.lssl.medical;

/**
 * @author : 黑渊白花
 * @ClassName MedicalApplication
 * @date : 2024/9/19 18:19
 * @Description
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.lssl.medical")
@EnableTransactionManagement
public class MedicalApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicalApplication.class, args);
    }

}
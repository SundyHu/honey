package io.ryan.honey.demo;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * DemoServiceApplication
 *
 * @author hkc
 * @version 1.0.0
 * @date 2021-08-09 10:31
 */
@SpringBootApplication
@EnableKnife4j
public class DemoServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoServiceApplication.class, args);
    }
}

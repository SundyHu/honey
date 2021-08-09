package io.ryan.honey.comment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * HoneyCommentServiceApplication
 *
 * @author hkc
 * @version 1.0.0
 * @date 2021-08-09 15:27
 */
@SpringBootApplication
@EnableDiscoveryClient
public class HoneyCommentServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(HoneyCommentServiceApplication.class, args);
    }
}

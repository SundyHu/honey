package io.ryan.honey.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * HoneyGatewayApplication
 *
 * @author hkc
 * @version 1.0.0
 * @date 2021-08-09 14:16
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableWebFlux
public class HoneyGatewayApplication {

    public static void main(String[] args) {

        SpringApplication.run(HoneyGatewayApplication.class, args);
    }
}

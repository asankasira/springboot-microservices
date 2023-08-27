package org.asankasi.javaguide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {
//    @Bean
//    public RestTemplate getRestTemplate() {
//        return new RestTemplate();
//    }
//    @Bean
//    public WebClient retrieveWebClient() {
//        return WebClient.builder().build();
//    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }

}

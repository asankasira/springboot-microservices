package org.asankasi.javaguide.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("users/message")
public class MessageController {

    @Value("${spring.boot.message}")
    private String message;

    @GetMapping
    public String getServiceMessage() {
        return message;
    }
}

package com.next.app.api.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "Hello Controller", description = "테스트 김아람")
public class HelloController {

    @GetMapping("/hello")
    @Operation(summary = "Hello - 변경 되었는지 확인", description = "하이")
    public String hello() {
        return "Hello, Spring Boot with Swagger!";
    }
} 
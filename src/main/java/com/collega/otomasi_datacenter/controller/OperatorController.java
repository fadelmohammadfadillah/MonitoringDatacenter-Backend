package com.collega.otomasi_datacenter.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequiredArgsConstructor
public class OperatorController {
    @GetMapping("/api/operator/hello")
    public String helloOperator() {
        return "hello, operator!";
    }
}

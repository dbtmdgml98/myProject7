package com.example.demo.entity;

import lombok.Getter;

@Getter
public enum UserStatus {
    NORMAL("normal"),
    BLOCKED("blocked");

    private final String status;

    UserStatus(String status) {
        this.status = status;
    }
}


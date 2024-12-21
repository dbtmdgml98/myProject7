package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "`user`")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String nickname;
    private String password;

    @Enumerated(value = EnumType.STRING)
    private UserStatus userStatus; // NORMAL, BLOCKED

    @Enumerated(value = EnumType.STRING)
    private Role role = Role.USER;  // USER, ADMIN

    public User(String role, String email, String nickname, String password) {
        this.role = Role.of(role);
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }

    public User() {}

    public void updateStatusToBlocked() {
        this.userStatus = UserStatus.BLOCKED;
    }

    public void updateStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }
}

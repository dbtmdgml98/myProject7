package com.example.demo.dto;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private String email;
    private String nickname;
    private Role role;

    public UserResponseDto(String email, String nickname, Role role) {
        this.email = email;
        this.nickname = nickname;
        this.role = role;
    }

    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(user.getEmail(),
                user.getNickname(),
                user.getRole()
        );
    }

}

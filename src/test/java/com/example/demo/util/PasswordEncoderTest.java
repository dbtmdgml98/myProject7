package com.example.demo.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PasswordEncoderTest {

    @Test
    void encode() {
        // Given: 원본 비밀번호
        String rawPassword = "Aaaa123!";

        // When: 암호화된 비밀번호
        String encodedPassword = PasswordEncoder.encode(rawPassword);

        // Then: 암호화된 비밀번호가 NULL인지 확인하고, 원본 비밀번호와 같은지 확인
        assertThat(encodedPassword).isNotNull();
        assertThat(encodedPassword).isNotEqualTo(rawPassword);
    }

    @Test
    void matches() {
        // Given: 원본 비밀번호와 암호화된 비밀번호
        String rawPassword = "Aaaa123!";
        String encodedPassword = PasswordEncoder.encode(rawPassword);

        // When: 원본과 암호화된 비밀번호 비교
        boolean matches = PasswordEncoder.matches(rawPassword, encodedPassword);

        // Then: 결과 검증 (일치)
        assertThat(matches).isTrue();
    }

    @Test
    void matchesWitchWrongPassword() {
        // Given: 잘못된 비밀번호와 암호화된 비밀번호
        String rawPassword = "Aaaa123!";
        String wrongPassword = "wrongPassword";
        String encodedPassword = PasswordEncoder.encode(rawPassword);

        // When: 잘못된 비밀번호화 암호화된 비밀번호 비교
        boolean matches = PasswordEncoder.matches(wrongPassword, encodedPassword);

        // Then:  결과 검증 (불일치)
        assertThat(matches).isFalse();
    }
}

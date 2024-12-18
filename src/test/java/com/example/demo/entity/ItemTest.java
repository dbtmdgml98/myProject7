package com.example.demo.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void ItemConstructorAndGetters() {  // 사용자 정의 생성자 검증

        // Given
        String name = "아이템 이름";
        String description = "아이템 설명";
        User owner = new User();
        User manager = new User();

        // When
        Item item = new Item(name, description, manager, owner);

        // Then
        assertEquals(name, item.getName());
        assertEquals(description, item.getDescription());
        assertEquals(owner, item.getOwner());
        assertEquals(manager, item.getManager());
        assertNull(item.getStatus());
//        assertEquals("PENDING", item.getStatus());    // 단위 테스트이므로 데이터베이스와 상호작용하지 않아 item.getStatus()가 null값이어서 예외가 발생한다.
    }

    @Test
    void ItemDefaultConstructor() { // 기본 생성자 검증

        // When
        Item item = new Item();

        // Then
        assertNull(item.getName());
        assertNull(item.getDescription());
        assertNull(item.getManager());
        assertNull(item.getOwner());
        assertNull(item.getStatus());
    }
}

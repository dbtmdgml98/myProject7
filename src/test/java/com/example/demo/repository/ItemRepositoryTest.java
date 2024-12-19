package com.example.demo.repository;

import com.example.demo.config.JPAConfiguration;
import com.example.demo.entity.Item;
import com.example.demo.entity.User;
import com.example.demo.entity.UserStatus;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(JPAConfiguration.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;  // Item 과 User 의 연관관계로 인하여 참조하기 위해 주입

    @Autowired
    private EntityManager em;   // EntityManager 주입

    @Test
    void saveItemAndDefaultStatus() {
        // Given
        String name = "아이템 이름";
        String description = "아이템 설명";

        // User 객체 생성 및 저장
        User owner = new User("user", "owner@email.com", "닉네임", "비밀번호");
        owner.updateStatus(UserStatus.NORMAL);
        User manager = new User("user", "manager@email.com", "닉네임2", "비밀번호2");
        manager.updateStatus(UserStatus.NORMAL);
        User savedOwner = userRepository.save(owner);
        User savedManager = userRepository.save(manager);

        // Item 객체 생성
        Item item = new Item(name, description, savedOwner, savedManager);  // status 값 안 보냄 -> null

        // When
        Item savedItem = itemRepository.save(item); // 영속성 컨텍스트에서도 null

        em.refresh(savedItem);  // flush 될 때 DB에 기본값 PENDING 들어가고, refresh 통해서 영속성 컨텍스트도 null에서 PENDING으로 바뀐다.

        Item foundItem = itemRepository.findById(savedItem.getId()).orElseThrow();

        // Then
        assertThat(foundItem.getId()).isNotNull();
        assertThat(foundItem.getStatus()).isEqualTo("PENDING");
    }
}
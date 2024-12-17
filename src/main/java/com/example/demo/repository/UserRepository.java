package com.example.demo.repository;

import com.example.demo.entity.User;
import com.example.demo.entity.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // 재사용 비중이 높은 findById 함수들을 default 메소드로 선언
    default User findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new IllegalArgumentException("해당 ID에 맞는 값이 존재하지 않습니다."));
    }

    User findByEmail(String email);

//    List<User> findByIdIn(List<Long> userIds);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE User u SET u.userStatus = :userStatus WHERE u.id IN :ids")
    void updateStatusByIdAndStatus(@Param("ids") List<Long> ids, UserStatus userStatus);
}

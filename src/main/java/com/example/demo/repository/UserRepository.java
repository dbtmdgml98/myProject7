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

    User findByEmail(String email);

//    List<User> findByIdIn(List<Long> userIds);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE User u SET u.userStatus = :status WHERE u.id IN :ids")
    void updateStatusByIdAndStatus(@Param("ids") List<Long> ids, UserStatus userStatus);
}

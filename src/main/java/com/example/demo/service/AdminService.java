package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserBatchRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminService {
    private final UserRepository userRepository;
    private final UserBatchRepository userBatchRepository;

    public AdminService(UserRepository userRepository, UserBatchRepository userBatchRepository) {
        this.userRepository = userRepository;
        this.userBatchRepository = userBatchRepository;
    }

    // TODO: 4. find or save 예제 개선
    @Transactional
    public void reportUsers(List<Long> userIds) {
        // userIds 안에 id가 3개인 경우

        // 조회 및 저장 쿼리 6번(조회 3번 + 수정 3번)
//        for (Long userId : userIds) {
//            User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("해당 ID에 맞는 값이 존재하지 않습니다."));
//
//            user.updateStatusToBlocked();
//
//            userRepository.save(user);
//        }

        // 리스트로 들어온 id들로 user 한번에 찾기 (조회 쿼리 1번)
//        List<User> foundUser = userRepository.findByIdIn(userIds);

        // 한번에 상태 변경 및 저장 (수정 쿼리 1번)
        userRepository.updateStatusByIdAndStatus(userIds,"Blocked");

//        // 각각 상태 변경 (수정 쿼리 3번)
//        for (User user : foundUser) {
//            user.updateStatusToBlocked();
//        }

        // 한번에 저장
//        userBatchRepository.batchInsert(foundUser);
    }
}

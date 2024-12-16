package com.example.demo.repository;

import com.example.demo.entity.QItem;
import com.example.demo.entity.QReservation;
import com.example.demo.entity.QUser;
import com.example.demo.entity.Reservation;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ReservationRepositoryQueryImpl implements ReservationRepositoryQuery{

    private final JPAQueryFactory jpaQueryFactory;

    // QueryDSL Q클래스
    QReservation qReservation = QReservation.reservation;
    QUser quser = QUser.user;
    QItem qItem = QItem.item;

    @Override
    public List<Reservation> findReservations(Long user_id, Long item_id) {

        // 동적 쿼리
        return jpaQueryFactory
                .selectFrom(qReservation)
                .join(qReservation.user,quser).fetchJoin()
                .join(qReservation.item,qItem).fetchJoin()
                .where(userIdEq(user_id), itemIdEq(item_id))
                .fetch();
    }

    private BooleanExpression userIdEq(Long user_id) {
        if (user_id == null) {
            return null;
        }

        return qReservation.user.id.eq(user_id);
    }

    private BooleanExpression itemIdEq(Long item_id) {
        if (item_id == null) {
            return null;
        }

        return qReservation.item.id.eq(item_id);
    }
}

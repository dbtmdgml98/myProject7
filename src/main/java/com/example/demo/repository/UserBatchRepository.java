/*
package com.example.demo.repository;


import com.example.demo.entity.User;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserBatchRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserBatchRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<User> user) {

        String sql =  "INSERT INTO user (status) " + "VALUES(?) ";

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                User founduser = user.get(i);
                ps.setString(1, founduser.getStatus());
            }

            @Override
            public int getBatchSize() {
                 return user.size();
            }
        });
    }
}
 */

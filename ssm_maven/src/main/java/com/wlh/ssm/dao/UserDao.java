package com.wlh.ssm.dao;

import com.wlh.ssm.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    List<User> findAll();
}

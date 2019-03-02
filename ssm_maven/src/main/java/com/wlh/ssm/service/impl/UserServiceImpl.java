package com.wlh.ssm.service.impl;


import com.wlh.ssm.dao.UserDao;
import com.wlh.ssm.domain.User;
import com.wlh.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author wlh
 * @Date 2019/2/26 10:05
 **/
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}

package com.wlh.ssm.ssm_service;

import com.wlh.ssm.domain.User;
import com.wlh.ssm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ClassName ServiceTest
 * @Description TODO
 * @Author wlh
 * @Date 2019/3/1 17:36
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:*.xml"})
public class ServiceTest {

    @Autowired
    private UserService userService;
    @Test
    public void test1() {
        List<User> users = userService.findAll();
        for (User user : users) {
            System.out.println(user);
        }

    }
}
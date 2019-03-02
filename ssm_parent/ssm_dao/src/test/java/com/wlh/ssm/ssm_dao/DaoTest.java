package com.wlh.ssm.ssm_dao;

import com.wlh.ssm.dao.UserDao;
import com.wlh.ssm.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ClassName myTest
 * @Description TODO
 * @Author wlh
 * @Date 2019/3/1 17:26
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:*.xml"})
public class DaoTest {

    @Autowired
    private UserDao userDao;
    @Test
    public void test1() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }

    }
}
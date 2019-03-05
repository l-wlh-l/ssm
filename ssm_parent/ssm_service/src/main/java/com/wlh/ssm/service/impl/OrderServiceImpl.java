package com.wlh.ssm.service.impl;

import com.wlh.ssm.dao.OrderDao;
import com.wlh.ssm.domain.Order;
import com.wlh.ssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author wlh
 * @Date 2019/3/5 15:30
 **/
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Override
    public void save(Order order) {
        orderDao.save(order);
    }
}

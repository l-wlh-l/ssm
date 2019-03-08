package com.wlh.ssm.service;

import com.wlh.ssm.domain.Order;
import com.wlh.ssm.domain.PageBean;

import java.util.List;

public interface OrderService {
    List<Order> findAll();

    void save(Order order);

    PageBean<Order> findByPage(Integer pageNumber, Integer pageSize);
}

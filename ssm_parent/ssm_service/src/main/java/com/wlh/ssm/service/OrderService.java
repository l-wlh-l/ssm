package com.wlh.ssm.service;

import com.wlh.ssm.domain.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();

    void save(Order order);
}

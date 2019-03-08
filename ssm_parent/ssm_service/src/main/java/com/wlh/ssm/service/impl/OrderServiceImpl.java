package com.wlh.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wlh.ssm.dao.OrderDao;
import com.wlh.ssm.domain.Order;
import com.wlh.ssm.domain.PageBean;
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

    @Override
    public PageBean<Order> findByPage(Integer pageNumber, Integer pageSize) {
        PageBean<Order> pageBean = new PageBean<>();
        pageBean.setPageNumber(pageNumber);
        pageBean.setPageSize(pageSize);
        PageHelper.startPage(pageNumber,pageSize);
        List<Order> orderList = findAll();
        PageInfo<Order> pageInfo = new PageInfo<>(orderList);
        long total = pageInfo.getTotal();
        pageBean.setTotalCount(total);
        int pages = pageInfo.getPages();
        pageBean.setTotalPage(pages);
        List<Order> orders = pageInfo.getList();
        pageBean.setPageList(orderList);
        return pageBean;
    }
}

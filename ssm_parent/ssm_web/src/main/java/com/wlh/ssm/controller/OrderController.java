package com.wlh.ssm.controller;

import com.wlh.ssm.domain.Order;
import com.wlh.ssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author wlh
 * @Date 2019/3/5 15:31
 **/
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Order> orders = orderService.findAll();
        model.addAttribute("orders",orders);
        return "order-list";
    }
}

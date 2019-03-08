package com.wlh.ssm.controller;

import com.wlh.ssm.domain.Order;
import com.wlh.ssm.domain.PageBean;
import com.wlh.ssm.domain.Product;
import com.wlh.ssm.service.OrderService;
import com.wlh.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    private ProductService productService;
    @Autowired
    private OrderService orderService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Order> orders = orderService.findAll();
        model.addAttribute("orders",orders);
        return "order-list";
    }

    @RequestMapping("/addOrderUI")
    public String addOrderUI(Model model){
        List<Product> plist = productService.findAll();
        model.addAttribute("plist",plist);
        return "order-add";
    }
    @RequestMapping("/save")
    public String save(Order order){
        orderService.save(order);
        return "redirect:/order/findByPageHelper";
    }

    @RequestMapping("findByPageHelper")
    public String findByPage(@RequestParam(defaultValue = "1") Integer pageNumber,
                             @RequestParam(defaultValue = "2") Integer pageSize,Model model){

        PageBean<Order> orderList = orderService.findByPage(pageNumber,pageSize);

        System.out.println(orderList);

        model.addAttribute("pageBean",orderList);

        return "order-list";
    }
}

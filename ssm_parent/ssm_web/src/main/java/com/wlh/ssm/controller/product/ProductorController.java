package com.wlh.ssm.controller.product;

import com.wlh.ssm.domain.Product;
import com.wlh.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName ProductorController
 * @Description TODO
 * @Author wlh
 * @Date 2019/3/1 21:16
 **/
@Controller
@RequestMapping("product")
public class ProductorController {

    @Autowired
    private ProductService productService;
    @RequestMapping("findAll")
    public String findAll(Model model){


        List<Product> products = productService.findAll();
        model.addAttribute("products",products);

        return "/product/list";
    }
}

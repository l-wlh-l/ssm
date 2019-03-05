package com.wlh.ssm.controller;

import com.wlh.ssm.domain.Product;
import com.wlh.ssm.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @ClassName ProductController
 * @Description TODO
 * @Author wlh
 * @Date 2019/3/4 20:18
 **/
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        //产品结果集
        model.addAttribute("products",productService.findAll());
        //跳转视图
        return "product-list";
    }

    @RequestMapping("/editUI")
    public String editUI(Model model, Long id){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "product-update";
    }


    @RequestMapping("save")
    public String save(Model model,Product product){
        return "redirect:/product/findAll";
    }


    @RequestMapping("delete")
    public String  deleteProducts(Long[] ids){
        productService.deleteProducts(ids);
        return "redirect:/product/findAll";
    }

    @RequestMapping("update")
    public String updateProduct(Product product){
        productService.updateProduct(product);
        return "redirect:/product/findAll";
    }

}

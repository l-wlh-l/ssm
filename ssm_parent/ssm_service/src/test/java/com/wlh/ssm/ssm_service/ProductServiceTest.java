package com.wlh.ssm.ssm_service;

import com.wlh.ssm.domain.Product;
import com.wlh.ssm.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ClassName ProductServiceTest
 * @Description TODO
 * @Author wlh
 * @Date 2019/3/1 21:31
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext_*.xml"})
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Test
    public void testFindAll(){
        List<Product> products = productService.findAll();
        for (Product product : products) {
            System.out.println(product);
        }
    }
}

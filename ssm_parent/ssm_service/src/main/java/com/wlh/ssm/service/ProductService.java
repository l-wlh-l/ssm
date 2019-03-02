package com.wlh.ssm.service;

import com.wlh.ssm.domain.Product;

import java.util.List;

/**
 * @ClassName ProductService
 * @Description TODO
 * @Author wlh
 * @Date 2019/3/1 21:19
 **/

public interface ProductService {
    List<Product> findAll();

}

package com.wlh.ssm.service;

import com.wlh.ssm.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Long id);

    void save(Product product);

    void deleteProducts(Long[] ids);

    void updateProduct(Product product);
}

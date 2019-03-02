package com.wlh.ssm.service.impl;

import com.wlh.ssm.dao.ProductDao;
import com.wlh.ssm.domain.Product;
import com.wlh.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ProductServiceImpl
 * @Description TODO
 * @Author wlh
 * @Date 2019/3/1 21:19
 **/
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }
}

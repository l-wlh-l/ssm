package com.wlh.ssm.service.impl;

import com.wlh.ssm.dao.ProductDao;
import com.wlh.ssm.domain.Product;
import com.wlh.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName ProductServiceImpl
 * @Description TODO
 * @Author wlh
 * @Date 2019/3/4 20:16
 **/
@Service
@Transactional
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productDao.findById(id);
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public void deleteProducts(Long[] ids) {
        for (Long id : ids) {
            productDao.deleteProduct(id);
        }
    }

    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }
}

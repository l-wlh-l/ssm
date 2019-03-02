package com.wlh.ssm.ssm_dao;

import com.wlh.ssm.dao.ProductDao;
import com.wlh.ssm.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ClassName ProductDaoTest
 * @Description TODO
 * @Author wlh
 * @Date 2019/3/1 21:31
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext_*.xml"})
public class ProductDaoTest {

    @Autowired
    private ProductDao productDao;

    @Test
    public void testFindAll(){
        List<Product> products = productDao.findAll();
        for (Product product : products) {
            System.out.println(product);
        }
    }
    @Test
    public void testFindById(){
        Product product = productDao.findById((long) 2);
        System.out.println(product);
    }

    @Test
    public void testSaveProduct(){
        Product product = new Product();
        product.setId((long) 4);
        product.setProductNum("23521");
        product.setProductStatus(1);
        product.setProductName("1234rsad");
        productDao.saveProduct(product);

    }

    @Test
    public void testDeleteProduct(){
        productDao.deleteProduct((long)1);

    }
}

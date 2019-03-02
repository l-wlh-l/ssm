package com.wlh.ssm.dao;

import com.wlh.ssm.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductDao {

    /**
     *
     *   private Long id;
     *   private String productNum;
     *   private String productName;
     *   private String cityName;
     *   private String departureTime;
     *   private Double productPrice;
     *   private String productDesc;
     *   private Integer productStatus;
     *
     * */
    //@Select("select * from product")
    List<Product> findAll();

    void saveProduct(Product product);


    void deleteProduct(Long id);

    Product findById(Long id);

    void updateProduct(Product product);
}

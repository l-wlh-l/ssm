package com.wlh.ssm.dao;

import com.wlh.ssm.domain.Order;
import com.wlh.ssm.domain.Product;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {

    @Select("select * from orders")
    @Results({
            @Result(
                    column ="productId",
                    property = "product",
                    javaType = Product.class,
                    one = @One(select = "com.wlh.ssm.dao.ProductDao.findById",
                    fetchType = FetchType.LAZY)
            )
    })
    List<Order> findAll();

}

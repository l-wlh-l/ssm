package com.wlh.ssm.dao;

import com.wlh.ssm.domain.Order;
import com.wlh.ssm.domain.Product;
import org.apache.ibatis.annotations.*;
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
    /*

    private Long id;
    private String orderNum;
    private String orderTime;
    private int peopleCount;
    private String orderDesc;
    private int payType;
    private int orderStatus;

    private Product product;

    */

    @Insert("insert into orders(orderNum,orderTime,peopleCount,orderDesc,payType,orderStatus,productId) " +
            "values(#{orderNum},#{orderTime},#{peopleCount},#{orderDesc},#{payType},#{orderStatus},#{product.id})")
    void save(Order order);
}

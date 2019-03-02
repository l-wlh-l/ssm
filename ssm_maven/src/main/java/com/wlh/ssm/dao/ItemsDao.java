package com.wlh.ssm.dao;

import com.wlh.ssm.domain.Items;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName ItemsDao
 * @Description TODO
 * @Author wlh
 * @Date 2019/3/1 10:50
 **/
@Repository
public interface ItemsDao {

    List<Items> findAll();
}

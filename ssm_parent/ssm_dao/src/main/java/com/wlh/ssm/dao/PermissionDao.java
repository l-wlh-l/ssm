package com.wlh.ssm.dao;

import com.wlh.ssm.domain.Permission;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface PermissionDao {

    @Select("select * from ")
    List<Permission> findAll();
}

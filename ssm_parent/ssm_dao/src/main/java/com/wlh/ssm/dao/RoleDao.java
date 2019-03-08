package com.wlh.ssm.dao;

import com.wlh.ssm.domain.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName RoleDao
 * @Description TODO
 * @Author wlh
 * @Date 2019/3/8 20:33
 **/
@Repository
public interface RoleDao {

    @Select("select * from sys_role")
    List<Role> findAll();
}

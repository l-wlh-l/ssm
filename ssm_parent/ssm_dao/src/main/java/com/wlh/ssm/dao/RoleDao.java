package com.wlh.ssm.dao;

import com.wlh.ssm.domain.Role;
import org.apache.ibatis.annotations.Insert;
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

    @Insert("insert into sys_role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select count(1) from sys_role where roleName = #{roleName}" )
    Integer findByName(String roleName);
}

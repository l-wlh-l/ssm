package com.wlh.ssm.dao;

import com.wlh.ssm.domain.SysUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {

    @Select("select * from sys_user where username = #{username} ")
    SysUser findUserByUsername(String username);

    @Select("select * from sys_user")
    List<SysUser> findAll();

    @Insert("insert into sys_user(username,password,email,phoneNum,status) " +
            "values(#{username},#{password},#{email},#{phoneNum},#{status})")
    void save(SysUser sysUser);

    @Select("select count(1) from sys_user where username = #{username}")
    Long findByUserName(String username);

}

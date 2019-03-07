package com.wlh.ssm.dao;

import com.wlh.ssm.domain.SysUser;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

    @Select("select * from sys_user where username = #{username} ")
    SysUser findUserByUsername(String username);
}

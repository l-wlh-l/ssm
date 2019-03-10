package com.wlh.ssm.dao;

import com.wlh.ssm.domain.Role;
import com.wlh.ssm.domain.SysUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserDao {

    @Select("select * from sys_user where username = #{username} ")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "id",
                    property = "roleList",
                    javaType = List.class,
                    many = @Many(select = "com.wlh.ssm.dao.RoleDao.findByUid",fetchType = FetchType.LAZY)
            )
    })
    SysUser findUserByUsername(String username);

    @Select("select * from sys_user")
    List<SysUser> findAll();

    @Insert("insert into sys_user(username,password,email,phoneNum,status) " +
            "values(#{username},#{password},#{email},#{phoneNum},#{status})")
    void save(SysUser sysUser);

    @Select("select count(1) from sys_user where username = #{username}")
    Long findByUserName(String username);

    @Select("select * from sys_user where id = #{id}")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "id",
                    property = "roleList",
                    javaType = List.class,
                    many = @Many(select = "com.wlh.ssm.dao.RoleDao.findByUid",fetchType = FetchType.LAZY))
    })
    SysUser findById(Long id);

    @Delete("delete from sys_user_role where userId=#{id}")
    void deleteRoleToUser(Long id);

    @Insert("insert into sys_user_role(userId,roleId) values(#{param1},#{param2})")
    void addRoleToUser(Long id,Long i);
}

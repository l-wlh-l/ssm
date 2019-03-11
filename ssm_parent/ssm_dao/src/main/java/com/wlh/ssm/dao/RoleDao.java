package com.wlh.ssm.dao;

import com.wlh.ssm.domain.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
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

    @Select("select r.* from sys_user_role ur, sys_role r where ur.roleid=r.id and ur.userId = #{uid}")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "id",
                    property ="permissionList",
                    javaType = List.class,
                    many =@Many(select = "com.wlh.ssm.dao.PermissionDao.findByRid" ,fetchType = FetchType.LAZY)
            )
    })
    List<Role> findByUid(Long uid);

    @Select("select * from sys_role where id = #{id}")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "id",
                    property = "permissionList",
                    javaType = List.class,
                    many = @Many(select = "com.wlh.ssm.dao.PermissionDao.findByRid",fetchType = FetchType.LAZY)
            )
    })
    Role findByRid(Long id);

    @Delete("delete from sys_role_permission where roleId=#{roleId}")
    void deleteAllPermissionByRoleId(Long roleId);

    @Insert("insert into sys_role_permission(permissionId,roleId) values(#{param1},#{param2})")
    void addPermissionsToRoleByRoleId(Long permissionId,Long roleId);
}

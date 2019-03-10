package com.wlh.ssm.dao;

import com.wlh.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface PermissionDao {

    @Select("select * from sys_permission")
    List<Permission> findAll();

    @Select("select * from sys_permission where pid = #{pid}")
    List<Permission> findByPid(Long pid);

    @Insert("insert into sys_permission (permissionName,url,pid) values(#{permissionName},#{url},#{pid})")
    void save(Permission permission);

    @Select("select p.* from sys_role_permission rp,sys_permission p where rp.permissionId = p.id and rp.roleId = #{rid}")
    List<Permission> findByRid(Long rid);
}

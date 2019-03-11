package com.wlh.ssm.service;

import com.wlh.ssm.domain.PageBean;
import com.wlh.ssm.domain.Role;

import java.util.List;

public interface RoleService {


    PageBean<Role> findByPageHelper(Integer pageSize,Integer pageNumber);

    void save(Role role);

    String findByRoleName(String roleName);

    List<Role> finAll();

    Role findByRoleId(Long id);

    void savePermissionToRole(Long[] ids, Long roleId);
}

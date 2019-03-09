package com.wlh.ssm.service;

import com.wlh.ssm.domain.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> findAll();

    List<Permission> findByPid(Long pid);

    void save(Permission permission);
}

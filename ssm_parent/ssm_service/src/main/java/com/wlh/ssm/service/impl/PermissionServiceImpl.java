package com.wlh.ssm.service.impl;

import com.wlh.ssm.dao.PermissionDao;
import com.wlh.ssm.domain.Permission;
import com.wlh.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName PermissionServiceImpl
 * @Description TODO
 * @Author wlh
 * @Date 2019/3/8 14:40
 **/
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }
}

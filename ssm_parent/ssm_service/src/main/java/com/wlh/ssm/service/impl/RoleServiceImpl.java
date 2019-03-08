package com.wlh.ssm.service.impl;

import com.wlh.ssm.dao.RoleDao;
import com.wlh.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName RoleServiceImpl
 * @Description TODO
 * @Author wlh
 * @Date 2019/3/8 20:33
 **/
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
}

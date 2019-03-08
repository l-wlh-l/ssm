package com.wlh.ssm.service;

import com.wlh.ssm.domain.Order;
import com.wlh.ssm.domain.PageBean;
import com.wlh.ssm.domain.SysUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<SysUser> findAll();

    void save(SysUser sysUser);

    String findByUserName(String username);

    PageBean<SysUser> findByPage(Integer pageNumber, Integer pageSize);
}

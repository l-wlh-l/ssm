package com.wlh.ssm.service.impl;

import com.github.pagehelper.PageInfo;
import com.wlh.ssm.dao.UserDao;
import com.wlh.ssm.domain.Order;
import com.wlh.ssm.domain.PageBean;
import com.wlh.ssm.domain.SysUser;
import com.wlh.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author wlh
 * @Date 2019/3/6 20:31
 **/
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser user = userDao.findUserByUsername(username);
        if(null != user){
            Set<GrantedAuthority> authorities = new HashSet<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            return new User(username,user.getPassword(),authorities);
        }

        return null;
    }

    @Override
    public List<SysUser> findAll() {
        return userDao.findAll();
    }

    @Override
    public void save(SysUser sysUser) {
        sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));
        userDao.save(sysUser);
    }

    @Override
    public String findByUserName(String username) {
        Long count = userDao.findByUserName(username);
        return count+"";
    }

    @Override
    public PageBean<SysUser> findByPage(Integer pageNumber, Integer pageSize) {
        PageBean<SysUser> pageBean = new PageBean<>();
        pageBean.setPageSize(pageSize);
        pageBean.setPageNumber(pageNumber);
        List<SysUser> sysUserList = findAll();
        PageInfo<SysUser> pageInfo = new PageInfo<>(sysUserList);
        int pages = pageInfo.getPages();
        pageBean.setTotalPage(pages);
        long pageTotal = pageInfo.getTotal();
        pageBean.setTotalCount(pageTotal);
        List<SysUser> list = pageInfo.getList();
        pageBean.setPageList(list);
        return pageBean;
    }
}

package com.wlh.ssm.service.impl;

import com.wlh.ssm.dao.UserDao;
import com.wlh.ssm.domain.SysUser;
import com.wlh.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser user = userDao.findUserByUsername(username);
        if(null != user){
            Set<GrantedAuthority> authorities = new HashSet<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            return new User(username,"{noop}" + user.getPassword(),authorities);
        }

        return null;
    }
}

package com.wlh.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wlh.ssm.dao.RoleDao;
import com.wlh.ssm.domain.PageBean;
import com.wlh.ssm.domain.Role;
import com.wlh.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public PageBean<Role> findByPageHelper(Integer pageSize,Integer pageNumber) {
        PageBean<Role> pageBean = new PageBean<>();
        pageBean.setPageSize(pageSize);
        pageBean.setPageNumber(pageNumber);
        List<Role> list = roleDao.findAll();
        PageHelper.startPage(pageNumber,pageSize);
        PageInfo<Role> pageInfo = new PageInfo<>(list);
        pageBean.setPageList(list);
        pageBean.setTotalCount(pageInfo.getTotal());
        pageBean.setTotalPage(pageInfo.getPages());
        return pageBean;
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public String findByRoleName(String roleName) {
        Integer byName = roleDao.findByName(roleName);
        return byName.toString();
    }

    @Override
    public List<Role> finAll() {
        return roleDao.findAll();
    }

    @Override
    public Role findByRoleId(Long id) {
        return roleDao.findByRid(id);
    }

    @Override
    public void savePermissionToRole(Long[] ids, Long roleId) {
        roleDao.deleteAllPermissionByRoleId(roleId);
        for (Long id : ids) {
            roleDao.addPermissionsToRoleByRoleId(id,roleId);
        }
    }
}

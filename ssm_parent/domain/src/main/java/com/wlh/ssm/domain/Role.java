package com.wlh.ssm.domain;

import java.util.List;

public class Role {
    private Long id;
    private String roleName;
    private String roleDesc;
    
    //该角色具备哪些权限
    private List<Permission> permissionList;
    
    //该角色被哪些用户使用
    private List<SysUser> userList;
    
    //此处省略getter和setter方法... ...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    public List<SysUser> getUserList() {
        return userList;
    }

    public void setUserList(List<SysUser> userList) {
        this.userList = userList;
    }
}
package com.wlh.ssm.controller;

import com.wlh.ssm.domain.PageBean;
import com.wlh.ssm.domain.Role;
import com.wlh.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName RoleController
 * @Description TODO
 * @Author wlh
 * @Date 2019/3/8 20:32
 **/

@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("findByPageHelper")
    public String findByPageHelper(Model model, @RequestParam(defaultValue = "2") Integer pageSize,
                                                @RequestParam(defaultValue = "1") Integer pageNumber
    ){

        PageBean<Role> roleList = roleService.findByPageHelper(pageSize,pageNumber);

        model.addAttribute("roleList",roleList);
        return "role-list";
    }

    @RequestMapping("add")
    public String save(Role role){
        roleService.save(role);
        return "role/findByPageHelper";
    }

    @RequestMapping("findByRoleName")
    @ResponseBody
    public String findByRoleName(String roleName){
        return roleService.findByRoleName(roleName);
    }



}

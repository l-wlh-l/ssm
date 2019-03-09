package com.wlh.ssm.controller;

import com.wlh.ssm.domain.Permission;
import com.wlh.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName PermissionController
 * @Description TODO
 * @Author wlh
 * @Date 2019/3/8 14:38
 **/
@Controller
@RequestMapping("permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("findAll")
    public String findAll(Model modele){
        List<Permission> list =  permissionService.findAll();
        modele.addAttribute("permissionList",list);
        return "permission-list";
    }

    @RequestMapping("findByPid")
    public String findByPid(Long pid,Model model){
        model.addAttribute("pList",permissionService.findByPid(pid));
        return "permission-add";
    }

    @RequestMapping("save")
    public String save(Permission permission){
        permissionService.save(permission);
        return "redirect:/permission/findAll";
    }

}

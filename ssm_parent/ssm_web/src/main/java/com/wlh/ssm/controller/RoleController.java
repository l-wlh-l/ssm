package com.wlh.ssm.controller;

import com.wlh.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}

package com.wlh.ssm.controller.user;

import com.wlh.ssm.domain.User;
import com.wlh.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author wlh
 * @Date 2019/3/1 19:52
 **/
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("findAll")
    public String findAll(Model model){

        List<User> users = userService.findAll();
        model.addAttribute("users",users);

        return "user/user";
    }
}

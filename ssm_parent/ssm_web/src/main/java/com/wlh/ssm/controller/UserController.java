package com.wlh.ssm.controller;

import com.wlh.ssm.domain.PageBean;
import com.wlh.ssm.domain.SysUser;
import com.wlh.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author wlh
 * @Date 2019/3/7 16:51
 **/
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("findAll")
    public String findAll(Model model){
        List<SysUser> userList= userService.findAll();
        model.addAttribute("userlist",userList);
        return "user-list";
    }

    @RequestMapping("save")
    public String save(SysUser sysUser){

        userService.save(sysUser);
        return "redirect:/user/findByPageHelper";
    }

    @RequestMapping("checkusername")
    @ResponseBody
    public String findUserName(String username){
        return userService.findByUserName(username);
    }

    @RequestMapping("showUsername")
    @ResponseBody
    public String findUsername(HttpServletRequest request){
        HttpSession session = request.getSession();
        SecurityContext springSecurityContext = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
        Authentication authentication = springSecurityContext.getAuthentication();
        User principal = (User) authentication.getPrincipal();
        return principal.getUsername();
    }

    @RequestMapping("findByPageHelper")
    public String findByPage(@RequestParam(defaultValue = "1") Integer pageNumber,
                             @RequestParam(defaultValue = "2") Integer pageSize,Model model){

        PageBean<SysUser> userPageBean = userService.findByPage(pageNumber,pageSize);

        System.out.println(userPageBean.toString());

        model.addAttribute("pageBean",userPageBean);

        return "user-list";
    }
}

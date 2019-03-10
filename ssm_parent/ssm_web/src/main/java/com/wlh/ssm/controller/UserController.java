package com.wlh.ssm.controller;

import com.wlh.ssm.domain.PageBean;
import com.wlh.ssm.domain.Role;
import com.wlh.ssm.domain.SysUser;
import com.wlh.ssm.service.RoleService;
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
    @Autowired
    private RoleService roleService;

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


        model.addAttribute("userBean",userPageBean);

        return "user-list";
    }

    @RequestMapping("findById")
    public String findById(Long id,Model model){

        SysUser sysUser = userService.findById(id);
        model.addAttribute("user",sysUser);
        return "user-show";
    }



    @RequestMapping("addUserRoleUI")
    public String addUserRoleUI(Long id,Model model){
        StringBuilder builder = new StringBuilder();
        //查询所有角色结果集，并回显到页面上
        List<Role> roles = roleService.finAll();

        model.addAttribute("roles",roles);
        //根据Id查询此角色拥有的ID并回显，勾选上，
        SysUser user = userService.findById(id);
        List<Role> roleList = user.getRoleList();
        for (Role role : roleList) {
            builder.append(role.getId()).append(",");
        }

        //返回用户ID，放在页面隐藏域为了能够在保存时用得到。
        model.addAttribute("roleIdStr",builder);
        model.addAttribute("user",user);
        return "user-role-add";
    }

    //给当前用户添加多个角色
    @RequestMapping("addRoleToUser")
    public String addRoleToUser(Long[] ids,Long id){
        //角色ID ids
        //用户ID id
        userService.addRoleToUser(ids,id);

        return "redirect:/user/findByPageHelper";
    }

}

package com.wang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class PageController {

    /**
     * 去到部门管理页面
     * @return
     */
    @RequestMapping("/toDeptManager.html")
    public String toDeptManager(){
        return "dept/deptManager";
    }

    /**
     * 去到角色管理页面
     * @return
     */
    @RequestMapping("/toRoleManager.html")
    public String toRoleManager(){
        return "role/roleManager";
    }

    /**
     * 去到用户管理页面
     * @return
     */
    @RequestMapping("/toUserManager.html")
    public String toUserManager(){
        return "user/userManager";
    }

}
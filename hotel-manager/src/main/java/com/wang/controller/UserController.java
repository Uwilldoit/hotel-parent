package com.wang.controller;

import com.wang.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Resource
    private SysUserService userService;

    /**
     * 注销
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();//清空session数据
        //重定向到登陆页面
        return "redirect:/";
    }
}

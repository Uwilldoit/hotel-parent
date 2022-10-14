package com.wang.controller;


import com.wang.entity.Account;
import com.wang.service.AccountService;
import com.wang.utils.SystemConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Resource
    private AccountService accountService;

    /**
     * 注册
     * @param account
     * @return
     */
    @ResponseBody
    @RequestMapping("/register")
    public Map<String,Object> register(Account account){
        Map<String,Object> map = new HashMap<String,Object>();
        if (accountService.addAccount(account)>0){
            map.put(SystemConstants.SUCCESS,true);
            map.put(SystemConstants.MESSAGE,"恭喜您，注册成功");
        }else{
            map.put(SystemConstants.SUCCESS,false);
            map.put(SystemConstants.MESSAGE,"很遗憾，注册失败");
        }
        return map;
    }
//    public String register(Account account){
//        if (accountService.addAccount(account)>0){
//            return "redirect:/login.jsp";
//        }
//        return "redirect:/register.jsp";
//    }
}

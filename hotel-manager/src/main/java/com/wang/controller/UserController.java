package com.wang.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.dao.SysUserMapper;
import com.wang.entity.Dept;
import com.wang.entity.Role;
import com.wang.entity.SysUser;
import com.wang.service.SysUserService;
import com.wang.utils.DataGridViewResult;
import com.wang.utils.SystemConstants;
import com.wang.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Resource
    private SysUserService sysUserService;


    /**
     * 注销
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();//清空session数据
        //重定向到登陆页面
        return "redirect:/";//根目录
    }

    /**
     * 查询用户列表
     * @param userVo
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public DataGridViewResult list(UserVo userVo){
        //设置分页信息
        PageHelper.startPage(userVo.getPage(),userVo.getLimit());
        //调用查询部门列表的方法
        List<SysUser> userList = sysUserService.findUserList(userVo);
        //创建分页对象
        PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(userList);
        //返回数据
        return new DataGridViewResult(pageInfo.getTotal(),pageInfo.getList());

    }

    /**
     * 添加用户
     * @param sysUser
     * @return
     */
    @ResponseBody
    @RequestMapping("/addUser")
    public String addUser(SysUser sysUser, HttpServletRequest request){
        Map<String,Object> map = new HashMap<String,Object>();

        //创建人
        sysUser.setCreatedBy(1);
        if(sysUserService.insert(sysUser)>0){
            map.put(SystemConstants.SUCCESS,true);
            map.put(SystemConstants.MESSAGE,"添加成功");
        }else{
            map.put(SystemConstants.SUCCESS,false);
            map.put(SystemConstants.MESSAGE,"添加失败");
        }
        return JSON.toJSONString(map);
    }
}

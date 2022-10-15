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
    public DataGridViewResult list(UserVo userVo,Principal principal){
        //查询当前用户
        SysUser loginUser = sysUserService.getUserByUserName(principal.getName());
        if(loginUser != null && loginUser.getUserType() == 2){
            userVo.setUserType(2);
        }

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
    public String addUser(SysUser sysUser, Principal principal){
        //获取当前登录用户信息
        SysUser loginUser = sysUserService.getUserByUserName(principal.getName());
        Map<String,Object> map = new HashMap<String,Object>();

        //创建人
        sysUser.setCreatedBy(loginUser.getId());
        if(sysUserService.insert(sysUser)>0){
            map.put(SystemConstants.SUCCESS,true);
            map.put(SystemConstants.MESSAGE,"添加成功");
        }else{
            map.put(SystemConstants.SUCCESS,false);
            map.put(SystemConstants.MESSAGE,"添加失败");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 修改用户
     * @param sysUser
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateUser")
    public String updateUser(SysUser sysUser, Principal principal){
        //获取当前登录用户信息
        SysUser loginUser = sysUserService.getUserByUserName(principal.getName());
        //修改人
        sysUser.setModifyBy(loginUser.getId());
        Map<String,Object> map = new HashMap<String, Object>();

        if(sysUserService.updateUser(sysUser)>0){
            map.put(SystemConstants.SUCCESS,true);
            map.put(SystemConstants.MESSAGE,"修改成功");
        }else{
            map.put(SystemConstants.SUCCESS,false);
            map.put(SystemConstants.MESSAGE,"修改失败");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteById")
    public String deleteById(Integer id){
        Map<String,Object> map = new HashMap<String, Object>();
        if(sysUserService.deleteById(id)>0){
            map.put(SystemConstants.SUCCESS,true);
            map.put(SystemConstants.MESSAGE,"删除成功");
        }else{
            map.put(SystemConstants.SUCCESS,false);
            map.put(SystemConstants.MESSAGE,"删除失败");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 重置密码
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/resetPwd")
    public String resetPwd(Integer id,Principal principal){
        SysUser loginUser = sysUserService.getUserByUserName(principal.getName());

        Map<String,Object> map = new HashMap<String, Object>();
        if(sysUserService.resetPwd(id,loginUser.getId())>0){
            map.put(SystemConstants.SUCCESS,true);
            map.put(SystemConstants.MESSAGE,"密码重置成功");
        }else{
            map.put(SystemConstants.SUCCESS,false);
            map.put(SystemConstants.MESSAGE,"密码重置失败");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 分配角色
     * @param ids
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("/grantRole")
    public String grantRole(String ids,Integer userId){
        Map<String,Object> map = new HashMap<String, Object>();

        if(sysUserService.saveUserRole(ids,userId)){
            map.put(SystemConstants.SUCCESS,true);
            map.put(SystemConstants.MESSAGE,"角色分配成功");
        }else{
            map.put(SystemConstants.SUCCESS,false);
            map.put(SystemConstants.MESSAGE,"角色分配失败");
        }

        return JSON.toJSONString(map);
    }
}

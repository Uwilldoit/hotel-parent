package com.wang.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.entity.Permission;
import com.wang.entity.Role;
import com.wang.service.PermissionService;
import com.wang.service.RoleService;
import com.wang.service.SysUserService;
import com.wang.utils.DataGridViewResult;
import com.wang.utils.SystemConstants;
import com.wang.utils.TreeNode;
import com.wang.vo.RoleVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/role")
public class RoleController {
    @Resource
    private RoleService roleService;

    @Resource
    private SysUserService sysUserService;

    @Resource
    private PermissionService permissionService;
    /**
     * 查询部门列表
     * @param
     * @return
     */
    @RequestMapping("/list")
    public DataGridViewResult list(RoleVo roleVo){
        //设置分页信息
        PageHelper.startPage(roleVo.getPage(),roleVo.getLimit());
        //调用查询部门列表的方法
        List<Role> roleList = roleService.findRoleList(roleVo);
        //创建分页对象
        PageInfo<Role> pageInfo = new PageInfo<Role>(roleList);
        //返回数据
        return new DataGridViewResult(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 添加角色
     * @param role
     * @return
     */
    @RequestMapping("/addRole")
    public String addRole(Role role){
        Map<String,Object> map = new HashMap<String, Object>();
        if (roleService.insert(role)>0){
            map.put(SystemConstants.SUCCESS,true);
            map.put(SystemConstants.MESSAGE,"添加成功");
        }else{
            map.put(SystemConstants.SUCCESS,false);
            map.put(SystemConstants.MESSAGE,"添加失败");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 修改角色
     * @param role
     * @return
     */
    @RequestMapping("/updateRole")
    public String updateRole(Role role){
        Map<String,Object> map = new HashMap<String,Object>();
        if(roleService.updateRole(role)>0){
            map.put(SystemConstants.SUCCESS,true);
            map.put(SystemConstants.MESSAGE,"修改成功");
        }else{
            map.put(SystemConstants.SUCCESS,false);
            map.put(SystemConstants.MESSAGE,"修改失败");
        }
        return JSON.toJSONString(map);
    }


    /**
     * 检查部门是否存在用户
     * @param roleId
     * @return
     */
    @RequestMapping("/checkRoleHasUser")
    public String checkRoleHasUser(Integer roleId){
        Map<String,Object>map = new HashMap<String, Object>();
        if (sysUserService.getUserCountByRoleId(roleId)>0){
            map.put(SystemConstants.EXIST,true);
            map.put(SystemConstants.MESSAGE,"该角色下存在用户信息，无法删除");
        }else{
            map.put(SystemConstants.EXIST,false);
        }
        return JSON.toJSONString(map);
    }
    /**
     * 删除角色
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    public String deleteById(Integer id){
        Map<String,Object>map = new HashMap<String, Object>();
        if (roleService.deleteById(id)>0){
            map.put(SystemConstants.SUCCESS,true);
            map.put(SystemConstants.MESSAGE,"删除成功");
        }else{
            map.put(SystemConstants.SUCCESS,false);
            map.put(SystemConstants.MESSAGE,"删除失败");
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping("/initMenuTree")
    public DataGridViewResult initMenuTree(Integer roleId){
        //调用查询所有查询菜单权限列表的方法
        List<Permission> permissionList = permissionService.findPermissionList(null);
        ////调用根据角色ID查询菜单列表的方法（角色权限列表集合）
        List<Integer> currentRolePermissionIds= permissionService.findPermissionByRoleId(roleId);
        ////创建集合保存菜单信息
        List<Permission> currentPermissions = new ArrayList<Permission>();
        //判断角色权限列表集合是否存在数据
        if (currentRolePermissionIds!=null && currentRolePermissionIds.size()>0){
            currentPermissions = permissionService.findPermissionById(currentRolePermissionIds);
        }

        //创建菜单节点集合
        List<TreeNode>treeNodes=new ArrayList<TreeNode>();
        //循环遍历权限菜单列表 iter
        for (Permission permission : permissionList) {
            //定义变量，标识是否选中
            String checkArr = "0";//0表示复选框不选中，1表示选中复选框
            //内层循环遍历当前角色拥有的权限菜单
            //循环比较的原因：比较两个集合中的数据是否有相同的，有相同地表示当前角色拥有这个权限
            for (Permission currentPermission : currentPermissions) {
                //比较两个集合中权限菜单id是否相同，相同则选择
                if(permission.getId() == currentPermission.getId()){
                    checkArr = "1";
                    break;
                }
            }
            //定义变量，标识菜单是否展开
            Boolean spread= permission.getSpread() == null || permission.getSpread() == 1;
            treeNodes.add(new TreeNode(permission.getId(),permission.getPid(),permission.getTitle(),spread,checkArr));
        }
        return new DataGridViewResult(treeNodes);
    }

    /**
     * 保存角色菜单关系
     * @param permissionIds
     * @param roleId
     * @return
     */
    @RequestMapping("/saveRolePermission")
    public String saveRolePermission(String permissionIds,Integer roleId){
        Map<String,Object> map = new HashMap<String,Object>();
        if(roleService.saveRolePermission(permissionIds,roleId)){
            map.put(SystemConstants.SUCCESS,true);
            map.put(SystemConstants.MESSAGE,"菜单分配成功");
        }else{
            map.put(SystemConstants.SUCCESS,false);
            map.put(SystemConstants.MESSAGE,"菜单分配失败");
        }
        return JSON.toJSONString(map);
    }
}

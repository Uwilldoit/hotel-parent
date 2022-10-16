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

    /**
     * 去到权限管理页面
     * @return
     */
    @RequestMapping("/toPermissionManager.html")
    public String toPermissionManager(){

        return "permission/permissionManager";
    }

    /**
     * 去到楼层管理页面
     * @return
     */
    @RequestMapping("/toFloorManager.html")
    public String toFloorManager(){
        return "floor/floorManager";
    }

    /**
     * 去到房型管理页面
     */
    @RequestMapping("/toRoomTypeManager.html")
    public String toRoomTypeManager(){
        return "roomType/roomTypeManager";
    }

    /**
     * 去到房间管理页面
     * @return
     */
    @RequestMapping("/toRoomManager.html")
    public String toRoomManager(){
        return "room/roomManager";
    }
}
package com.wang.controller;

import com.wang.entity.Room;
import com.wang.service.RoomService;
import com.wang.vo.RoomVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/room")
public class RoomController {

    @Resource
    private RoomService roomService;

    /**
     * 查询房间详情
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/{id}.html")
    public String detail(@PathVariable Integer id, Model model){
        Room room = roomService.findById(id);
        model.addAttribute("room",room);
        return "detail";
    }

    /**
     * 查询房间列表
     * @param model
     * @return
     */
    @RequestMapping("/list.html")
    public String list(Model model){
        RoomVo roomVo = new RoomVo();
        roomVo.setStatus(1);//可预订
        //调用查询房间列表的方法
        List<Room> roomList = roomService.findRoomList(roomVo);
        //将房间列表放到模型中
        model.addAttribute("roomList",roomList);
        return "roomList";
    }

}

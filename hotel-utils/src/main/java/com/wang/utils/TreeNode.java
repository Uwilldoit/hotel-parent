package com.wang.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 树节点属性类
 */
@Data
@NoArgsConstructor
public class TreeNode {

    private Integer id;//菜单节点编号
    @JsonProperty(value = "parentId")
    private Integer pid;//父节点菜单编号
    private String title;//菜单节点名称
    private String icon;//菜单节点图标
    private String href;//菜单路径
    private Boolean spread;//是否展开


    /**
     * 构建树节点菜单
     * @param id    节点编号
     * @param pid   父节点
     * @param title 节点标题
     * @param icon  节点图标
     * @param href  节点菜单路径
     * @param spread    节点展开状态
     */
    public TreeNode(Integer id, Integer pid, String title, String icon, String href, Boolean spread) {
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.icon = icon;
        this.href = href;
        this.spread = spread;
    }

    /**
     * 构建dtree组件
     * @param id        编号
     * @param pid       父级编号
     * @param title     名称
     * @param spread    展开状态
     */
    public TreeNode(Integer id, Integer pid, String title, Boolean spread) {
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.spread = spread;
    }

}
package com.wang.entity;

import lombok.Data;

@Data
public class Permission {
    private Integer id;
    private Integer pid;
    private String type;
    private String title;
    private String permissionCode;
    private String icon;
    private String href;
    private Integer spread;//是否展开， 1-展开。2-收起
    private String target;
}

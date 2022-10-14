package com.wang.entity;

import lombok.Data;

import java.util.Date;


@Data
public class Account {
    private Long id;
    private String loginName;
    private String password;
    private String realName;
    private String idCard;
    private String phone;
    private String email;
    private Integer status;
    private Date registTime;

}

package com.wang.service.impl;

import com.wang.dao.AccountMapper;
import com.wang.entity.Account;
import com.wang.service.AccountService;
import com.wang.utils.PasswordUtil;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    /**
     * 添加用户
     *
     * @param account
     * @return
     */
    public int addAccount(Account account) {
        account.setRegistTime(new Date());//注册时间
        account.setPassword(PasswordUtil.encode(account.getPassword()));//密码
        account.setStatus(1);//可用
        return accountMapper.addAccount(account);
    }
}

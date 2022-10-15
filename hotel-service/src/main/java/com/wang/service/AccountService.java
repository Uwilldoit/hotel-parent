package com.wang.service;

import com.wang.entity.Account;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public interface AccountService {
    /**
     * 添加用户
     * @param account
     * @return
     */
    int addAccount(Account account);


}

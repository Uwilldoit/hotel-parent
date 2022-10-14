package com.wang.dao;

import com.wang.entity.Account;
import org.apache.ibatis.annotations.Select;

public interface AccountMapper {

    /**
     * 添加用户
     * @param account
     * @return
     */
    int addAccount(Account account);

}

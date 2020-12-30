package com.it.service;

import com.it.vo.Account;

import java.util.List;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2020/12/30
 */
public interface IAccountService {
    List<Account> findAll();

    void update(Account account);
}

package com.it.service.impl;

import com.it.dao.AccountDao;
import com.it.service.IAccountService;
import com.it.vo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2020/12/30
 */
@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        List<Account> accountList = accountDao.findAll();
        return accountList;
    }

    @Override
    public void update(Account account) {
        accountDao.update(account);
    }
}

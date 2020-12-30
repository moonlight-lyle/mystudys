package com.it.dao;

import com.it.vo.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2020/12/30
 */
@Repository
public interface AccountDao {

    //@Select("select * from account")
    List<Account> findAll();

    void update(Account account);
}

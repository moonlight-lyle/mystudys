package com.it.controller;

import com.it.service.IAccountService;
import com.it.vo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2020/12/19
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(){
        System.out.println("AccountController findAll()");
        List<Account> list = accountService.findAll();
        if (!CollectionUtils.isEmpty(list)){
            for (Account account : list) {
                System.out.println(account);
            }
        }
        //返回逻辑视图，经springmvc转成物理视图
        return  "success";
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public void update(@RequestBody Account account){
        System.out.println("执行更新方法。。。");
        accountService.update(account);
    }
}

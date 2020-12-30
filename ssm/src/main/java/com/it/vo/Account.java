package com.it.vo;

import java.io.Serializable;

/**
 * 实体类
 *
 * @author Lyle
 * @date 2020/12/19
 */

public class Account implements Serializable {
    private Integer id;
    private String name;
    private Double money;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public Account(Integer id, String name, Double money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    public Account() {
    }

    public Account(String name, Double money) {
        this.name = name;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}

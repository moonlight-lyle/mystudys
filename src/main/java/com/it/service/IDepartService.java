package com.it.service;

import com.it.pojo.Depart;
import com.it.pojo.User;

import java.util.List;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2020/7/11
 */
public interface IDepartService {

    int insert(Depart insertDepart);

    Depart selectById(long pid);

    List<Depart> findAll();

    void batchInsert();
}

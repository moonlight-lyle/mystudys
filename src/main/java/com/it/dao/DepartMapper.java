package com.it.dao;

import com.it.pojo.Depart;
import com.it.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2020/4/1
 */
@Repository
public interface DepartMapper {


    int insert(Depart insertDepart);

    Depart selectById(long pid);

    List<Depart> selectAll();

    void batchInsert(List<Depart> departList);
}
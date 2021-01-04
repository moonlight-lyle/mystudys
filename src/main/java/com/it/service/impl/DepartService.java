package com.it.service.impl;

import com.it.dao.DepartMapper;
import com.it.dao.UserMapper;
import com.it.pojo.Depart;
import com.it.pojo.User;
import com.it.service.IDepartService;
import com.it.service.IUserService;
import com.it.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2020/7/11
 */
@Service
public class DepartService implements IDepartService {

    @Autowired
    private DepartMapper departMapper;
    @Override
    public int insert(Depart insertDepart) {
        return departMapper.insert(insertDepart);
    }

    @Override
    public Depart selectById(long pid) {
        return departMapper.selectById(pid);
    }

    @Override
    public List<Depart> findAll() {
        List<Depart> selectAll = departMapper.selectAll();
        List<Depart> departs = listToTree(selectAll);
        return departs;
    }

    @Override
    public void batchInsert() {
        List<Depart> departList=new ArrayList<>();
        Depart depart1=new Depart();
        IdWorker idWorker = new IdWorker();
        long id = idWorker.nextId();
        depart1.setId(id);
        depart1.setLevel(1);
        depart1.setPid(0L);
        depart1.setName("助理");
        depart1.setCreateTime(new Date());
        depart1.setCreateBy("曹操");
        depart1.setDataStatus(1);
        depart1.setDataVersion(1);
        departList.add(depart1);
        Depart depart2=new Depart();
        long id2 = idWorker.nextId();
        depart2.setId(id2);
        depart2.setLevel(1);
        depart2.setPid(0L);
        depart2.setName("合伙人");
        depart2.setCreateTime(new Date());
        depart2.setCreateBy("曹操");
        depart2.setDataStatus(1);
        depart2.setDataVersion(1);
        departList.add(depart2);
        departMapper.batchInsert(departList);
    }

    /**
     * 将集合转换成树形结构
     * @param list
     * @return
     */
    public  List<Depart> listToTree(List<Depart> list) {
        //用递归找子。
        List<Depart> treeList = new ArrayList<Depart>();
        for (Depart tree : list) {
            if (tree.getPid() == 0) {
                treeList.add(findChildren(tree, list));
            }
        }
        return treeList;
    }

    public  Depart findChildren(Depart tree, List<Depart> list) {
        for (Depart node : list) {
            if (node.getPid() == tree.getId()) {
                if (tree.getChildren() == null) {
                    tree.setChildren(new ArrayList<Depart>());
                }
                tree.getChildren().add(findChildren(node, list));
            }
        }
        return tree;
    }

    public List<Depart> getChildren(Long id,List<Depart> list){
        List<Depart> children=new ArrayList<>();
        List<Depart> departs=new ArrayList<>();
        if (list!=null&&list.size()>0){
            for (Depart depart : list) {
                if (depart.getPid()==id.longValue()){
                    children.add(depart);
                }
            }
        }
        if (children!=null&&children.size()>0){
            for (Depart child : children) {
                List<Depart> departList = getChildren(child.getId(), list);
                departs.addAll(departList);
            }
        }
        if (children.size()==0){
            return new ArrayList<>();
        }
        return children;
    }

}

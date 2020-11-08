package com.it.utils;

import com.it.vo.Depart;
import org.apache.commons.collections4.CollectionUtils;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 递归遍历子父级
 *
 * @author Lyle
 * @date 2020/11/8
 */
public class RecursionQuery {

    /**
     * 使用递归调用查询子类
     * @param id
     * @param list
     * @return
     */
    List<Depart> getChildren(Long id, java.util.List<Depart> list){
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


    /**
     * 方法二、使用递归方法将List集合转换成树形结构的方法
     * @param list
     * @return
     */
    public static List<Depart> listToTree(List<Depart> list) {
        //用递归找子。
        List<Depart> treeList = new ArrayList<Depart>();
        for (Depart tree : list) {
            if (tree.getPid() == 0) {
                treeList.add(findChildren(tree, list));
            }
        }
        return treeList;
    }

    private static Depart findChildren(Depart tree, List<Depart> list) {
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


    /**
     * 树形结构扁平化，页面展示形成树形结构
     * 先展示自己，再展示自己的下级
     * @param tree 具备children的一个列表
     */
    public List<Depart> flatten(List<Depart> tree){
        List<Depart> list = new LinkedList<>();
        for (Depart someModel : tree) {
            list.add(someModel);
            //孩子扁平化
            List<Depart> children = someModel.getChildren();
            if(CollectionUtils.isEmpty(children)){
                continue;
            }
            List<Depart> flatten = flatten(children);
            list.addAll(flatten);
            someModel.setChildren(null);
        }
        return list;
    }
}

package com.it.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.pojo.Depart;
import com.it.pojo.Result;
import com.it.pojo.User;
import com.it.service.IDepartService;
import com.it.service.IUserService;
import com.it.util.IdWorker;
import com.it.util.PageHelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2020/7/11
 */
@RestController
@RequestMapping(value = "/depart")
public class DepartController {

    @Autowired
    private IDepartService departService;
    @RequestMapping(value = "/add")
    public Result add(@RequestBody Depart depart) {
        Result result = new Result();
        Depart insertDepart = new Depart();
        IdWorker idWorker = new IdWorker();
        long id = idWorker.nextId();
        insertDepart.setId(id);
        insertDepart.setPid(depart.getPid());
        if (depart.getPid()==(long)0){
            insertDepart.setLevel(1);
        }else {
            Depart selectById=departService.selectById(depart.getPid());
            if (selectById!=null){
                insertDepart.setLevel(selectById.getLevel()+1);
            }
        }
        insertDepart.setName(depart.getName());
        insertDepart.setCreateTime(new Date());
        insertDepart.setCreateBy("唐家三少");
        int insert=departService.insert(insertDepart);
        if (insert==1){
            result.setData(insertDepart);
            result.setFlag(true);
        }else {
            result.setFlag(false);
        }
        return result;
    }

    @RequestMapping(value = "/findAll")
    public Object findAll(){
        //PageHelper.startPage(1,10);
        List<Depart> all = departService.findAll();
        //查询后的集合若是经过处理，需要进行手动分页
        PageInfo<Depart> pageInfo = PageHelperUtils.initPageInfo(1, 10, all);
        return pageInfo;
    }

    @RequestMapping(value = "/batchInsert")
    public void batchInsert(){
            departService.batchInsert();
    }

}

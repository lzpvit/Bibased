package com.lzp.app1.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LZP on 2018/4/10.
 */
@Repository
public class History_warningDao {
    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;
    public void insert_history_warning(History_warning history_warning){
        hibernateTemplate.save(history_warning);
    }
    public List select_history_warning(){
        List list = hibernateTemplate.loadAll(History_warning.class);
        return list;
    }
}

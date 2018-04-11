package com.lzp.app1.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by LZP on 2018/4/9.
 */
@Repository
public class NoticeDao {
    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;
    public void notice_insert(Notice notice){
        hibernateTemplate.save(notice);
    }
}

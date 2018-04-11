package com.lzp.app1.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by LZP on 2018/4/8.
 */
@Repository
public class Message_boardDao{
    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    public void insert_message_board(Message_board message_board){
        System.out.println("begin");
      //  sessionFactory.getCurrentSession().save(message_board);
        this.hibernateTemplate.save(message_board);
        System.out.println("success_insert_message_board");
       // sessionFactory.getCurrentSession().flush();
    }
}

package com.lzp.app1.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.transaction.TransactionScoped;
import java.util.List;

/**
 * Created by LZP on 2018/4/7.
 */
@Repository
public class BibasedDao {
    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;
    public void insert_bibased(Bibased bibased) {
        hibernateTemplate.save(bibased);
    }
    public List getAll(){
       return hibernateTemplate.find("from Bibased ");
    }

}

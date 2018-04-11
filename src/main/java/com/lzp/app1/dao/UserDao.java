package com.lzp.app1.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LZP on 2018/4/9.
 */
@Repository
public class UserDao {
    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;
    public void insert_user(User user){
        hibernateTemplate.save(user);
    }
    public User select_user(String email){
     List list=  hibernateTemplate.find("from User WHERE email=?",email);
     if(list.size()==0) {
         User user = new User("no_user",2,"00@qq.com","00");
         user.setId(0);
         return user;
     }else {
         return (User) list.get(0);
     }

    }
}

package com.lzp.app1.services;

import com.lzp.app1.dao.User;
import com.lzp.app1.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by LZP on 2018/4/9.
 */
@Service
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class UserServiceImpl  implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    @Transactional
    public void insert_user(User user) {
        userDao.insert_user(user);
    }

    @Override
    @Transactional
    public User select_user(String email) {
        return userDao.select_user(email);
    }
}

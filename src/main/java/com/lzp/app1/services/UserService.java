package com.lzp.app1.services;

import com.lzp.app1.dao.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by LZP on 2018/4/9.
 */

public interface UserService {
    public void insert_user(User user);
    public User select_user(String email);
}

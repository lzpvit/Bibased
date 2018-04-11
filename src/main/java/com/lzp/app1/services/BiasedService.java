package com.lzp.app1.services;

import com.lzp.app1.dao.Bibased;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LZP on 2018/4/7.
 */
public interface BiasedService {
    public void insert_bibased(Bibased bibased);
    public List getAll();
}

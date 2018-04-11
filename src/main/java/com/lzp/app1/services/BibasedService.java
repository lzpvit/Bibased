package com.lzp.app1.services;

import com.lzp.app1.dao.Bibased;
import com.lzp.app1.dao.BibasedDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by LZP on 2018/4/7.
 */
@Service("bibasedService")
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class BibasedService implements BiasedService {
    @Autowired
    private BibasedDao bibasedDao;
    @Override
    @Transactional
    public void insert_bibased(Bibased bibased) {
        bibasedDao.insert_bibased(bibased);
        System.out.println("success_insert_bibased");
    }

    @Override
    @Transactional
    public List getAll() {
        return bibasedDao.getAll();
    }
}

package com.lzp.app1.services;

import com.lzp.app1.dao.History_warning;
import com.lzp.app1.dao.History_warningDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by LZP on 2018/4/10.
 */
@Service
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class History_warningServcieImpl implements History_warningService{
    @Autowired
    History_warningDao history_warningDao;
    @Override
    @Transactional
    public void insert_history_warning(History_warning history_warning) {
        history_warningDao.insert_history_warning(history_warning);
    }

    @Override
    @Transactional
    public List select_history_warning() {
        return history_warningDao.select_history_warning();
    }
}

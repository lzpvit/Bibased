package com.lzp.app1.services;

import com.lzp.app1.dao.Notice;
import com.lzp.app1.dao.NoticeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by LZP on 2018/4/9.
 */
@Service
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class NoticeServiceImpl implements NoticeService{
    @Autowired
    NoticeDao noticeDao;
    @Override
    @Transactional
    public void notice_insert(Notice notice) {
        noticeDao.notice_insert(notice);
    }
}

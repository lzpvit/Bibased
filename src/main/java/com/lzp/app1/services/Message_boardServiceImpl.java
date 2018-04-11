package com.lzp.app1.services;

import com.lzp.app1.dao.Message_board;
import com.lzp.app1.dao.Message_boardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by LZP on 2018/4/8.
 */
@Service("message_boardServiceImpl")
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class Message_boardServiceImpl implements Message_boardService {
    @Autowired
    Message_boardDao message_boardDao;
    @Override
    @Transactional
    public void message_board_insert(Message_board message_board) {
        message_boardDao.insert_message_board(message_board);
        System.out.println("success_insert_message_board");
    }
}

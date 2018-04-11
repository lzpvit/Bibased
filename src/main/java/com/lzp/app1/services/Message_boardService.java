package com.lzp.app1.services;

import com.lzp.app1.dao.Message_board;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by LZP on 2018/4/8.
 */
public interface Message_boardService {
    public void message_board_insert(Message_board message_board);
}

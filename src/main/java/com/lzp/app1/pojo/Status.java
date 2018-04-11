package com.lzp.app1.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by LZP on 2018/4/1.
 */
//数据校验失败 返回状态
    @Component
public class Status {
    private Boolean message_board_insert = false;

    public Boolean getMessage_board_insert() {
        return message_board_insert;
    }

    public void setMessage_board_insert(Boolean message_board_insert) {
        this.message_board_insert = message_board_insert;
    }
}

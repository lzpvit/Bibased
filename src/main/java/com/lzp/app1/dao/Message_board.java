package com.lzp.app1.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by LZP on 2018/4/1.
 */
@Entity
@Table(name = "message_board",schema = "messae_board")
public class Message_board {
    private int id;
    private String content;
    private int user_id;
    private Date time;
    public Message_board(){}
    public Message_board(String content,int user_id,Date time){
        this.content = content;
        this.time = time;
        this.user_id = user_id;
    }
@Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}

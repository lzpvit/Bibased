package com.lzp.app1.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


/**
 * Created by LZP on 2018/3/25.
 */
@Entity
@Table(name = "notice",schema = "notice",catalog = "")
public class Notice {
    private int id;
    private String content;
    private int author_id;
    private Date time;
    public Notice(){}
    public Notice(String content,int author_id,Date time){
        this.content = content;
        this.author_id = author_id;
        this.time = time;
    }
@Id
@Column(name = "id")
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

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}

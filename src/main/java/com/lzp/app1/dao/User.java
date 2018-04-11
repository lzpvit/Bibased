package com.lzp.app1.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by LZP on 2018/3/25.
 */
@Entity
@Table(name = "users", schema = "users", catalog = "")
public class User {
    private int id;
    private String name;
    private int power;
    private String email;
    private String tel;
    public User(){}
    public User(String name,int power, String email, String tel){
        this.name = name;
        this.power = power;
        this.email = email;
        this.tel = tel;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}

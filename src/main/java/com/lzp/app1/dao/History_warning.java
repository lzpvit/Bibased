package com.lzp.app1.dao;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by LZP on 2018/4/10.
 */
@Entity
@Table(name = "history_warning",schema = "history_warning",catalog = "")
public class History_warning {
    private int id;
    private Date time;
    private double level;
    private double lat;
    private double lon;
    private String location;
    private String description;
public History_warning(){}
public History_warning(Date time,double level,double lat,double lon, String location ,String description){
    this.time = time;
    this.level = level;
    this.lat = lat;
    this.lon = lon;
    this.location = location;
    this.description = description;
}
@Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String loation) {
        this.location = loation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

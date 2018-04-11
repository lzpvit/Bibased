package com.lzp.app1.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by LZP on 2018/3/16.
 */
@Entity
@Table(name = "mag_g1", schema = "mag_g1", catalog = "")
public class Bibased {
    private int ids;
    @Value("12121")
    private String mac;
    @Value("6561")
    private String mag;
    @Value("555")
    private String lat;
    @Value("64651")
    private String lon;
    @Value("65465")
    private String alt;
    @Value("9498489")
    private String time;
    @Value("0")
    private double x;
    @Value("0")
    private double y;
    @Value("0")
    private double z;
    public Bibased(){}
    public Bibased( String mac, String mag, String lat, String lon, String alt, String time){
        this.mac = mac;
        this.mag = mag;
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
        this.time = time;
    }
    public Bibased(String mac,String mag ,String lat,String lon,String alt,String time,double x,double y,double z){
        this.mac = mac;
        this.mag = mag;
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
        this.time = time;
        this.x = x;
        this.y = y;
        this.z = z;
    }
    @Id
    @Column(name = "id")
    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getMag() {
        return mag;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}

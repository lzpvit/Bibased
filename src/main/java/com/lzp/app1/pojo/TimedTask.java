package com.lzp.app1.pojo;

import com.lzp.app1.dao.Bibased;
import com.lzp.app1.dao.History_warning;
import com.lzp.app1.services.BibasedService;
import com.lzp.app1.services.History_warningService;
import org.apache.commons.math3.stat.correlation.Covariance;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by LZP on 2018/4/10.
 */
@Component
@Lazy(value = false)
public class TimedTask {
    private static ArrayList<Integer> id = new ArrayList<Integer>();
    private static ArrayList<String> mac = new ArrayList<String>();
    private static ArrayList<Double> mag = new ArrayList<Double>();
    private static ArrayList<Double> lat = new ArrayList<Double>();
    private static ArrayList<Double> lon = new ArrayList<Double>();
    private static ArrayList<Double> alt = new ArrayList<Double>();
    private static ArrayList<Long> time = new ArrayList<Long>();
    private static double[] cov = new double[4];
    private static double[] mean = new double[2];
    //private static int count = 0;


    private static long b_time = time.get(0);//开始时间
    private static int time_window = 1000;
    private static float ll_window = 20;
    private static double mag_0 = 66;
    private static int N_0 = 5 * 10;
    private Bibased bibased;
    private History_warning history_warning;

    @Autowired
    BibasedService bibasedService;
    @Autowired
    History_warningService history_warningService;

    public static void calcu(ArrayList<Double> lat, ArrayList<Double> lon) {
        int size = lat.size();
        double[] d_lat = new double[size];
        double[] d_lon = new double[size];
        for (int i = 0; i < size; i++) {
            d_lat[i] = lat.get(i);
            d_lon[i] = lon.get(i);
        }
        mean[0] = new Mean().evaluate(d_lat);
        mean[1] = new Mean().evaluate(d_lon);
        cov[0] = new Covariance().covariance(d_lat, d_lat);
        cov[1] = new Covariance().covariance(d_lat, d_lon);
        cov[2] = new Covariance().covariance(d_lon, d_lat);
        cov[3] = new Covariance().covariance(d_lon, d_lon);
    }

    public static long timeTrans(long time) {
        long t = time;

        int m = (int) (t % 10000) / 100;
        if (m >= 60) {
            t = t - 6000 + 10000;
        }

        int h = (int) (t % 1000000) / 10000;
        if (h >= 24) {
            t = t - 240000 + 1000000;
        }

        int d = (int) (t % 100000000) / 1000000;
        int mon = (int) (t % 10000000000L) / 100000000;
        int y = (int) (t / 10000000000L);
        if (d > 28 && mon == 2 && (y % 4 != 0)) {
            t = t - 28000000 + 100000000;
        } else if (d > 29 && mon == 2 && (y % 4 == 0)) {
            t = t - 29000000 + 100000000;
        } else if (d > 30 && (mon == 4 || mon == 6 || mon == 9 || mon == 11)) {
            t = t - 30000000 + 100000000;
        } else if (d > 31 && (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8 || mon == 10 || mon == 12)) {
            t = t - 31000000 + 100000000;
        }

        mon = (int) (t % 10000000000L) / 100000000;
        if (mon > 12) {
            t = t - 1200000000 + 10000000000L;
        }

        return t;
    }


    @Scheduled(cron = "0/600 * * * * *")
    public void cal_earthQuack() {
        List list = bibasedService.getAll();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            bibased = (Bibased) iterator.next();
            id.add(bibased.getIds());
            mac.add(bibased.getMac());
            mag.add(Double.parseDouble(bibased.getMag()));
            lat.add(Double.parseDouble(bibased.getLat()));
            lon.add(Double.parseDouble(bibased.getLon()));
            alt.add(Double.parseDouble(bibased.getAlt()));
            time.add(Long.parseLong(bibased.getTime()));
        }


        long e_time = b_time + time_window;
        e_time = timeTrans(e_time);
        while (e_time <= time.get(time.size() - 1)) {
            e_time = b_time + time_window;
            e_time = timeTrans(e_time);
            double lat_0 = 90;
            while ((lat_0 - ll_window) >= -90) {
                double lat_end = lat_0 - ll_window;
                double lon_0 = -180;
                while ((lon_0 + ll_window) <= 180) {
                    double lon_end = lon_0 + ll_window;
                    ArrayList<Integer> id_select = new ArrayList<Integer>();
                    ArrayList<String> mac_select = new ArrayList<String>();
                    ArrayList<Double> mag_select = new ArrayList<Double>();
                    ArrayList<Double> lat_select = new ArrayList<Double>();
                    ArrayList<Double> lon_select = new ArrayList<Double>();
                    ArrayList<Double> alt_select = new ArrayList<Double>();
                    ArrayList<Long> time_select = new ArrayList<Long>();

                    for (int i = 0; i < id.size(); i++) {
                        if (time.get(i) >= b_time && time.get(i) <= e_time && lat.get(i) <= lat_0 &&
                                lat.get(i) >= lat_end && lon.get(i) >= lon_0 && lon.get(i) <= lon_end
                                && mag.get(i) >= mag_0) {
                            id_select.add(id.get(i));
                            mac_select.add(mac.get(i));
                            mag_select.add(mag.get(i));
                            lat_select.add(lat.get(i));
                            lon_select.add(lon.get(i));
                            alt_select.add(alt.get(i));
                            time_select.add(time.get(i));
                        }
                    }
                    if (id_select.size() > N_0) {
                        calcu(lat_select, lon_select);
                        if (cov[0] <= 5.5 && cov[1] <= 4.5 && cov[3] <= 6.5) {
                            double[] d_mag = new double[mag_select.size()];
                            for (int i = 0; i < mag_select.size(); i++) {
                                d_mag[i] = mag_select.get(i);
                            }
                            System.out.println("【地磁暴预警】时间" + (b_time + e_time) / 2 +
                                    "，中心地区（经度" + mean[1] + "，纬度" + mean[0] +
                                    "），出现特大地磁异常，异常幅度为："
                                    + "平均值" + new Mean().evaluate(d_mag) + "uT，方差" +
                                    new Variance().evaluate(d_mag) + "。请保持警惕。");


                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            long lt = new Long((b_time+e_time)/2);
                            Date date = new Date(lt);
                            simpleDateFormat.format(date.getTime());
                            System.out.print("时间戳转换为时间");
                            System.out.println(date);

                            history_warning = new History_warning(date,1.0,mean[0],mean[1],"","");
                            history_warningService.insert_history_warning(history_warning);
                        }
                    }

                    lon_0 = lon_0 + ll_window / 2;
                }
                lat_0 = lat_0 - ll_window / 2;
            }

            b_time = b_time + time_window / 2;
            b_time = timeTrans(b_time);
        }

        System.out.println("hello");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long lt = new Long(20180310102617);
        Date date = new Date(lt);
        simpleDateFormat.format(date.getTime());
        System.out.print("时间戳转换为时间");
        System.out.println(date);

        history_warning = new History_warning(date,1.0,mean[0],mean[1],"","");
        history_warningService.insert_history_warning(history_warning);
    }
}

package com.lzp.app1.common;
import com.lzp.app1.dao.Bibased;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.validation.constraints.Null;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.Date;

public class MainServer {
    private static String[] data=new String[9];
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://localhost:3306/bibased?useSSL=false&serverTimezone=UTC";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        startService();
    }

    /**
     * 启动服务监听，等待客户端连接
     */
    private static void startService() {
        try {
            // 创建ServerSocket
            ServerSocket serverSocket = new ServerSocket(8082);
            // 监听端口，等待客户端连接
            while (true) {
                System.out.println("等待连接。。。");
                Socket socket = serverSocket.accept(); //等待客户端连接
                System.out.println("得到客户端连接：" + socket+new Date());
                startReader(socket);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从参数的Socket里获取最新的消息
     */
    private static void startReader(final Socket socket) {

        new Thread(){
            @Override
            public void run() {
                DataInputStream reader;
                DataOutputStream out;
                try {
                    // 获取读取流
                    reader = new DataInputStream( socket.getInputStream());
                    // 读取数据
                    String msg = reader.readUTF();
                    System.out.println("client msg：" + msg);
                    data=msg.split(",");
                    record(data);
                    out = new DataOutputStream(socket.getOutputStream());
                    out.writeUTF("server back");
                    out.flush();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private static void record(String[] data) {
//         String []data =  {"51","4524","454","4524","875","7587","78","55","44"};
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            String sql;
            sql = "INSERT INTO bibased.mag_g1 (mac, mag, lat, lon, alt, time,x,y,z) values(?,?,?,?,?,?,?,?,?)";
//            stmt = conn.createStatement();
            stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,data[0]);
            stmt.setString(2,data[1]);
            stmt.setString(3,data[2]);
            stmt.setString(4,data[3]);
            stmt.setString(5,data[4]);
            stmt.setString(6,data[5]);
            stmt.setDouble(7,Double.parseDouble(data[6]));
            stmt.setDouble(8,Double.parseDouble(data[7]));
            stmt.setDouble(9,Double.parseDouble(data[8]));
            stmt.execute();
            // 完成后关闭
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
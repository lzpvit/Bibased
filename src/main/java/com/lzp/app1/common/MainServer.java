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
    // JDBC �����������ݿ� URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://localhost:3306/bibased?useSSL=false&serverTimezone=UTC";

    // ���ݿ���û��������룬��Ҫ�����Լ�������
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        startService();
    }

    /**
     * ��������������ȴ��ͻ�������
     */
    private static void startService() {
        try {
            // ����ServerSocket
            ServerSocket serverSocket = new ServerSocket(8082);
            // �����˿ڣ��ȴ��ͻ�������
            while (true) {
                System.out.println("�ȴ����ӡ�����");
                Socket socket = serverSocket.accept(); //�ȴ��ͻ�������
                System.out.println("�õ��ͻ������ӣ�" + socket+new Date());
                startReader(socket);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * �Ӳ�����Socket���ȡ���µ���Ϣ
     */
    private static void startReader(final Socket socket) {

        new Thread(){
            @Override
            public void run() {
                DataInputStream reader;
                DataOutputStream out;
                try {
                    // ��ȡ��ȡ��
                    reader = new DataInputStream( socket.getInputStream());
                    // ��ȡ����
                    String msg = reader.readUTF();
                    System.out.println("client msg��" + msg);
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
            // ע�� JDBC ����
            Class.forName("com.mysql.jdbc.Driver");

            // ������
            System.out.println("�������ݿ�...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // ִ�в�ѯ
            System.out.println(" ʵ����Statement����...");
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
            // ��ɺ�ر�
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // ���� JDBC ����
            se.printStackTrace();
        }catch(Exception e){
            // ���� Class.forName ����
            e.printStackTrace();
        }finally{
            // �ر���Դ
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// ʲô������
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
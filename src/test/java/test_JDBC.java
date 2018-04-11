import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import java.sql.*;

/**
 * Created by LZP on 2018/4/11.
 */
@Rollback(value = false)
public class test_JDBC {
    // JDBC �����������ݿ� URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/bibased?useSSL=false&serverTimezone=UTC";

    // ���ݿ���û��������룬��Ҫ�����Լ�������
    static final String USER = "root";
    static final String PASS = "root";
@Test
    public void test2(){
        String []data =  {"51","4524","454","4524","875","7587","78","55","44"};
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
        ResultSet rs;
       stmt.execute();
        // ��ɺ�ر�
//        rs.close();
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


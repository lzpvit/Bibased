import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import java.sql.*;

/**
 * Created by LZP on 2018/4/11.
 */
@Rollback(value = false)
public class test_JDBC {
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/bibased?useSSL=false&serverTimezone=UTC";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "root";
@Test
    public void test2(){
        String []data =  {"51","4524","454","4524","875","7587","78","55","44"};
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
        ResultSet rs;
       stmt.execute();
        // 完成后关闭
//        rs.close();
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


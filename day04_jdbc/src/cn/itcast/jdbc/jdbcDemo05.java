package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDemo05 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stam = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///db3","root","root");
            //3.定义sql
            String sql = "create table student(id int,name varchar(20))";
            //4.获取定义sql对象
            stam = conn.createStatement();
            // 5.执行sql
            int count = stam.executeUpdate(sql);
            //处理结果
            System.out.println(count);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stam!=null){
                try {
                    stam.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

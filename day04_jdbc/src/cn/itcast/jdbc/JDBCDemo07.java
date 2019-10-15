package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo07 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stam = null;
        ResultSet rs = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///db3","root","root");
            //3.定义sql
            String sql = "select * from account";
            //4.获取定义sql对象
            stam = conn.createStatement();
            // 5.执行sql
            rs = stam.executeQuery(sql);
            //6处理结果
            //6.1让游标向下移动一行
            while(rs.next()){
                //循环判断游标是否是最后一行
                int id = rs.getInt(1);
                String name = rs.getString("name" );
                double balance = rs.getDouble(3);
                System.out.println(id+"---"+name+"----"+balance);
            }
            /*if(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString("name" );
                double balance = rs.getDouble(3);
                System.out.println(id+"---"+name+"----"+balance);
            }
            //6.2获取数据
            if(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString("name" );
                double balance = rs.getDouble(3);
                System.out.println(id+"---"+name+"----"+balance);
            }
            if(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString("name" );
                double balance = rs.getDouble(3);
                System.out.println(id+"---"+name+"----"+balance);
            }
            if(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString("name" );
                double balance = rs.getDouble(3);
                System.out.println(id+"---"+name+"----"+balance);
            }*/
            //6.2获取数据
           /*
           rs.next();
           int id2 = rs.getInt(1);
            String name2 = rs.getString("name" );
            double balance2 = rs.getDouble(3);
            System.out.println(id2+"---"+name2+"----"+balance2);*/
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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

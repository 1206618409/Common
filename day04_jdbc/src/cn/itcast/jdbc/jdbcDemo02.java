package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDemo02 {
    public static void main(String[] args) {
        //1.注册驱动
        Statement stmt = null;
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.定义sql
            String sql = "insert into account values(null,'王五',3000)";
            //3.获取 Connection 对象
            try {
                 con = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
                //获取执行sql对象 Statement
                stmt = con.createStatement();
                //5.执行sql
                int count = stmt.executeUpdate(sql);// 影响的行数
                System.out.println(count);
                //6.处理结果
                if(count>0){
                    System.out.println("添加成功");
                }else{
                    System.out.println("添加失败");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

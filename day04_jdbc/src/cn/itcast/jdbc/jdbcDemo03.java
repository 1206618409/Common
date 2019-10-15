package cn.itcast.jdbc;
/**
 * account 表修改记录
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class jdbcDemo03 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stam = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///db3","root","root");
            //3.定义sql
            String sql = "update account set balance = 1500 where id = 3";
            //4.获取定义sql对象
            stam = conn.createStatement();
            // 5.执行sql
            int count = stam.executeUpdate(sql);
            //处理结果
            System.out.println(count);
            if(count>0){
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败" );
            }
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

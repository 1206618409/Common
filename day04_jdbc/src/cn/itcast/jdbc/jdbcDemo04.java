package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * account 表删除一条记录
 */
public class jdbcDemo04 {
    public static void main(String[] args){
        Connection conn = null;
        Statement statm = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                conn = DriverManager.getConnection("jdbc:mysql:///db3","root","root" );
                String sql = "delete from account where id = 3";
                statm = conn.createStatement();
                int count = statm.executeUpdate(sql);
                System.out.println(count);
                if(count>0){
                    System.out.println("删除成功");
                }else{
                    System.out.println("删除失败");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
           if(conn!=null){
               try {
                   conn.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
               if (statm!=null){
                   try {
                       statm.close();
                   } catch (SQLException e) {
                       e.printStackTrace();
                   }
               }
           }
        }
    }

}

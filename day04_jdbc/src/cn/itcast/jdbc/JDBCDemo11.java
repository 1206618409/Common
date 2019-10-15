package cn.itcast.jdbc;

import util.JDBCutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDemo11 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pre1 =null;
        PreparedStatement pre2 =null;
        try {
            //1.获取连接
            conn = JDBCutils.getConnection();
            //开启事务
            conn.setAutoCommit(false);
            //2.定义sql
            //2.1 张三 -500
            String sql1 = "update account set balance = balance - ? where id = ?";
            //2.2 李四+500
            String sql2 = "update account set balance = balance + ? where id = ?";
            //3.获取执行sql对象
            pre1 = conn.prepareStatement(sql1);
            pre2 = conn.prepareStatement(sql2);
            //4.设置参数
            pre1.setDouble(1,500);
            pre1.setDouble(2,1);
            pre2.setDouble(1,500);
            pre2.setDouble(2,2);
            //5.执行sql
            int count1 = pre1.executeUpdate();
            //手动制造异常
            int i = 3/0;
            int count2 = pre2.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            //事务回滚
            try {
                if(conn!=null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCutils.close(pre1,conn);
            JDBCutils.close(pre2,null);
        }

    }
}

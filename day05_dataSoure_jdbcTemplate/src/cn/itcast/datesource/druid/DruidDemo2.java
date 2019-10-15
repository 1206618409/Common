package cn.itcast.datesource.druid;

import cn.itcast.datesource.utils.JDBCutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 */
public class DruidDemo2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstm = null;
        //1.获取连接
        try {
            conn = JDBCutils.getConnection();
            //2.定义sql
            String sql = "insert into account values(null,?,?)";
            //3.获取pstmt对象
            pstm = conn.prepareStatement(sql);
            //4.给？赋值
            pstm.setString(1,"王五");
            pstm.setDouble(2,3000);
            int count = pstm.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCutils.close(pstm,conn);
        }
    }
}

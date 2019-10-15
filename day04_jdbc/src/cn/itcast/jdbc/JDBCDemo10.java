package cn.itcast.jdbc;

import util.JDBCutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 练习：
 *      需求：
 *          1.通过键盘录入用户名和密码
 *          2.判断用户是否登录成功
 *
 */
public class JDBCDemo10 {
    public static void main(String[] args) {
        //1.键盘录入，接收用户名和密码
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = scan.nextLine();
        System.out.println("请输入密码");
        String password = scan.nextLine();
        //2.调用方法
        boolean flag = new JDBCDemo10().login(username, password);
        //3.判断结果，输出不同语句
        if(flag){
            System.out.println("登录成功");
        }else{
            System.out.println("用户名或密码错误");
        }
    }
    /*
    登录方法
     */
    public boolean login(String username,String password){
            if(username== null||password==null){
                return false;
            }
        Connection conn = null;
        Statement stam = null;
        ResultSet rs = null;
        try {
            conn = JDBCutils.getConnection();
            String sql = "select * from user where username = '"+username+"'and password ='"+password+"'";
             stam = conn.createStatement();
             rs = stam.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCutils.close(rs,stam,conn);
        }
        return false;
    }

    public boolean login2(String username,String password){
        if(username== null||password==null){
            return false;
        }
        Connection conn = null;
        PreparedStatement pse = null;
        ResultSet rs = null;
        try {
            conn = JDBCutils.getConnection();
            String sql = "select * from user where username = ? and password = ?";
            pse = conn.prepareStatement(sql);
            //给？赋值
            pse.setString(1,username);
            pse.setString(2,password);
            rs = pse.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCutils.close(rs,pse,conn);
        }
        return false;
    }
}

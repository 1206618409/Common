package cn.itcast.jdbc;

import itcast.domain.Emp;
import util.JDBCutils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo09 {
    public static void main(String[] args) {

        List<Emp> list = new JDBCDemo09().finAll2();
        System.out.println(list);
        System.out.println(list.size());
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    /**
     * 演示jdbc工具类
     * @return
     */

    public List<Emp> finAll2(){
        Connection conn = null;
        Statement stam = null;
        ResultSet rs = null;
        List<Emp> list = null;
        try {

            conn = JDBCutils.getConnection();
            String sql = "select * from emp";
                stam = conn.createStatement();
                rs = stam.executeQuery(sql);
                Emp emp = null;
                list = new ArrayList<>();
                while(rs.next()){
                    int id = rs.getInt("id");
                    String ename = rs.getString("ename");
                    int job_id = rs.getInt("job_id");
                    int mgr = rs.getInt("mgr");
                    Date joindate = rs.getDate("joindate");
                    double salary = rs.getDouble("salary");
                    double bonus = rs.getDouble("bonus");
                    int dept_id = rs.getInt("dept_id");
                    //创建emp对象 并赋值
                    emp= new Emp();
                    emp.setId(id);
                    emp.setEname(ename);
                    emp.setJob_id(job_id);
                    emp.setMgr(mgr);
                    emp.setSalary(salary);
                    emp.setBonus(bonus);
                    emp.setDept_id(dept_id);
                    // 装载结合
                    list.add(emp);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {

           JDBCutils.close(rs,stam,conn);
        }


        return list;
    }
}

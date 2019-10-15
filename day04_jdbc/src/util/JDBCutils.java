package util;


import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC工具类
 */
public class JDBCutils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static {

        try {
            //1.Properies集合类
            Properties pro = new Properties();

            //获取src路径下的文件方式-->ClassLoader类加载器
            ClassLoader classLoader = JDBCutils.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = res.getPath();
            //2加载文件
            //pro.load(new FileReader("I:\\itcast\\day04_jdbc\\src\\jdbc.properties"));
            pro.load(new FileReader(path));
            //System.out.println(path);
            //3.获取数据赋值
             url = pro.getProperty("url");
             user = pro.getProperty("user");
             password = pro.getProperty("password");
             driver = pro.getProperty("driver");
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {

            return DriverManager.getConnection(url,user,password);

    }

    /**
     * 释放资源
     * @param stam
     * @param conn
     */
    public static void close(Statement stam,Connection conn){
        if(stam!= null){
            try {
                stam.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn!= null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 释放资源
     * @param rs
     * @param stam
     * @param conn
     */
    public static void close(ResultSet rs,Statement stam, Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stam!= null){
            try {
                stam.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn!= null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}

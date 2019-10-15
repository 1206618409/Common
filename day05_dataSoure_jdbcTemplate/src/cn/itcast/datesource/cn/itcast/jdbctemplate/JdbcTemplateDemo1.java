package cn.itcast.datesource.cn.itcast.jdbctemplate;

import cn.itcast.datesource.utils.JDBCutils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate入门
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //1.导入jar包
        //2.常见JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCutils.getDatSource());
        String sql = "update account set balance = 5000 where id = ?";
        //3.调用方法
        int count = template.update(sql, 3);
        System.out.println(count);


    }
}

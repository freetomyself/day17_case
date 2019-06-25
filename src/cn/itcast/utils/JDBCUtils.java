package cn.itcast.utils;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @program: day15_response--cn.itcast.utils
 * @author: WaHotDog 2019-06-20 07:58
 **/


public class JDBCUtils {

    private static DataSource ds;

    static{
//        创建properties空间
        Properties pro = new Properties();
//        获取数据库配置文件
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
//            加载配置文件
            pro.load(is);
//            初始化连接池
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static DataSource getDataSource(){
        return ds;
    }
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}

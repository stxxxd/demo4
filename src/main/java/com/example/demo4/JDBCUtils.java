package com.example.demo4;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String password= null;
    static {
        try {
            InputStream in = JDBCUtils.class.getClassLoader()
                    .getResourceAsStream("db.properties");
            System.out.println(in);
            Properties prop = new Properties();
            prop.load(in);
            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");
            System.out.println(driver + url);
            Class.forName(driver);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
        public static Connection getConnection(){
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(url,username
                        ,password);
            }catch (Exception e){
                e.printStackTrace();
            }
            return conn;
        }
    public static void release(Connection conn,
                              Statement st, ResultSet rs){
        if(rs!=null){
            try{
                rs.close();
            }catch (Exception e){e.printStackTrace();}
        }
        if(st!=null){
            try{
                st.close();
            }catch (Exception e){e.printStackTrace();}
        }
        if(conn!=null){
            try{
                conn.close();
            }catch (Exception e){e.printStackTrace();}
        }

    }
}

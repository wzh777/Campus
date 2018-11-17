package Dao;

import java.sql.*;

public class Dao {
    @SuppressWarnings("unused")
	private  static  Dao dao = new Dao();
    public static Statement stmt = null;
    public static PreparedStatement pstmt = null;
    public static ResultSet rs = null;
    public static Connection conn = null;

    public static Connection getConn(){
        String DRIVER = "com.mysql.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8";
        try{
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,"root","981022");
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeAll(){
        try {
            if (rs != null){
                rs.close();
            }
            if (stmt != null){
                stmt.close();
            }
            if (pstmt != null){
                pstmt.close();
            }
            if (conn != null){
                conn.close();
            }
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}

package kerson.sample.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
    
    public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection("jdbc:oracle:thin:@oracleee.c5zfkwkietoa.ap-northeast-1.rds.amazonaws.com:1521:ORCL", "admin", "kkals131");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public static void close ( ResultSet rs, PreparedStatement pstmt, Connection conn) {
        try {
            if ( rs != null ) { 
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            rs = null;
        }
        
        if ( pstmt != null ) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                pstmt = null;
            }
            
        }
        
        if ( conn != null ) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                conn = null;
            }
        }
    }
}

package kerson.sample.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kerson.sample.biz.common.JDBCUtil;

import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAO {
    
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    
    private final String USER_GET = "SELECT * FROM USERS WHERE ID=? AND PASSWORD=?";
    
    public UserVO getUser(UserVO vo){
        UserVO user = new UserVO();
        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(USER_GET);
            pstmt.setString(1, vo.getId());
            pstmt.setString(2, vo.getPassword());
            rs = pstmt.executeQuery();
            
            if ( rs.next() ) {
                user.setId(rs.getString("ID"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setName(rs.getString("NAME"));
                user.setRole(rs.getString("ROLE"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, pstmt, conn);
        }
        
        return user;
    }
}

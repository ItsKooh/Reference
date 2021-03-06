package kerson.sample.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kerson.sample.biz.common.JDBCUtil;

import org.springframework.stereotype.Component;

@Component("boardDAO")
public class BoardDAO {
	
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
           
    private final String BOARD_ADD = "INSERT INTO BOARD ( SEQ, TITLE, CONTENT, WRITER, CNT ) VALUES ( (SELECT NVL(MAX(SEQ),0) + 1 FROM BOARD), ?, ?, ?, 0 )";
    private final String BOARD_CHANGE = "UPDATE BOARD SET TITLE = ?, CONTENT = ?, WRITER = ? WHERE SEQ = ?";
    private final String BOARD_REMOVE = "DELETE FROM BOARD WHERE SEQ=?";  
    private final String BOARD_GET = "SELECT * FROM BOARD WHERE SEQ = ?";
    private final String BOARD_LIST = "SELECT * FROM BOARD ORDER BY SEQ DESC";
    
    public void insertBoard ( BoardVO vo ) {
        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(BOARD_ADD);
            pstmt.setString(1, vo.getTitle());
            pstmt.setString(2, vo.getContent());
            pstmt.setString(3, vo.getWriter());   
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, pstmt, conn);
        }
        
    }
    
    public void updateBoard ( BoardVO vo ) {
        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(BOARD_CHANGE);
            pstmt.setString(1, vo.getTitle());
            pstmt.setString(2, vo.getContent());
            pstmt.setString(3, vo.getWriter());
            pstmt.setInt(4, vo.getSeq());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, pstmt, conn);
        }
        
    }
    
    public void deleteBoard ( BoardVO vo ) {
        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(BOARD_REMOVE);
            pstmt.setInt(1, vo.getSeq());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        } finally {
            JDBCUtil.close(rs, pstmt, conn);
        }
        
    }
    
    public BoardVO getBoard ( BoardVO vo ) {
        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(BOARD_GET);
            pstmt.setInt(1, vo.getSeq());
            rs = pstmt.executeQuery();
            
            BoardVO board = new BoardVO();
            if ( rs.next() ) {
                board.setSeq(rs.getInt("seq"));
                board.setTitle(rs.getString("title"));
                board.setContent(rs.getString("content"));
                board.setWriter(rs.getString("writer"));
                board.setCnt(rs.getInt("cnt"));
                return board;
            }
            
            return null;
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        } finally {
            JDBCUtil.close(rs, pstmt, conn);
        }
        return null;
    }
    
    public List<BoardVO> getBoardList ( BoardVO vo ) {
        try {
        	int rowCnt = 0;
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(BOARD_LIST);
            rs = pstmt.executeQuery();
            
            List<BoardVO> boardList = new ArrayList<BoardVO>();
            
            while ( rs.next() ) {
            	rowCnt++;
                BoardVO board = new BoardVO(); 
                board.setSeq(rs.getInt("seq"));
                board.setTitle(rs.getString("title"));
                board.setContent(rs.getString("content"));
                board.setWriter(rs.getString("writer"));  
                board.setCnt(rs.getInt("cnt"));
                boardList.add(board);
                System.out.println("====> select 결과 : " + board.toString());
            }
            
            System.out.println("====> 조회건수 : [" + Integer.toString(rowCnt) + "]");
            
            return boardList;
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        } finally {
            JDBCUtil.close(rs, pstmt, conn);
        }
        
        return null;
    }
}

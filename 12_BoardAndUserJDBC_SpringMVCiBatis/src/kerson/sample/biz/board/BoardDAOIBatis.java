package kerson.sample.biz.board;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

@Repository("boardDAOIBatis") 
public class BoardDAOIBatis {
	
	@Autowired 
	private SqlMapClientTemplate ibatis; 
	
    public BoardVO getBoard ( BoardVO vo ) throws SQLException {
    	return (BoardVO) ibatis.queryForObject("getBoard", vo); 
    }
    
    public List<BoardVO> getBoardList ( BoardVO vo ) throws SQLException { 
    	return ibatis.queryForList("getBoardList", vo); 
    }
    
    public void insertBoard ( BoardVO vo ) throws SQLException {
    	ibatis.insert("insertBoard", vo);
    }
    
    public void updateBoard ( BoardVO vo ) throws SQLException {
    	ibatis.update("updateBoard", vo);
    }
    
    public void deleteBoard ( BoardVO vo ) throws SQLException {
    	ibatis.delete("deleteBoard", vo);
    }
}



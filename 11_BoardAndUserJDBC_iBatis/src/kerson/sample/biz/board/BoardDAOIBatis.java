package kerson.sample.biz.board;

import java.sql.SQLException;
import java.util.List;

import kerson.sample.biz.common.SqlMapClientFactoryBean;

import org.springframework.stereotype.Component;

import com.ibatis.sqlmap.client.SqlMapClient;

@Component("boardDAO") 
public class BoardDAOIBatis {
	
	private SqlMapClient ibatis;
	
	public BoardDAOIBatis() {
		ibatis = SqlMapClientFactoryBean.getSqlMapClient();
	}
	
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



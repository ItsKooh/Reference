package kerson.sample.biz.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component("boardDAOSpring") 
public class BoardDAOSpring {
    
    @Autowired
    private JdbcTemplate spring;
    
    private static String BOARD_INSERT = "INSERT INTO BOARD (SEQ, TITLE, CONTENT, WRITER, CNT) VALUES ((SELECT NVL(MAX(SEQ),0) + 1 FROM BOARD), ?, ?, ?, 0)";
    private static String BOARD_UPDATE = "UPDATE BOARD SET TITLE = ?, CONTENT = ?, WRITER = ? WHERE SEQ = ?";
    private static String BOARD_DELETE = "DELETE FROM BOARD WHERE SEQ = ?"; 
    private static String BOARD_SELECT_ONE = "SELECT * FROM BOARD WHERE SEQ = ?";
    private static String BOARD_SELECT_LIST = "SELECT * FROM BOARD";
    
    
    public BoardDAOSpring() 
    {
        System.out.println("====> BoardDAO ����Ʈ ������ ȣ��!!");
    }

    public void insertBoard(BoardVO vo) {
        System.out.println("====> BoardDAO insertBoard() �޼ҵ� ȣ��");
        spring.update(BOARD_INSERT, vo.getTitle(), vo.getContent(), vo.getWriter()); 
    }
    
    public void updateBoard(BoardVO vo) {
        System.out.println("====> BoardDAO updateBoard() �޼ҵ� ȣ��");
        spring.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getWriter(), vo.getSeq());
    }
    
    public void deleteBoard(BoardVO vo) {
        System.out.println("====> BoardDAO deleteBoard() �޼ҵ� ȣ��");
        spring.update(BOARD_DELETE, vo.getSeq());
    }
    
    public BoardVO getBoard(BoardVO vo) {
        System.out.println("====> BoardDAO getBoard() �޼ҵ� ȣ��");
        return spring.queryForObject(BOARD_SELECT_ONE, new BoardRowMapper(), vo.getSeq()); 
    }
    
    public List<BoardVO> getBoardList(BoardVO vo) {
        System.out.println("====> BoardDAO getBoardList() �޼ҵ� ȣ��");
        return spring.query(BOARD_SELECT_LIST, new BoardRowMapper());
    }
    
    public void insertAndUpdate(BoardVO vo) {
    	System.out.println("====> BoardDAO insertAndUpdate() �޼ҵ� ȣ��");
    	insertBoard(vo);
    	updateBoard(vo);
    }
}

class BoardRowMapper implements RowMapper<BoardVO> {

    @Override
    public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        BoardVO board = new BoardVO();
        board.setSeq(rs.getInt("SEQ"));
        board.setTitle(rs.getString("TITLE"));
        board.setContent(rs.getString("CONTENT"));
        board.setWriter(rs.getString("WRITER"));
        board.setCnt(rs.getInt("CNT")); 
        return board;
    } 
}

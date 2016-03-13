package kerson.sample.biz.board;

import java.sql.SQLException;
import java.util.List;

public class BoardServiceClient {
    public static void main(String[] args) throws SQLException {
    	
    	BoardDAOIBatis dao = new BoardDAOIBatis();
    	
        BoardVO vo = new BoardVO();
        vo.setSeq(45);
        vo.setTitle("변경제목");
        vo.setContent("변경내용");
        vo.setWriter("변경작성자");   
        
//        System.out.println("====> 결과값 : " + dao.getBoard(vo).toString());   
        
//        dao.insertBoard(vo);
//        dao.updateBoard(vo);
        dao.deleteBoard(vo);
        
        List<BoardVO> boardList = dao.getBoardList(vo);  
        for ( BoardVO board : boardList ) {
        	System.out.println("====> 결과값 : " + board.toString());
        }
    }
}


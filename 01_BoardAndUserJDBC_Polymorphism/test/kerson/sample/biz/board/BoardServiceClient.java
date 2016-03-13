package kerson.sample.biz.board;

import java.util.List;

import kerson.sample.biz.board.BoardService;
import kerson.sample.biz.board.BoardServiceImpl;
import kerson.sample.biz.board.BoardVO;

public class BoardServiceClient {
    public static void main(String[] args) {
        // 1. 객체 생성 
        BoardService boardService = new BoardServiceImpl();
        
        // 2. 입력값 SET
        BoardVO vo = new BoardVO();
        
        // 3. INSERT
//        vo.setTitle("제목3");
//        vo.setContent("내용입니다3");
//        vo.setWriter("작성자3"); 
//        boardService.insertBoard(vo);

        // 3. UPDATE
//        vo.setSeq(1);
//        vo.setTitle("변경제목1");
//        vo.setContent("변경한 내용입니다1");
//        vo.setWriter("바뀐작성자1");
//        boardService.updateBoard(vo);
        
        // 3. DELETE
//        vo.setSeq(1);
//        boardService.deleteBoard(vo);
        
        // 3. getBoardList
        List<BoardVO> boardList = boardService.getBoardList(vo);
        for ( BoardVO board : boardList ) {
            System.out.println("====> 결과값 : " + board);
        }
    }
}

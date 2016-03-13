package kerson.sample.biz.board;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BoardServiceClient {
    public static void main(String[] args) {
        // 1. Spring Container 구동
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // 2. Spring Contatiner에 등록된 객체(빈) Lookup
        BoardService boardService = (BoardService) context.getBean("boardService");
        
        // 3. 입력값 SET 및 메소드 호출
        BoardVO vo = new BoardVO();
        vo.setTitle("제목2");
        vo.setContent("내용2입니다.....");
        vo.setWriter("작성자2");
        
        boardService.insertAndUpdate(vo);   
        
        List<BoardVO>boardList = boardService.getBoardList(vo);
        for ( BoardVO board : boardList) {
        	System.out.println("====> 결과값 : " + board.toString());   
        }
    }
}


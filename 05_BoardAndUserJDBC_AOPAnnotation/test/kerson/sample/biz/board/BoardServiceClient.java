package kerson.sample.biz.board;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BoardServiceClient {
    public static void main(String[] args) {
        // 1. Spring Container 구동
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // 2. Spring Contatiner에 등록된 객체(빈) Lookup
        BoardService boardService = (BoardService) context.getBean("boardService");
        
        // 3. 입력값 SET 및 메소드 호출
        BoardVO vo = new BoardVO();
        vo.setSeq(2);
        
        BoardVO board = boardService.getBoard(vo);
        System.out.println("====> 결과값 : " + board.toString());  
    }
}

package kerson.sample.biz.board;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BoardServiceClient {
    public static void main(String[] args) {
        // 1. Spring Container 구동
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // 2. Spring Contatiner�뿉 �벑濡앸맂 媛앹껜(鍮�) Lookup
        BoardService boardService = (BoardService) context.getBean("boardService");
        
        // 3. �엯�젰媛� SET 諛� 硫붿냼�뱶 �샇異�
        BoardVO vo = new BoardVO();
        vo.setSeq(2);
        
        BoardVO board = boardService.getBoard(vo);
        System.out.println("====> 寃곌낵媛� : " + board.toString()); 
    }
}

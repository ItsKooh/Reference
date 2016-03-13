package kerson.sample.biz.board;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BoardServiceClient {
    public static void main(String[] args) {
        // 1. Spring Container 구동
//      BeanFactory context = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
      ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
      
      // 2. Spring Container에서 관리하는 객체(빈) Lookup
      BoardService boardService = (BoardService) context.getBean("boardService");
      
      // 3. 입력값 SET
      BoardVO vo = new BoardVO(); 
      vo.setSeq(2);
      System.out.println("====> 결과값 : " + boardService.getBoard(vo));
    }
}

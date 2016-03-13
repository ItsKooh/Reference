package kerson.sample.biz.user;

import java.sql.SQLException;

import kerson.sample.biz.board.BoardService;
import kerson.sample.biz.board.BoardVO;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class UserServiceClient {
    public static void main(String[] args) throws SQLException {
        // 1. Spring Container 구동
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
      
        // 2. Spring Container에서 관리하는 객체(빈) Lookup
        UserService userService = (UserService) context.getBean("userService");
        UserService userService1 = (UserService) context.getBean("userService");
        UserService userService2 = (UserService) context.getBean("userService");
        
        System.out.println("====> UserService : " + userService);
        System.out.println("====> UserService1 : " + userService1);
        System.out.println("====> UserService2 : " + userService2);
      
        // 3. 입력값 SET
        UserVO vo = new UserVO(); 
        vo.setId("aaa");
        vo.setPassword("aaa");
        System.out.println("====> 결과값 : " + userService.getUser(vo));
    }
}

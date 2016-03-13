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
    	// 1.������ �����̳� ����
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	
    	// 2.������ �����̳ʿ� ��ϵ� �� lookup
    	UserService userService = (UserService) context.getBean("userService");
    	
    	// 3.�Է°� SET �� �޼ҵ� ȣ��
    	UserVO vo = new UserVO();
    	vo.setId("aaa");
    	vo.setPassword("aaa");
    	
    	UserVO user = userService.getUser(vo);  
    	System.out.println("====> ����� : " + user);
    }
}

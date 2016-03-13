package kerson.sample.biz.user;

import java.sql.SQLException;

import kerson.sample.biz.user.UserServiceImpl;
import kerson.sample.biz.user.UserVO;

public class UserServiceClient {
    public static void main(String[] args) throws SQLException {
        // 1. 서비스 객체 생성 
        UserServiceImpl service = new UserServiceImpl();
        
        // 2. 입력값 셋팅 
        UserVO vo = new UserVO();
        vo.setId("aaa");
        vo.setPassword("aaa"); 
        
        UserVO user = service.getUser(vo);
        System.out.println(user.toString());
    }
}

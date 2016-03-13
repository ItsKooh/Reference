package kerson.sample.biz.user;

import java.sql.SQLException;

public class UserServiceClient {
    public static void main(String[] args) throws SQLException {
    	
    	UserDAOIBatis dao = new UserDAOIBatis();
    	
        UserVO vo = new UserVO();
        vo.setId("aaa");
        vo.setPassword("aaa"); 
        
        System.out.println("====> 결과값 : " + dao.getUser(vo).toString());   
        
        
        
        
    	UserDAOIBatis dao1 = new UserDAOIBatis();
    	
        UserVO vo1 = new UserVO();
        vo1.setId("aaa");
        vo1.setPassword("aaa"); 
        
        System.out.println("====> 결과값 : " + dao1.getUser(vo1).toString());  
    }
}

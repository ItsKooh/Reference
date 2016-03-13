package kerson.sample.biz.user;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO;
    
    public UserServiceImpl() {
        this.userDAO = new UserDAO();
    }
    
    public void start() {
        System.out.println("====> UserServiceImpl에서 start() 호출!");
    }
    
    public void end() {
        System.out.println("====> UserServiceImpl에서 end() 호출!");
    }   
    
    public UserVO getUser(UserVO vo) {
        try {
            return userDAO.getUser(vo);
        } catch ( Exception e ) {
            e.printStackTrace();
        } 
        
        return null;
    }
}

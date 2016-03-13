package kerson.sample.biz.user;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO;
    
    public UserServiceImpl() {
        this.userDAO = new UserDAO();
    }
    
    public UserVO getUser(UserVO vo) throws SQLException {
        return userDAO.getUser(vo);
    }
}

package kerson.sample.biz.user;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserServiceImpl implements UserService {

	@Autowired
    private UserDAOSpring userDAO;
    
    public UserVO getUser(UserVO vo) throws SQLException {
        return userDAO.getUser(vo);
    } 
}


package kerson.sample.biz.user;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
    private UserDAOIBatis userDAO;
     
    public UserVO getUser(UserVO vo) throws SQLException {
        return userDAO.getUser(vo);
    } 
}

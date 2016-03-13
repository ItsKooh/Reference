package kerson.sample.biz.user;

import java.sql.SQLException;

public interface UserService {

    public UserVO getUser(UserVO vo) throws SQLException;
}
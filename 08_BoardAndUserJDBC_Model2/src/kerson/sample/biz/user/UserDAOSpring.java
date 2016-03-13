package kerson.sample.biz.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("userDAOSpring")
public class UserDAOSpring { 

	@Autowired
	private JdbcTemplate spring;
	
    private final String USER_GET = "SELECT * FROM USERS WHERE ID=? AND PASSWORD=?";
    
    public UserVO getUser(UserVO vo){
        return spring.queryForObject(USER_GET, new UserRowMapper(), vo.getId(), vo.getPassword());
    }  
}



class UserRowMapper implements RowMapper<UserVO> {

	@Override
	public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserVO user = new UserVO();
        user.setId(rs.getString("ID"));
        user.setPassword(rs.getString("PASSWORD"));
        user.setName(rs.getString("NAME"));
        user.setRole(rs.getString("ROLE"));
		return user;
	}
	
}

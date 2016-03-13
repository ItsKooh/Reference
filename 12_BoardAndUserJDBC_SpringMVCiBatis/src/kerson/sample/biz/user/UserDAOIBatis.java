package kerson.sample.biz.user;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

@Repository("userDAOIBatis")
public class UserDAOIBatis { 
	
	@Autowired
	private SqlMapClientTemplate ibatis; 
	
    public UserVO getUser(UserVO vo) throws SQLException { 
        return (UserVO) ibatis.queryForObject("getUser", vo);
    }
    
    public void testMthd() {
    	
    }
    
    public void testMthd2() {
    	
    }
}

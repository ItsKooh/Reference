package kerson.sample.biz.user;

import java.sql.SQLException;
import kerson.sample.biz.common.SqlMapClientFactoryBean;
import com.ibatis.sqlmap.client.SqlMapClient;

public class UserDAOIBatis {
	
	private SqlMapClient ibatis;
	
	public UserDAOIBatis() { 
		ibatis = SqlMapClientFactoryBean.getSqlMapClient();
	}
    
    public UserVO getUser(UserVO vo) throws SQLException { 
        return (UserVO) ibatis.queryForObject("getUser", vo);
    }
}

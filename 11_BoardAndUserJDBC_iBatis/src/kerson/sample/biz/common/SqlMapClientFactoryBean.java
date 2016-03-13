package kerson.sample.biz.common;

import java.io.Reader;

import org.apache.ibatis.io.Resources;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientFactoryBean {
	
	private static SqlMapClient sqlMapClient = null;
	
	static {
		try {
			if ( sqlMapClient == null ) {
				String configFile = "sql-map-config.xml";
				Reader reader = Resources.getResourceAsReader(configFile);
				sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			}
			
		} catch ( Exception e ) {
			e.printStackTrace();
		} 
	}
	
	public static SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	} 
}

package dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.http.HttpServlet;

public class DAO extends HttpServlet {
	static DataSource ds;
	
	public Connection getConnection() throws Exception{
		if(ds == null) {
			InitialContext context = new InitialContext();
			ds =(DataSource) context.lookup(
					//"DB-name");
		}
		
		return ds.getConnection();
	}
}

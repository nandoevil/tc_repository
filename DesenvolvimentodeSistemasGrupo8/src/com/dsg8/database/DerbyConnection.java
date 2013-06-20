package com.dsg8.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DerbyConnection {

	private static DerbyConnection derbyConnection;
	private String driver;
	private String connectionURL;
	private Connection conn;


	private DerbyConnection() throws ClassNotFoundException{
	
	}
	
	public static synchronized DerbyConnection getInstance() throws ClassNotFoundException{
		if(derbyConnection==null){
			derbyConnection = new DerbyConnection();
		}
		
		return derbyConnection;
	}

	public boolean createConnection() throws SQLException, ClassNotFoundException{

		this.driver = "org.apache.derby.jdbc.ClientDriver";
		this.connectionURL = "jdbc:derby:c:\\DerbyDatabase\\dsg8;create=true";
		Class.forName(driver);
		conn = DriverManager.getConnection(connectionURL);
		if(conn!= null)
			return true;
		return false;
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	public boolean execute(String sql) throws SQLException{
		boolean result=false;
		if(conn!=null){
			PreparedStatement st = conn.prepareStatement(sql);
			if(st != null){
				result = st.execute();
				st.close();
			}
			conn.close();
		}
		return result;
	}
	
	public boolean executeInsert(String sql) throws SQLException{
		boolean result=false;
		if(conn!=null){
			Statement st = conn.createStatement();
			if(st != null){
				result = st.execute(sql);
				st.close();
			}
			conn.close();
		}
		return result;
	}
	
	public ResultSet executeQuery(String sql) throws SQLException{
		ResultSet rs = null;
		if(conn!=null){
			PreparedStatement ps = conn.prepareStatement(sql);
			if(ps != null){
				rs = ps.executeQuery();
				ps.close();
			}
			conn.close();
		}
		return rs;
	}

	public boolean closeConnection() throws SQLException{
		if(conn!=null){
			conn.close();
			return true;
		}
		return false;
	}
}

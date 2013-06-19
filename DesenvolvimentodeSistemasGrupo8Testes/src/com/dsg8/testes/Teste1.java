package com.dsg8.testes;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;

import com.dsg8.database.DerbyConnection;

public class Teste1 {

	@Test
	public void derbyConnection() throws ClassNotFoundException, SQLException{
		DerbyConnection dc = DerbyConnection.getInstance();
		assertTrue(dc.createConnection("org.apache.derby.jdbc.ClientDriver","jdbc:derby:c:\\derbydatabase\\dsg8;create=true"));
	}
}

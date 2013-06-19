package com.dsg8.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsg8.database.DerbyConnection;

public class TurmaDAO {
	
	DerbyConnection dc = null;
	
	public TurmaDAO() throws ClassNotFoundException {
		dc = DerbyConnection.getInstance();
	
	}
	
	public List<TurmaDTO> consultarTurma() throws SQLException{
		ResultSet rs = dc.executeQuery("SELECT CODIGO, NOME, CODIGO_DISCIPLINA FROM TURMAS");
		List<TurmaDTO> turmaList = new ArrayList<TurmaDTO>();
				
		while(rs.next()){
			TurmaDTO turma = new TurmaDTO();
			turma.setCodigo(rs.getInt(1));
			turma.setNome(rs.getString(2));
			
			turmaList.add(turma);
		}
		return turmaList;
	}

}

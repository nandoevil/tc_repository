package com.dsg8.persistence;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsg8.database.DerbyConnection;

public class DisciplinaDAO implements Serializable {
	
	DerbyConnection dc = null;
	
	public DisciplinaDAO() throws ClassNotFoundException {
		dc = DerbyConnection.getInstance();
	
	}
	
	public List<DisciplinaDTO> consultarDisciplina() throws SQLException{
		ResultSet rs = dc.executeQuery("SELECT CODIGO, NOME FROM DISCIPLINAS");
		List<DisciplinaDTO> disciplinaList = new ArrayList<DisciplinaDTO>();
				
		while(rs.next()){
			DisciplinaDTO disciplina = new DisciplinaDTO();
			disciplina.setCodigo(rs.getInt(1));
			disciplina.setNome(rs.getString(2));
			
			disciplinaList.add(disciplina);
		}
		return disciplinaList;
	}

}

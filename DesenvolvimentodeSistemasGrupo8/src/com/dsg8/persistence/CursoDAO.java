package com.dsg8.persistence;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsg8.database.DerbyConnection;

public class CursoDAO implements Serializable{
	
	DerbyConnection dc = null;
	
	public CursoDAO() throws ClassNotFoundException {
		dc = DerbyConnection.getInstance();
	
	}
	
	public List<CursoDTO> findAll() throws SQLException{
		
		ResultSet rs = dc.executeQuery("SELECT * FROM CURSOS");
		
		List<CursoDTO> cursos = new ArrayList<CursoDTO>();
				
		while(rs.next()){
		
			CursoDTO curso = new CursoDTO();
			curso.setCodigo(rs.getInt(1));
			curso.setNome(rs.getString(2));
			cursos.add(curso);
		}
		
		return cursos;
	}
	
	public boolean insert(CursoDTO curso){
				
		return false;
	}
	
	public boolean update(CursoDTO curso){
		
		return false;
	}
	
	public boolean delete(CursoDTO curso){
		
		return false;
	}
}

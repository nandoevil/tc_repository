package com.dsg8.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsg8.database.DerbyConnection;

public class ProfessorDAO {
	

	DerbyConnection dc = null;
	
	public ProfessorDAO() throws ClassNotFoundException {
		dc = DerbyConnection.getInstance();
	
	}
	
	public List<ProfessorDTO> findAll() throws SQLException{
		
		ResultSet rs = dc.executeQuery("SELECT * FROM PROFESSORES");
		
		List<ProfessorDTO> professores = new ArrayList<ProfessorDTO>();
				
		while(rs.next()){
		
			ProfessorDTO Professor = new ProfessorDTO();
			Professor.setCodigo(rs.getInt(1));
			Professor.setNome(rs.getString(2));
		}
		
		return professores;
	}
	
	public List<ProfessorDTO> findAllwithAlocacao() throws SQLException{
		
		ResultSet rs = dc.executeQuery("SELECT P.NOME FROM PROFESSORES P INNER JOIN ALOCACOES AL ON P.CODIGO=AL.CODIGO_PROFESSOR INNER JOIN TURMAS T ON AL.CODIGO_TURMA=T.CODIGO");
		
		List<ProfessorDTO> professores = new ArrayList<ProfessorDTO>();
				
		while(rs.next()){
		
			ProfessorDTO Professor = new ProfessorDTO();
			Professor.setCodigo(rs.getInt(1));
			Professor.setNome(rs.getString(2));
		}
		
		return professores;
	}
	
	public List<ProfessorDTO> listarProfessoresSemAlocacao() throws SQLException{
		
		ResultSet rs = dc.executeQuery("SELECT CODIGO, NOME FROM PROFESSORES WHERE CODIGO NOT IN (SELECT CODIGO_PROFESSOR FROM ALOCACOES)");
		
		List<ProfessorDTO> professores = new ArrayList<ProfessorDTO>();
				
		while(rs.next()){
		
			ProfessorDTO professor = new ProfessorDTO();
			professor.setCodigo(rs.getInt(1));
			professor.setNome(rs.getString(2));
			
			professores.add(professor);
		}
		
		return professores;
	}
	
	public ProfessorDTO buscarProfessor(long codigo) throws SQLException{
		
		ResultSet rs = dc.executeQuery("SELECT CODIGO, NOME FROM PROFESSORES WHERE CODIGO = "+codigo);
		
		ProfessorDTO professor = new ProfessorDTO();
		while(rs.next()){
			professor.setCodigo(rs.getInt(1));
			professor.setNome(rs.getString(2));
		}
		
		return professor;
	}
	
	
	public boolean insert(ProfessorDTO professor){
				
		return false;
	}
	
	public boolean update(ProfessorDTO professor){
		
		return false;
	}
	
	public boolean delete(ProfessorDTO professor){
		
		return false;
	}


}

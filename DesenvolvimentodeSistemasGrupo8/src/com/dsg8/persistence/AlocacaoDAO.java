package com.dsg8.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsg8.database.DerbyConnection;

public class AlocacaoDAO {
	
	
	DerbyConnection dc = null;
	
	public AlocacaoDAO() throws ClassNotFoundException {
		dc = DerbyConnection.getInstance();
	
	}
	
	public List<AlocacaoDTO> findAll() throws SQLException{
		
		ResultSet rs = dc.executeQuery("SELECT * FROM ALOCACAOES");
		
		List<AlocacaoDTO> alocacoes = new ArrayList<AlocacaoDTO>();
				
		while(rs.next()){
		
			AlocacaoDTO alocacao = new AlocacaoDTO();
			alocacao.setCodigoAlocacao(rs.getInt(1));
			alocacao.setCodigoAlocacao(rs.getInt(2));
			alocacao.setCodigoAlocacao(rs.getInt(3));
		}
		
		return alocacoes;
	}
	
	public boolean insert(AlocacaoDTO alocacaoDTO){
		try{
			StringBuilder insert = new StringBuilder();
			
			insert.append("INSERT INTO ALOCACOES (CODIGO_PROFESSOR, CODIGO_TURMA, CODIGO_DISCIPLINA) VALUES(");
			insert.append(alocacaoDTO.getCodigoProfessor());
			insert.append(", ");
			insert.append(alocacaoDTO.getCodigoTurma());
			insert.append(", ");
			insert.append(alocacaoDTO.getCodigoDisciplina());
			insert.append(")");
			
			dc.executeInsert(insert.toString());
			
			return true;
			
		}catch(Throwable e){
			return false;
		}
	}
	
	public boolean update(AlocacaoDTO curso){
		
		return false;
	}
	
	public boolean delete(AlocacaoDTO curso){
		
		return false;
	}

}

package com.dsg8.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import com.dsg8.model.Professor;
import com.dsg8.model.Turma;
import com.dsg8.persistence.AlocacaoDTO;
import com.dsg8.persistence.DisciplinaDTO;
import com.dsg8.persistence.ProfessorDTO;
import com.dsg8.persistence.TurmaDTO;

public interface ServiceInterface extends Remote {
	
	public void alocaProfessor(Turma t, Professor p) throws RemoteException;
			
	public List<Professor> listaProfessoresAlocados() throws RemoteException;
	
	public List<Professor> listaProfessoresSemAlocacaoCompleta() throws RemoteException;
	
	public List<ProfessorDTO> listaProfessoresSemAlocacao() throws RemoteException;
	
	public boolean alocarProfessorTurmaDisciplina(AlocacaoDTO alocacaoDTO) throws RemoteException; 
	
	public List<TurmaDTO> listarTurmas() throws RemoteException;
	
	public List<DisciplinaDTO> listarDisciplina() throws RemoteException; 
	
	public ProfessorDTO buscarProfessor(long codigo) throws RemoteException;
	
}

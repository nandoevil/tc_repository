package com.dsg8.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import com.dsg8.model.Professor;
import com.dsg8.model.Turma;
import com.dsg8.persistence.AlocacaoDAO;
import com.dsg8.persistence.AlocacaoDTO;
import com.dsg8.persistence.DisciplinaDAO;
import com.dsg8.persistence.DisciplinaDTO;
import com.dsg8.persistence.ProfessorDAO;
import com.dsg8.persistence.ProfessorDTO;
import com.dsg8.persistence.TurmaDAO;
import com.dsg8.persistence.TurmaDTO;

public class ServiceImpl  extends UnicastRemoteObject implements ServiceInterface{

	protected ServiceImpl() throws RemoteException {
		super();
	
	}

	@Override
	public void alocaProfessor(Turma t, Professor p) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Professor> listaProfessoresAlocados() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Professor> listaProfessoresSemAlocacaoCompleta()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProfessorDTO> listaProfessoresSemAlocacao() throws RemoteException {
		try{
			return new ProfessorDAO().listarProfessoresSemAlocacao();
		}catch(Throwable e){
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public boolean alocarProfessorTurmaDisciplina(AlocacaoDTO alocacaoDTO) throws RemoteException {
		try{
			AlocacaoDAO al = new AlocacaoDAO();
			al.insert(alocacaoDTO);
			
			return true;
			
		}catch(Throwable e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<TurmaDTO> listarTurmas() throws RemoteException {
		try{
			return new TurmaDAO().consultarTurma();
			
		}catch(Throwable e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<DisciplinaDTO> listarDisciplina() throws RemoteException {
		try{
			return new DisciplinaDAO().consultarDisciplina();
			
		}catch(Throwable e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ProfessorDTO buscarProfessor(long codigo) throws RemoteException {
		try{
			return new ProfessorDAO().buscarProfessor(codigo);
			
		}catch(Throwable e){
			e.printStackTrace();
			return new ProfessorDTO();
		}
	}
}

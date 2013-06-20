package com.dsg8.client.model;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import com.dsg8.model.Professor;
import com.dsg8.persistence.AlocacaoDTO;
import com.dsg8.persistence.DisciplinaDTO;
import com.dsg8.persistence.ProfessorDTO;
import com.dsg8.persistence.TurmaDTO;
import com.dsg8.service.ServiceInterface;

public class Client {

	private Registry registry;
	ServiceInterface server;

	public Client() throws RemoteException, NotBoundException {

		registry = LocateRegistry.getRegistry("localhost");
		server = (ServiceInterface) registry.lookup("AlocacaoProfessoresService");

	}

	public List<Professor> listaProfessoresSemAlocacaoCompleta() throws RemoteException {

		return server.listaProfessoresSemAlocacaoCompleta();

	}
	public List<ProfessorDTO> listaProfessoresSemAlocacao() throws RemoteException {

		return server.listaProfessoresSemAlocacao();
	}

	public List<Professor> listaProfessoresAlocados() throws RemoteException {

		return server.listaProfessoresAlocados();
	}
	
	public boolean alocarProfessorTurmaDisciplina(AlocacaoDTO alocacaoDTO) throws RemoteException {
		return server.alocarProfessorTurmaDisciplina(alocacaoDTO);
	}
	
	public List<TurmaDTO> listarTurmas() throws RemoteException {
		return server.listarTurmas();
	}

	public List<DisciplinaDTO> listarDisciplina() throws RemoteException {
		return server.listarDisciplina();
	}
	
	public ProfessorDTO buscarProfessor(long codigo) throws RemoteException {
		return server.buscarProfessor(codigo);
	}
	
}
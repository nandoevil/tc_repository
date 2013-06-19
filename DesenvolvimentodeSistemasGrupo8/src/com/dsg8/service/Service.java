package com.dsg8.service;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Service {
	private ServiceInterface service;
	private Registry registry;
	
	public Service() throws RemoteException, AlreadyBoundException {
	
		service = new ServiceImpl();
		registry = LocateRegistry.createRegistry(1099);
		registry.bind("AlocacaoProfessoresService", service);
		
	}	
	
}

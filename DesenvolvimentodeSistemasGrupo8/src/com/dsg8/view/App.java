package com.dsg8.view;

import org.apache.log4j.Logger;

public class App {
	
	private static final Logger log= Logger.getLogger(App.class);

	public static void main(String[] args) {
		System.out.println("Teste OK...");
		log.debug("Testing...");
		log.info("Testing...");
	}

}

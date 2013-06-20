package com.dsg8.client.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnAlocarProfessor = new JButton("Alocar Professor");
		btnAlocarProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AlocacaoClientView().frame.setVisible(true);
			}
		});
		frame.getContentPane().add(btnAlocarProfessor, BorderLayout.EAST);
		
		JButton btnNewButton = new JButton("Consultar Alocacao Professor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		frame.getContentPane().add(btnNewButton, BorderLayout.WEST);
	}

}

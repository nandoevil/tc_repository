package com.dsg8.client.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.dsg8.client.model.Client;
import com.dsg8.persistence.AlocacaoDTO;
import com.dsg8.persistence.DisciplinaDTO;
import com.dsg8.persistence.ProfessorDTO;
import com.dsg8.persistence.TurmaDTO;

public class AlocacaoProfessoresView extends JFrame {

	public JFrame frame;
	private Client cliente;
	private List professorList = new List();
	private List turmaList = new List();
	private List disciplinaList = new List();
	private java.util.List<DisciplinaDTO> listD;
	private java.util.List<ProfessorDTO> listP = new ArrayList<ProfessorDTO>();
	private java.util.List<TurmaDTO> listT;
	private ProfessorDTO professorEscolhido;
	private TurmaDTO turmaEscolhida;
	private DisciplinaDTO disciplinaEscolhida;
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlocacaoProfessoresView window = new AlocacaoProfessoresView();
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
	public AlocacaoProfessoresView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		try{
			cliente = new Client();
			
		}catch(Throwable e){
			e.printStackTrace();
		}
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText() != null && !"".equalsIgnoreCase(textField.getText())){
					try{
						professorEscolhido = cliente.buscarProfessor(Long.parseLong(textField.getText()));
					
						listP.add(professorEscolhido);
						
						if(professorEscolhido == null || professorEscolhido.getCodigo() <= 0){
							JOptionPane.showMessageDialog(null, "Professor não cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
						}
						
						for (ProfessorDTO p : listP) {
							professorList.add(p.getCodigo()+" - "+p.getNome());
						}
						
						//listT = cliente.listarTurmas();
						
						//TESTE
						listT = new ArrayList<TurmaDTO>();
						
						TurmaDTO tdto = new TurmaDTO();
						tdto.setCodigo(1);
						tdto.setNome("Turma");
						listT.add(tdto);
						
						if(listT != null && listT.size() > 0){
							for (TurmaDTO t : listT) {
								turmaList.add(t.getCodigo()+" - "+t.getNome());
							}
						}else{
							JOptionPane.showMessageDialog(null, "Não há disciplinas!", "Erro", JOptionPane.ERROR_MESSAGE);
						}
						
						//listD = cliente.listarDisciplina();
						
						//TESTE
						listD = new ArrayList<DisciplinaDTO>();
						
						DisciplinaDTO ddto = new DisciplinaDTO();
						ddto.setCodigo(1);
						ddto.setNome("Disciplina");
						listD.add(ddto);
						
						if(listD != null && listD.size() > 0){
							for (DisciplinaDTO d : listD) {
								disciplinaList.add(d.getCodigo()+" - "+d.getNome());
							}
						}else{
							JOptionPane.showMessageDialog(null, "Não há disciplinas!", "Erro", JOptionPane.ERROR_MESSAGE);
						}
						
					}catch(Throwable e){
						e.printStackTrace();
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "Digite o código do professor!", "Código Inválido", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		panel.add(btnNewButton);
		
		//BOTAO
		Button button = new Button("Alocar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(professorEscolhido != null && turmaEscolhida != null && disciplinaEscolhida != null){
						
						AlocacaoDTO alocacao = new AlocacaoDTO();
						alocacao.setCodigoProfessor(professorEscolhido.getCodigo());
						alocacao.setCodigoTurma(turmaEscolhida.getCodigo());
						alocacao.setCodigoDisciplina(disciplinaEscolhida.getCodigo());
						
						cliente.alocarProfessorTurmaDisciplina(alocacao);
						
						JOptionPane.showMessageDialog(null, "Alocação Realizada com Sucesso!", "Sucesso", JOptionPane.ERROR_MESSAGE);
						
					}else{
						JOptionPane.showMessageDialog(null, "Escolha o professor a  turma e a disciplina!", "Alocação Inválida", JOptionPane.ERROR_MESSAGE);
					}
				}catch(Throwable e){
					e.printStackTrace();
				}
				
			}
		});
		
		//TURMA
		turmaList = new List();
		turmaList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = turmaList.getSelectedIndex();
				turmaEscolhida = listT.get(index);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Limpar Registros");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				professorList.removeAll();
				turmaList.removeAll();
				disciplinaList.removeAll();
				listP = new ArrayList<ProfessorDTO>();
				listT = new ArrayList<TurmaDTO>();
				listD = new ArrayList<DisciplinaDTO>();
				professorEscolhido = new ProfessorDTO();
				turmaEscolhida = new TurmaDTO();
				disciplinaEscolhida = new DisciplinaDTO();
				 
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Limpar2");
		btnNewButton_2.setVisible(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(btnNewButton_2);
		panel.add(turmaList);
		
		//PROFESSOR
		professorList = new List();
		professorList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = professorList.getSelectedIndex();
				professorEscolhido = listP.get(index);
				
			}
		});
		
		//DISCIPLINA
		disciplinaList = new List();
		disciplinaList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = disciplinaList.getSelectedIndex();
				disciplinaEscolhida = listD.get(index);
			}
		});
		panel.add(disciplinaList);
		panel.add(professorList);
		
		panel.add(button);
	}

}


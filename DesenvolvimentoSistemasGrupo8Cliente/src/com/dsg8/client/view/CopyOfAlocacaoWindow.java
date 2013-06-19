package com.dsg8.client.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.dsg8.client.model.Client;
import com.dsg8.persistence.AlocacaoDTO;
import com.dsg8.persistence.DisciplinaDTO;
import com.dsg8.persistence.ProfessorDTO;
import com.dsg8.persistence.TurmaDTO;

public class CopyOfAlocacaoWindow extends JFrame {

	public JFrame frame;
	private Client cliente;
	private List professorList = new List();
	private List turmaList = new List();
	private List disciplinaList = new List();
	private java.util.List<DisciplinaDTO> listD;
	private java.util.List<ProfessorDTO> listP;
	private java.util.List<TurmaDTO> listT;
	private ProfessorDTO professorEscolhido;
	private TurmaDTO turmaEscolhida;
	private DisciplinaDTO disciplinaEscolhida;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CopyOfAlocacaoWindow window = new CopyOfAlocacaoWindow();
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
	public CopyOfAlocacaoWindow() {
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
		
		//PROFESSOR
		professorList = new List();
		professorList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = professorList.getSelectedIndex();
				professorEscolhido = listP.get(index);
				
			}
		});
		
		try{
			listP = cliente.listaProfessoresSemAlocacao();
			
			//TESTE
			/*listP = new ArrayList<ProfessorDTO>();
			
			ProfessorDTO pdto = new ProfessorDTO();
			pdto.setCodigo(1);
			pdto.setNome("Professor");
			
			ProfessorDTO pdto2 = new ProfessorDTO();
			pdto2.setCodigo(1);
			pdto2.setNome("Professor");
			
			listP.add(pdto);
			listP.add(pdto2);*/
			
			for (ProfessorDTO p : listP) {
				professorList.add(p.getCodigo()+" - "+p.getNome());
			}
			
		}catch(Throwable e){
			e.printStackTrace();
		}
		panel.add(professorList);
		
		//TURMA
		turmaList = new List();
		turmaList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = turmaList.getSelectedIndex();
				turmaEscolhida = listT.get(index);
			}
		});
		try{
			listT = cliente.listarTurmas();
			
			//TESTE
			/*listT = new ArrayList<TurmaDTO>();
			
			TurmaDTO tdto = new TurmaDTO();
			tdto.setCodigo(1);
			tdto.setNome("Turma");
			listT.add(tdto);*/
			
			for (TurmaDTO t : listT) {
				turmaList.add(t.getCodigo()+" - "+t.getNome());
			}
			
		}catch(Throwable e){
			e.printStackTrace();
		}
		panel.add(turmaList);
		
		//DISCIPLINA
		disciplinaList = new List();
		disciplinaList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = disciplinaList.getSelectedIndex();
				disciplinaEscolhida = listD.get(index);
			}
		});
		try{
			listD = cliente.listarDisciplina();
			
			//TESTE
			/*listD = new ArrayList<DisciplinaDTO>();
			
			DisciplinaDTO ddto = new DisciplinaDTO();
			ddto.setCodigo(1);
			ddto.setNome("Disciplina");
			listD.add(ddto);*/
			
			for (DisciplinaDTO d : listD) {
				disciplinaList.add(d.getCodigo()+" - "+d.getNome());
			}
			
		}catch(Throwable e){
			e.printStackTrace();
		}
		panel.add(disciplinaList);
		
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
						
					}else{
						JOptionPane.showMessageDialog(null, "Escolha o professor a  turma e a disciplina!", "Alocação Inválida", JOptionPane.ERROR_MESSAGE);
					}
				}catch(Throwable e){
					e.printStackTrace();
				}
				
			}
		});
		
		panel.add(button);
	}

}


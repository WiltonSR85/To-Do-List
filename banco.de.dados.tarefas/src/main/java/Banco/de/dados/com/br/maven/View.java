package Banco.de.dados.com.br.maven;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame {
	private TarefaDAO tarefaDAO;
	private CardLayout cardlayout;
	private JPanel painelPrincipal;
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public View() {
		
		tarefaDAO = new TarefaDAO();
		setSize(1069, 629);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(75, 53, 52));
		setBackground(new Color(75, 53, 52));
		
		cardlayout = new CardLayout();
		painelPrincipal = new JPanel(cardlayout);
		
		painelPrincipal.add(telaPrincipal(), "Tela Principal");
		painelPrincipal.add(telaSalvar(), "Tela Salvar");
		painelPrincipal.add(telaBuscarTarefas(), "Tela Buscar Tarefas");
		//painelPrincipal.add(telaBuscarID(), "Tela Buscar por ID");
		painelPrincipal.add(telaAtualizar(), "Tela Atualizar");
		painelPrincipal.add(telaExcluir(), "Tela Excluir");
		
		getContentPane().add(painelPrincipal);
		setVisible(true);
	}
	
	private JPanel telaPrincipal() {
		JPanel painel2= new JPanel();
		painel2.setBackground(new Color(128, 128, 255));
		painel2.setLayout(null);
		
		JLabel mensagemBoasVindas = new JLabel("Bem vindo ao sistema de gerenciamento de tarefas!");
		mensagemBoasVindas.setHorizontalAlignment(SwingConstants.CENTER);
		mensagemBoasVindas.setFont(new Font("Arial Black", Font.BOLD, 12));
		mensagemBoasVindas.setBounds(148, 11, 786, 25);
		painel2.add(mensagemBoasVindas);
		
		JButton botaoSalvar = new JButton("Salvar Tarefa");
		botaoSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(painelPrincipal, "Tela Salvar");
			}
		});
		botaoSalvar.setFont(new Font("Arial", Font.PLAIN, 12));
		botaoSalvar.setBorderPainted(false);
		botaoSalvar.setBounds(463, 76, 140, 23);
		painel2.add(botaoSalvar);
		
		JButton botaoBuscarTarefas = new JButton("Tarefas");
		botaoBuscarTarefas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(painelPrincipal, "Tela Buscar Tarefas");
			}
		});
		botaoBuscarTarefas.setFont(new Font("Arial", Font.PLAIN, 12));
		botaoBuscarTarefas.setBorderPainted(false);
		botaoBuscarTarefas.setBounds(463, 152, 140, 23);
		painel2.add(botaoBuscarTarefas);
		
		/*JButton botaoBuscarID = new JButton("Buscar por ID");
		botaoBuscarID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(painelPrincipal, "Tela Buscar por ID");
			}
		});
		botaoBuscarID.setFont(new Font("Arial", Font.PLAIN, 12));
		botaoBuscarID.setBorderPainted(false);
		botaoBuscarID.setBounds(258, 188, 140, 23);
		painel2.add(botaoBuscarID);*/
		
		JButton botaoAtualizar = new JButton("Atualizar Tarefa");
		botaoAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(painelPrincipal, "Tela Atualizar");
			}
		});
		botaoAtualizar.setFont(new Font("Arial", Font.PLAIN, 12));
		botaoAtualizar.setBorderPainted(false);
		botaoAtualizar.setBounds(463, 231, 140, 23);
		painel2.add(botaoAtualizar);
		
		JButton botaoExcluir = new JButton("Excluir Tarefa");
		botaoExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(painelPrincipal, "Tela Excluir");
			}
		});
		botaoExcluir.setFont(new Font("Arial", Font.PLAIN, 12));
		botaoExcluir.setBorderPainted(false);
		botaoExcluir.setBounds(463, 319, 140, 23);
		painel2.add(botaoExcluir);
		
		return painel2;
	}
	
	private JPanel telaSalvar() {
		JPanel painel3= new JPanel();
		painel3.setBackground(new Color(128, 128, 255));
		painel3.setLayout(null);
		
		JLabel mensagemSalvar = new JLabel("Adicione as informações da tarefa que deseja salvar:");
		mensagemSalvar.setFont(new Font("Arial", Font.BOLD, 12));
		mensagemSalvar.setBounds(171, 21, 328, 14);
		painel3.add(mensagemSalvar);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTitulo.setBounds(73, 98, 89, 14);
		painel3.add(lblTitulo);
		
		JLabel lblDescricao = new JLabel("Descricão:");
		lblDescricao.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDescricao.setBounds(73, 169, 78, 14);
		painel3.add(lblDescricao);
		
		/*JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Arial", Font.PLAIN, 12));
		lblData.setBounds(73, 241, 67, 14);
		painel3.add(lblData);*/
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSalvar.setBounds(498, 378, 89, 23);
		painel3.add(btnSalvar);
		
		JTextField textFieldTitulo = new JTextField();
		textFieldTitulo.setBounds(73, 123, 911, 20);
		painel3.add(textFieldTitulo);
		textFieldTitulo.setColumns(10);
		
		JTextField textFieldDescricao = new JTextField();
		textFieldDescricao.setBounds(73, 194, 911, 20);
		painel3.add(textFieldDescricao);
		textFieldDescricao.setColumns(10);
		
		/*JTextField textFieldData = new JTextField();
		textFieldData.setBounds(73, 266, 507, 20);
		painel3.add(textFieldData);
		textFieldData.setColumns(10);*/
		
		JButton btnVoltarSalvar = new JButton("Voltar");
		btnVoltarSalvar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVoltarSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(painelPrincipal, "Tela Principal");
			}
		});
		btnVoltarSalvar.setBounds(73, 378, 89, 23);
		painel3.add(btnVoltarSalvar);
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo= textFieldTitulo.getText();
				String descricao= textFieldDescricao.getText();
				//String data= textFieldData.getText();
				
				Tarefa tarefa;
				
				/*if(data== null || data.isEmpty()) {
					tarefa= new Tarefa(titulo, descricao);
				}
				else {
					tarefa= new Tarefa(titulo, descricao, data);
				}*/
				
				tarefa= new Tarefa(titulo, descricao);
				
				
				try {
					tarefaDAO.salvar(tarefa);
					JOptionPane.showMessageDialog(painel3, "Tarefa salva com sucesso!");
					cardlayout.show(painelPrincipal, "Tela Buscar Tarefas");
                    painelPrincipal.add(telaBuscarTarefas(), "Tela Buscar Tarefas");
					cardlayout.show(painelPrincipal, "Tela Principal");
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(painel3, "Erro :"+ ex.getMessage());
				}
				
			}
		});
		
		return painel3;
	}
	
	private JPanel telaBuscarTarefas() {
		JPanel painel4= new JPanel(new BorderLayout());
		painel4.setBackground(new Color(255, 255, 255));
		
		JLabel mensagemLista = new JLabel("Lista de Tarefas:");
		mensagemLista.setHorizontalAlignment(SwingConstants.CENTER);
		mensagemLista.setFont(new Font("Arial", Font.BOLD, 12));
		mensagemLista.setBounds(293, 25, 127, 14);
		painel4.add((mensagemLista), BorderLayout.NORTH);
		
		String [] colunaTabela = {"ID", "Titulo", "Descricao", "Data"};
		DefaultTableModel modelo= new DefaultTableModel(colunaTabela, 0);
		JTable tabela= new JTable(modelo);
		tabela.setBackground(new Color(255, 255, 255));
		tabela.setForeground(new Color(0, 0, 0));
		tabela.setFont(new Font("Arial", Font.PLAIN, 11));
		
		try {
			List<Tarefa> tarefas= tarefaDAO.buscarTodos();
			for(Tarefa tarefa : tarefas) {
				modelo.addRow(new Object[] {tarefa.getId(), tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getData()});
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(painel4, "Erro: " +e.getMessage());
		}
		
		painel4.add(new JScrollPane(tabela), BorderLayout.CENTER);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(painelPrincipal, "Tela Principal");
			}
		});
		btnVoltar.setBounds(51, 442, 89, 23);
		painel4.add(btnVoltar, BorderLayout.SOUTH);
		
		return painel4;
	}
	
	private JPanel telaAtualizar() {
		JPanel painel5= new JPanel();
		painel5.setBackground(new Color(128, 128, 255));
		painel5.setLayout(null);
		
		JLabel lblMensagemAtualizar = new JLabel("Digite as informações da tarefa que deseja atualizar!");
		lblMensagemAtualizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagemAtualizar.setFont(new Font("Arial", Font.BOLD, 12));
		lblMensagemAtualizar.setBounds(180, 11, 349, 14);
		painel5.add(lblMensagemAtualizar);
		
		JTextField textID = new JTextField();
		textID.setBounds(38, 114, 971, 20);
		painel5.add(textID);
		textID.setColumns(10);
		
		JTextField textTitulo = new JTextField();
		textTitulo.setBounds(38, 213, 971, 20);
		painel5.add(textTitulo);
		textTitulo.setColumns(10);
		
		JTextField textDescricao = new JTextField();
		textDescricao.setBounds(38, 300, 971, 20);
		painel5.add(textDescricao);
		textDescricao.setColumns(10);
		
		/*JTextField textData = new JTextField();
		textData.setBounds(38, 383, 619, 20);
		painel5.add(textData);
		textData.setColumns(10);*/
		
		JLabel lblIDAtualizar = new JLabel("Digite o ID da tarefa que deseja atualizar:");
		lblIDAtualizar.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIDAtualizar.setBounds(38, 89, 251, 14);
		painel5.add(lblIDAtualizar);
		
		JLabel lblTituloAtualizar = new JLabel("Digite o novo titulo:");
		lblTituloAtualizar.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTituloAtualizar.setBounds(38, 193, 169, 14);
		painel5.add(lblTituloAtualizar);
		
		JLabel lblDescricaoAtualizar = new JLabel("Digite a nova descricão:");
		lblDescricaoAtualizar.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDescricaoAtualizar.setBounds(38, 274, 158, 14);
		painel5.add(lblDescricaoAtualizar);
		
		/*JLabel lblDataAtualizar = new JLabel("Digite o novo Data:");
		lblDataAtualizar.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDataAtualizar.setBounds(38, 358, 158, 14);
		painel5.add(lblDataAtualizar);*/
		
		JButton btnVoltarAtualizar = new JButton("Voltar");
		btnVoltarAtualizar.setBounds(51, 442, 89, 23);
		btnVoltarAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(painelPrincipal, "Tela Principal");
			}
		});
		painel5.add(btnVoltarAtualizar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(526, 442, 89, 23);
		painel5.add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long id= Long.parseLong(textID.getText());
				try {
	                Tarefa tarefaExistente = tarefaDAO.buscarPorID(id);
	                if (tarefaExistente != null) {
	                    String titulo = textTitulo.getText();
	                    String descricao = textDescricao.getText();
	                    //String data = textData.getText();
	                    
	                    Tarefa tarefaAtualizada;
	    				
	    				/*if(data== null || data.isEmpty()) {
	    					tarefaAtualizada= new Tarefa(id,titulo, descricao);
	    				}
	    				else {
	    					tarefaAtualizada= new Tarefa(id,titulo, descricao, data);
	    				}*/
	    				
	    				tarefaAtualizada= new Tarefa(id,titulo, descricao);
	                    tarefaDAO.atualizar(tarefaAtualizada);
	                    JOptionPane.showMessageDialog(painel5, "Tarefa atualizada com sucesso!");
	                    cardlayout.show(painelPrincipal, "Tela Buscar Tarefas");
	                    painelPrincipal.add(telaBuscarTarefas(), "Tela Buscar Tarefas");
	                    cardlayout.show(painelPrincipal, "Tela Principal");
	                } else {
	                    JOptionPane.showMessageDialog(painel5, "Tarefa não encontrado!");
	                }
	            } catch (Exception ex) {
	                JOptionPane.showMessageDialog(painel5, "Erro: " + ex.getMessage());
	            }
			}
		});
		return painel5;
	}
	
	private JPanel telaExcluir() {
		JPanel painel6= new JPanel();
		painel6.setBackground(new Color(128, 128, 255));
		painel6.setLayout(null);
		
		JLabel lblMensagemExcluir = new JLabel("Informe o ID da tarefa que deseja excluir");
		lblMensagemExcluir.setFont(new Font("Arial", Font.BOLD, 12));
		lblMensagemExcluir.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagemExcluir.setBounds(168, 11, 355, 14);
		painel6.add(lblMensagemExcluir);
		
		JLabel lblIdExcluir = new JLabel("ID da tarefa que será excluida");
		lblIdExcluir.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIdExcluir.setBounds(73, 206, 203, 14);
		painel6.add(lblIdExcluir);
		
		JTextField textFieldId = new JTextField();
		textFieldId.setBounds(73, 231, 919, 20);
		painel6.add(textFieldId);
		textFieldId.setColumns(10);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Arial", Font.PLAIN, 12));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long id = Long.parseLong(textFieldId.getText());
	            try {
	                tarefaDAO.excluir(id);
	                JOptionPane.showMessageDialog(painel6, "Tarefa excluída com sucesso!");
	                cardlayout.show(painelPrincipal, "Tela Buscar Tarefas");
                    painelPrincipal.add(telaBuscarTarefas(), "Tela Buscar Tarefas");
                    cardlayout.show(painelPrincipal, "Tela Principal");
	            } catch (Exception ex) {
	                JOptionPane.showMessageDialog(painel6, "Erro: " + ex.getMessage());
	            }
			}
		});
		btnExcluir.setBounds(527, 429, 89, 23);
		painel6.add(btnExcluir);
		
		JButton btnVoltarExcluir = new JButton("Voltar");
		btnVoltarExcluir.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVoltarExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(painelPrincipal, "Tela Principal");
			}
		});
		btnVoltarExcluir.setBounds(57, 429, 89, 23);
		painel6.add(btnVoltarExcluir);
		
		return painel6;
	}
}


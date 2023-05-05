package aula_05;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InterfaceGrafica extends JFrame implements ActionListener {
	
	ConexaoBancoDeDados objBanco;
	
	private JButton botaoINSERIR;
	private JButton botaoREMOVER;
	private JButton botaoALTERAR;
	private JButton botaoPESQUISAR;
	
	private JLabel lblNome;
	private JLabel lblEndereco;
	private JLabel lblTelefone;
	private JLabel lblResultadoPesquisa;
	private JLabel lblMensagem;
	private JLabel lblId;
	
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtTelefone;
	private JTextField txtId;
	
	private JTextArea listaPesquisaBancoDeDados;
	private JScrollPane scrollPesquisaBancoDeDados;
	
	private Container janelaPrincipal;
	
	public InterfaceGrafica() {
		
		setSize(900, 370);
		setTitle("Conexão com Banco de Dados");
		janelaPrincipal = getContentPane();
		janelaPrincipal.setLayout(null);
		
		txtNome = new JTextField();
		txtEndereco = new JTextField();
		txtTelefone = new JTextField();
		txtId = new JTextField();
		
		botaoINSERIR = new JButton("Inserir");
		botaoREMOVER = new JButton("Remover");
		botaoALTERAR = new JButton("Alterar");
		botaoPESQUISAR = new JButton("Pesquisar");
		
		lblMensagem = new JLabel("----");
		lblNome = new JLabel("Nome");
		lblId = new JLabel("ID");
		lblResultadoPesquisa = new JLabel("Resultado da pesquisa no Banco de Dados");
		lblTelefone = new JLabel("Telefone");
		lblEndereco = new JLabel("Endereço");
		
		listaPesquisaBancoDeDados = new JTextArea();
		scrollPesquisaBancoDeDados = new JScrollPane(listaPesquisaBancoDeDados);
		
		botaoINSERIR.setBounds(10, 215, 90, 40);
		botaoREMOVER.setBounds(102, 280, 90, 40);
		botaoALTERAR.setBounds(10, 280, 90, 40);
		botaoPESQUISAR.setBounds(102, 215, 95, 40);
		
		lblEndereco.setBounds(10, 85, 100, 20);
		lblMensagem.setBounds(50, 170, 250, 20);
		lblNome.setBounds(10, 40, 40 ,20);
		lblId.setBounds(220, 285, 30, 30);
		lblResultadoPesquisa.setBounds(480, 5, 300, 20);
		lblTelefone.setBounds(10, 130, 100, 20);
		scrollPesquisaBancoDeDados.setBounds(420, 25, 450, 235);
		
		txtNome.setBounds(100, 40, 200, 25);
		txtEndereco.setBounds(100, 85, 200, 25);
		txtTelefone.setBounds(100, 130, 200, 25);
		txtId.setBounds(240, 285, 30, 30);
		
		janelaPrincipal.add(botaoINSERIR);
		janelaPrincipal.add(botaoREMOVER);
		janelaPrincipal.add(botaoALTERAR);
		janelaPrincipal.add(botaoPESQUISAR);
		janelaPrincipal.add(lblEndereco);
		janelaPrincipal.add(lblMensagem);
		janelaPrincipal.add(lblNome);
		janelaPrincipal.add(lblId);
		janelaPrincipal.add(lblResultadoPesquisa);
		janelaPrincipal.add(lblTelefone);
		janelaPrincipal.add(scrollPesquisaBancoDeDados);
		janelaPrincipal.add(txtNome);
		janelaPrincipal.add(txtEndereco);
		janelaPrincipal.add(txtTelefone);
		janelaPrincipal.add(txtId);
		
		setVisible(true);
		
		botaoINSERIR.addActionListener(this);
		botaoREMOVER.addActionListener(this);
		botaoALTERAR.addActionListener(this);
		botaoPESQUISAR.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// inserir
		
		if (e.getActionCommand().equals("Inserir")) {
			
			Pessoa objPessoa = new Pessoa(txtNome.getText(), txtEndereco.getText(), txtTelefone.getText());
			
			try {
				 ConexaoBancoDeDados objBanco = new ConexaoBancoDeDados();
				 String msg = objBanco.InserirDados(objPessoa);
				 lblMensagem.setText(msg);
			}
			catch(SQLException el) {
				el.printStackTrace();
			}
		}
		
		// remover
		
		if (e.getActionCommand().equals("Remover")) {
			
			Pessoa objPessoa = new Pessoa(txtNome.getText(), txtEndereco.getText(), txtTelefone.getText());
			
			try {
				ConexaoBancoDeDados objBanco = new ConexaoBancoDeDados();
				int id = Integer.parseInt(txtId.getText()); 
				String msg = objBanco.RemoverDados(id);
				lblMensagem.setText(msg);
			}
			catch(SQLException el) {
				el.printStackTrace();
			}
		}
		
		// alterar
		
		if (e.getActionCommand().equals("Alterar")) {
			
			Pessoa objPessoa = new Pessoa(txtNome.getText(), txtEndereco.getText(), txtTelefone.getText());
			
			try {
				 ConexaoBancoDeDados objBanco = new ConexaoBancoDeDados();
				 int id = Integer.parseInt(txtId.getText());
				 String msg = objBanco.AlterarDados(objPessoa, id);
				 lblMensagem.setText(msg);
			}
			catch(SQLException el) {
				el.printStackTrace();
			}
		}
		
		// pesquisar
		
		if (e.getActionCommand().equals("Pesquisar")) {
			
			Pessoa objPessoa = new Pessoa(txtNome.getText(), txtEndereco.getText(), txtTelefone.getText());
			
			try {
				 ConexaoBancoDeDados objBanco = new ConexaoBancoDeDados();
				 ArrayList<String> objRelatorio = objBanco.relatorio();
				 listaPesquisaBancoDeDados.setText("");
				 for(String txt: objRelatorio) {
					 listaPesquisaBancoDeDados.append(txt + "\n\n");
				 }
			}
			catch(SQLException el) {
				el.printStackTrace();
			}
		}

	}

}
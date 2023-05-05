package aula_05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ConexaoBancoDeDados {

		private Connection conn;

		private String url = "jdbc:mysql://localhost:3306/NOME_DO_BANCO";
		private String user = "root";
		private String password = "admin";
		
		private void IniciarConexao() {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url,user,password);
				System.out.println("Conexao realizada com sucesso! ");
			}
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("Erro ao acessar o Banco de Dados! ");
			}
		}
		
		private void EncerrarConexao() throws SQLException {
			
			if (conn != null) {
				conn.close();
			}
			
		}

		public String InserirDados(Pessoa objPessoa) throws SQLException {
			
			IniciarConexao();
			
			if (conn != null) {
				
				PreparedStatement inserir = conn.prepareStatement("INSERT INTO pessoas (nome, endereco, telefone) values(?, ?, ?)");
				inserir.setString(1, objPessoa.getNome());
				inserir.setString(2, objPessoa.getEndereco());
				inserir.setString(3, objPessoa.getTelefone());
				inserir.execute();
				
				EncerrarConexao();			
				return "Cadastro realizado com sucesso!";
			}
			else {
				return "Erro. Inserção não realizada!";	
			}
		}

		public String AlterarDados(Pessoa objPessoa, int id) throws SQLException {
			
			IniciarConexao();
			
			if (conn != null) {
				
				PreparedStatement atualizar = conn.prepareStatement("UPDATE pessoas SET endereco = ?, telefone = ?, nome = ? WHERE id = ?");
				atualizar.setString(1, objPessoa.getEndereco());
				atualizar.setString(2, objPessoa.getTelefone());
				atualizar.setString(3, objPessoa.getNome());
				atualizar.setInt(4 , id);
				atualizar.execute();
				
				EncerrarConexao();
				return "Alteração realizada com sucesso!";
			}
			else {
				return "Erro! Alteração não realizada";
			}
		}
		
		public String RemoverDados(int id) throws SQLException {
			
			IniciarConexao();
			
			if (conn != null) {
				
				PreparedStatement delete = conn.prepareStatement("DELETE FROM pessoas WHERE id = ?");
				delete.setInt(1, id);
				delete.execute();
				EncerrarConexao();
				
				return "Remoção realizada com sucesso!";
			}
			else {
				return "Erro. Remoção não realizada!";
			}
		}
		
		public ArrayList<String> relatorio() throws SQLException {
			
			IniciarConexao();
			
			ArrayList<String> objRelatorio = new ArrayList<String>();
			
			if (conn != null) {
				
				Statement comandoConsulta = conn.createStatement();
				ResultSet resultadoConsulta = comandoConsulta.executeQuery("SELECT * FROM pessoas");
				String resultado;
				String nome;
				String endereco;
				String telefone;
				String id;
				
					while (resultadoConsulta.next()) {
						
						nome = resultadoConsulta.getString("nome");
						endereco = resultadoConsulta.getString("endereco");
						telefone = resultadoConsulta.getString("telefone");
						id = resultadoConsulta.getString("id");
						
						resultado = "ID: "+ id
								+ "\nNome: " + nome
								+ "\nEndereço: " + endereco
								+ "\nTelefone: " + telefone;
						
						objRelatorio.add(resultado);
					}
					
				EncerrarConexao();
			
				return objRelatorio;
			}
			
		return null;	
	}
				
}
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class RepositorioConexao {
	 private static Connection conn = null;
	 private Statement statement = null;
	 public ResultSet resultset= null;
	public Object executaSQL;
	 
	 private static String servidor= "jdbc:mysql://localhost:3306/acmr";
	 private static String usuario = "marcos";
	 private static String senha = "nem1234"; 
	private static String driver = "com.mysql.jdbc.Driver"; 
	 
	 
	public static Connection conectaBD(){	 
		try {
				Class.forName(driver);
				return DriverManager.getConnection(servidor,usuario,senha );
				
				
		      } catch (SQLException e) {
				JOptionPane.showMessageDialog(null,"Conexao" + e.getMessage());
				
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
		return conn;

	}
	
	public boolean estaConectado() {
		if (RepositorioConexao.conn != null) {
			System.out.println("Conectou");
			return true;
		}else {
			return false;
		}
	}
	
	public void desconectar() {
		try {
			RepositorioConexao.conn.close();
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Desconectar" + e.getMessage());
			
		}
	}
	
	public void listaUsuario() {
		try {
			String query= "select * from disciplinas;";
			this.resultset = this.statement.executeQuery(query);
			this.statement= RepositorioConexao.conn.createStatement();
			while(this.resultset.next()) {
				System.out.println("ID:" + this.resultset.getString("id") + " - nome:" +this.resultset.getString("nome") 
				+ " - email:" +this.resultset.getString("email")  + " - senha:" +this.resultset.getString("senha"));
			}
		}catch (SQLException e) {
			System.out.println("Erro no buscar " + e.getMessage());
		}
	}
	
	public void inserirUsuario(String nome , String email , String senha) {
		try {
			String query= "INSERT INTO cadastrousuarios (nome , email, senha) VALUES ('" +nome+ "', '" + email + "', '" + senha + "') ;";  
		    this.statement.executeUpdate(query);
		}catch (SQLException e) {
			System.out.println("Erro no inserir " + e.getMessage());
		}
			
	
	}

	public void executaSQL(String string) {
		// TODO Auto-generated method stub
		
	}
}



package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import entidades.EntidadeAluno;
import entidades.ExisteUsuario;

public class AlunoRepositorio {
	private  boolean podepassa;

public AlunoRepositorio() throws SQLException, ClassNotFoundException {
       super();
    }
public void Cadastrar(EntidadeAluno aluno) throws SQLException, Exception {
   Connection con= RepositorioConexao.conectaBD();
   String sql = "INSERT into CadastroUsuarios ( nome, email, senha ) values (?, ?, ?)";
	 try {
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setString(1, aluno.getNome());
	    ps.setString(2, aluno.getEmail());
	    ps.setString(3, aluno.getSenha());
	    ps.executeUpdate();
	    ps.close();
	 } catch (SQLException ex) {
	       System.out.println(ex);
	        throw new Exception(ex.getMessage());
	  } finally {
	     con.close();
	}
}

public void buscaUsuario( ExisteUsuario usuario) {
	try {
		Connection con= RepositorioConexao.conectaBD();
		String sql="select * from CadastroUsuarios where email=? and senha=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, usuario.getEmail());
		stmt.setString(2,usuario.getSenha());
		ResultSet rs = stmt.executeQuery();
			
		if(rs.next()) {
			setPodepassa(true);
		}else {
			JOptionPane.showMessageDialog(null, "Email ou senha incorreto");
		}
		stmt.close();
		con.close(); 

	}catch (SQLException e1) {
		e1.printStackTrace();
	}
	
}
public boolean getPodepassa() {
	return podepassa;
}
public void setPodepassa(boolean podepassa) {
	this.podepassa = podepassa;
}
	   
	   

}

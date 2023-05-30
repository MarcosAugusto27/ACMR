package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controller.MoldeAlunoController;

public class AlunoRepositorio {
	

	public AlunoRepositorio() throws SQLException, ClassNotFoundException {
        super();
    }
	   public void Cadastrar(MoldeAlunoController aluno) throws SQLException, Exception {
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
	   

}

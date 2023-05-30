package Teste;



import model.RepositorioConexao;
import views.TelaHomePrincipal;


public class Main {

	public static void main(String[] args) {

		 TelaHomePrincipal home = new TelaHomePrincipal();
		 home.setVisible(true);
		  
		/*   
		   RepositorioConexao con = new RepositorioConexao();
		   RepositorioConexao.conectaBD();
		   if (con.estaConectado()) {
			   con.listaUsuario();
			  con.inserirUsuario("marcos", "nem", "marcos@gmail.com");
			  con.desconectar();
		   }else {
			   System.out.println("Nao foi possivel conecta ao banco de dados!");
		   }
		 
		   
	}	   
		   
		   
		   
		   
		   
		   
		   
		   
		  /* AlunoModel aluno = new AlunoModel();
		   aluno.setId(01);
		   aluno.setNome("marcos");
		   aluno.setData(01_02_2002);
		   aluno.setEmail("marcsosbdisfedgsig");
		   aluno.setSenha("nsmsdnsjd");
	
		*/
		
	}
}



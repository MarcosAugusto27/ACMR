package controller;

import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import entidades.EntidadeAluno;
import entidades.ExisteUsuario;
import model.AlunoRepositorio;

public class ConsultasSql {
	private boolean passaTela;
	public String link;
	public String assunto;
	
public void inserirDados(JTextField txtNomeCompleto , JTextField tf_Email , JPasswordField pf_Senha ) {
	EntidadeAluno aluno = new EntidadeAluno();
    aluno.setNome(txtNomeCompleto.getText());
    aluno.setEmail(tf_Email.getText());
    aluno.setSenha(new String (pf_Senha.getPassword()));
   
    try {
		 AlunoRepositorio alunoRepositorio = new AlunoRepositorio();
		 alunoRepositorio.Cadastrar(aluno);
	} catch (Exception e1) {
		e1.printStackTrace();
		}	
	TrocarTelas trocar = new TrocarTelas();
	trocar.telaLogin();
} 
	
	
public void buscaUsuario(JTextField tfEmail,JPasswordField pfSenha) {
	ExisteUsuario usuario =new ExisteUsuario();
	 usuario.setEmail(tfEmail.getText());
	 usuario.setSenha(new String (pfSenha.getPassword()));
	 try {
		 AlunoRepositorio alunoRepositorio = new AlunoRepositorio();
		 alunoRepositorio.buscaUsuario(usuario);
		 if (alunoRepositorio.getPodepassa() != false) {
			 TrocarTelas trocar =new TrocarTelas();
				trocar.telaCurso();
				setPassaTela(true);
			 
		 }
		 
	} catch (Exception e1) {
		e1.printStackTrace();
		}	

}

public void pegarItemTabela(JTable table) {
	int selectedRow = table.getSelectedRow();
	 link = table.getValueAt(selectedRow, 3).toString();
	 assunto=table.getValueAt(selectedRow, 1).toString();
}


public void pegarItemLista(JList lista) {
	
}
public boolean getPassaTela() {
	return passaTela;
}


public void setPassaTela(boolean passaTela) {
	this.passaTela = passaTela;
}


}

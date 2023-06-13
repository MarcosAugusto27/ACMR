package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import entidades.EntidadeAluno;
import entidades.ExisteUsuario;
import model.AcoesTabela;
import model.AlunoRepositorio;

public class ConsultasSql  {
	private boolean passaTela;
	private boolean podeTrocar;
	public String link;
	private String listaDiscplina;
	private String listaAssunto;
	AcoesTabela acaoTabela= new AcoesTabela();

public void inserirDados(JTextField txtNomeCompleto , JTextField tf_Email , JPasswordField pf_Senha ) {
	EntidadeAluno aluno = new EntidadeAluno();
    aluno.setNome(txtNomeCompleto.getText());
    aluno.setEmail(tf_Email.getText());
    aluno.setSenha(new String (pf_Senha.getPassword()));
  if(aluno.passaNome==true && aluno.passaEmail==true && aluno.passaSenha==true) {
	    try {
			 AlunoRepositorio alunoRepositorio = new AlunoRepositorio();
			 alunoRepositorio.Cadastrar(aluno);
			 setPodeTrocar(true);
			 if(getPodeTrocar()==true) {
				TrocarTelas trocar = new TrocarTelas();
				trocar.telaLogin();
			 }
		} catch (Exception e1) {
			e1.printStackTrace();
	   } 
   }
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




public void caminhoPDF(String link , String assunto , JProgressBar progress1) {
	acaoTabela.baixarPdf(link, assunto, progress1);
}


public void pegarDadosLista(String linha ) {
	acaoTabela.inserirDadosLista(linha);
	
	}

public void buscarItemTabela(String table) {
	AcoesTabela acaoTabela= new AcoesTabela();
	acaoTabela.buscarNoBanco(table);
	setListaDiscplina(acaoTabela.getName());  
	setListaAssunto(acaoTabela.getAssunto()); 
}

public String[] montandoTabela(){
	String[] row = {acaoTabela.getDisciplina(),acaoTabela.getAssuntoTabela(),acaoTabela.getDatacadastro(),acaoTabela. getLinkPDF()};
	return row;
	
}

public boolean getPassaTela() {
	return passaTela;
}


public void setPassaTela(boolean passaTela) {
	this.passaTela = passaTela;
}

public boolean getPodeTrocar() {
	return podeTrocar;
}

public void setPodeTrocar(boolean podeTrocar) {
	this.podeTrocar = podeTrocar;
}


public String getListaDiscplina() {
	return listaDiscplina;
}

public void setListaDiscplina(String listaDiscplina) {
	this.listaDiscplina = listaDiscplina;
}

public String getListaAssunto() {
	return listaAssunto;
}

public void setListaAssunto(String listaAssunto) {
	this.listaAssunto = listaAssunto;
}

/**
private String disciplina;
private String assunto;
private String linkPDf;
private String dataCadastro;

public String getDisciplina() {
	return disciplina;
}
public void setDisciplina(String disciplina) {
	this.disciplina = disciplina;
}
public String getAssunto() {
	return assunto;
}
public void setAssunto(String assunto) {
	this.assunto = assunto;
}
public String getLinkPDf() {
	return linkPDf;
}
public void setLinkPDf(String linkPDf) {
	this.linkPDf = linkPDf;
}
public String getDataCadastro() {
	return dataCadastro;
}
public void setDataCadastro(String dataCadastro) {
	this.dataCadastro = dataCadastro;
}


*/



}

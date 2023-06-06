package controller;

import views.TelaCadastro;
import views.TelaCurso;
import views.TelaEsqueciSenha;
import views.TelaHomePrincipal;
import views.TelaInteraçao;
import views.TelaLogin;

public class TrocarTelas {
	
	public void telaCadastro() {
		TelaCadastro cadastro =new TelaCadastro();
		cadastro.setVisible(true);
		
	}
    public void telaCurso() {
    	TelaCurso curso =new TelaCurso();
		curso.setVisible(true);
		
	}
    
	public void telaEsqueciSenha() {
		TelaEsqueciSenha esqueciSenha =new TelaEsqueciSenha();
		esqueciSenha.setVisible(true);
		
	}
	
	public void telaHome() {
		TelaHomePrincipal home =new TelaHomePrincipal();
		home.setVisible(true);
		
	}
	
	public void telaInteraçao() {
		TelaInteraçao interaçao =new TelaInteraçao();
		interaçao.setVisible(true);
		
	}
	
	public void telaLogin(){
		TelaLogin login =new TelaLogin();
		login.setVisible(true);	
	}

}

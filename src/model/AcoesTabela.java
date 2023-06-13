package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class AcoesTabela extends RepositorioConexao{
	
	private String name;
	private String assunto;
	private String disciplina;
	private String assuntoTabela;
	private String datacadastro;
	private String linkPDF;

	
public void baixarPdf(String link , String assunto, JProgressBar progress1) {
	try {
     URL url = new URL(link); // Cria um objeto URL com a URL do arquivo a ser baixado
     URLConnection conn = url.openConnection(); // Abre uma conexão com a URL
     int size = conn.getContentLength(); // Obtém o tamanho do arquivo em bytes
	 InputStream in = url.openStream(); // Cria um objeto InputStream para ler o conteúdo da URL
	 FileOutputStream out = new FileOutputStream(System.getProperty("user.home") + "/Downloads/"+assunto+".pdf"); // Cria um objeto FileOutputStream para gravar o conteúdo do arquivo baixado
	 byte[] buffer = new byte[1024]; // Cria um buffer de bytes para armazenar os dados lidos da URL
	 int len;
	 int downloaded = 0;
	 while ((len = in.read(buffer)) > 0) { // Lê os dados da URL em blocos de 1024 bytes e grava-os no arquivo de saída
		   out.write(buffer, 0, len);
		   downloaded += len;
	       int progress = (int) ((downloaded / (float) size) * 100); // Calcula o progresso do download em porcentagem
	    JProgressBar jProgressBar = new JProgressBar();
		jProgressBar.setValue(progress); // Atualiza a barra de progresso com o valor do progresso atual
	 }
	   in.close(); // Fecha o objeto InputStream
	   out.close(); // Fecha o objeto FileOutputStream
		} catch (IOException e1) { // Captura qualquer exceção que possa ocorrer durante o download ou gravação do arquivo
		    e1.printStackTrace(); // Imprime a pilha de exceções para depuração
		}
	}


public void inserirDadosLista(String linha ) {
	try {
		Connection con= RepositorioConexao.conectaBD();
		String sql="select * from Disciplinas where disciplina = ? or assunto = ?;" ;
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,linha);
		stmt.setString(2,linha);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next() ) {
			setDisciplina( rs.getString("disciplina"));
			setAssuntoTabela(rs.getString("assunto"));
			setDatacadastro(rs.getString("datacdastro"));
			setLinkPDF(rs.getString("linkPDF"));
		}
		
		 stmt.close();
	     con.close();
	     rs.close();
	}catch (SQLException e1) {
		e1.printStackTrace();
	}
	
	
	
}


public void buscarNoBanco(String table ) {
	 try {
         
     	Connection con= RepositorioConexao.conectaBD();
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM Disciplinas WHERE disciplina LIKE '%" + table + "%'"
         		+ "OR assunto LIKE '%" + table + "%';");
       
         while (rs.next()) {
            setName(rs.getString("disciplina"));
            setAssunto(rs.getString("assunto"));
             
         }
         
         rs.close();
         stmt.close();
         con.close();
        
     } catch (SQLException ex) {
         ex.printStackTrace();
     }
 }


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getAssunto() {
	return assunto;
}


public void setAssunto(String assunto) {
	this.assunto = assunto;
}


public String getDisciplina() {
	return disciplina;
}


public void setDisciplina(String disciplina) {
	this.disciplina = disciplina;
}


public String getAssuntoTabela() {
	return assuntoTabela;
}


public void setAssuntoTabela(String assuntoTabela) {
	this.assuntoTabela = assuntoTabela;
}


public String getDatacadastro() {
	return datacadastro;
}


public void setDatacadastro(String datacadastro) {
	this.datacadastro = datacadastro;
}


public String getLinkPDF() {
	return linkPDF;
}


public void setLinkPDF(String linkPDF) {
	this.linkPDF = linkPDF;
}



}








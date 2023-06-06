package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ConsultasSql;
import controller.TrocarTelas;
import model.RepositorioConexao;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


import javax.swing.JLabel;
import javax.swing.JProgressBar;



public class TelaInteraçao extends JFrame {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected DefaultTableModel tableModel;
    protected DefaultTableModel model;
	RepositorioConexao CONEXAO = new RepositorioConexao();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInteraçao frame = new TelaInteraçao();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */


	    private JPanel contentPane;
	    private JTextField txtPesquisa;
	    private JList<String> lista;
	    private static JTable table;
	    private JScrollPane scrollPane;
		protected JProgressBar progressBar;



	    public TelaInteraçao(){
	    	
	    
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 722, 500);
	        contentPane = new JPanel();
	        contentPane.setBackground(new Color(13, 20, 89));
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        txtPesquisa = new JTextField();
	        txtPesquisa.setBounds(140, 11, 426, 33);
	        contentPane.add(txtPesquisa);
	        txtPesquisa.setColumns(10);
	        
	        JButton btnPesquisar = new JButton("Pesquisar");
	        btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        btnPesquisar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		 String pesquisa = txtPesquisa.getText();
	        	      DefaultListModel<String> model = new DefaultListModel<String>();
	        	        try {
	        	           
	        	        	Connection con= RepositorioConexao.conectaBD();
	        	            Statement stmt = con.createStatement();
	        	            ResultSet rs = stmt.executeQuery("SELECT * FROM Disciplinas WHERE disciplina LIKE '%" + pesquisa + "%'"
	        	            		+ "OR assunto LIKE '%" + pesquisa + "%';");
	        	           lista.setVisible(true);
	        	            while (rs.next()) {
	        	                String name = rs.getString("disciplina");
	        	                String assunto = rs.getString("assunto");
	        	                model.addElement(name);
	        	                model.addElement(assunto);
	        	            }
	        	            lista.setModel(model);
	        	            rs.close();
	        	            stmt.close();
	        	            con.close();
	        	            txtPesquisa.setText("");
	        	        } catch (SQLException ex) {
	        	            ex.printStackTrace();
	        	        }
	        	    }
	        		
	        	
	        });
	        btnPesquisar.setBounds(574, 13, 99, 28);
	        contentPane.add(btnPesquisar);

	        JScrollPane scrollPaneList = new JScrollPane();
	        scrollPaneList.setBounds(140, 56, 426, 130);
	        contentPane.add(scrollPaneList);

	        lista = new JList<String>();
	        lista.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mousePressed(MouseEvent e) {
	        		
	        		String linha=lista.getSelectedValue().toString();
	        		
	        		try {
						Connection con= RepositorioConexao.conectaBD();
						String sql="select * from Disciplinas where disciplina = ? or assunto = ?;" ;
						PreparedStatement stmt = con.prepareStatement(sql);
						stmt.setString(1,linha);
						stmt.setString(2,linha);
						
						ResultSet rs = stmt.executeQuery();
						lista.setVisible(false);
						while(rs.next() ) {
							String disciplina= rs.getString("disciplina");
							String assunto= rs.getString("assunto");
							String datacadastro= rs.getString("datacdastro");
							String linkPDF= rs.getString("linkPDF");
							
							String tbData[]= {disciplina,assunto,datacadastro,linkPDF};
							DefaultTableModel tblModel=(DefaultTableModel)table.getModel();
							tblModel.addRow(tbData);
							
						 
						}
						
						 stmt.close();
					     con.close();
					     rs.close();
					}catch (SQLException e1) {
						e1.printStackTrace();
					}
	        		
	        		lista.setVisible(false);
	        		
	        	}

	        });
	       
	        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	        scrollPaneList.setColumnHeaderView(lista);
	        model= new DefaultTableModel();
	        Object [] column= {"Disciplina", "Assunto", "Data cadastro","Link pdf"};
	        Object [] row = new Object [0];
	        model.setColumnIdentifiers(column);
	        
	        scrollPane = new JScrollPane();
	        scrollPane.setBounds(40, 244, 526, 118);
	        contentPane.add(scrollPane);
	        
	        table = new JTable();
	        table.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mousePressed(MouseEvent e) {
	        		ConsultasSql consulta = new ConsultasSql();
	        		consulta.pegarItemTabela(table);
	        	}
	        });
	        scrollPane.setViewportView(table);
	        table.setModel(model);
	        
	        
	        try {
				Connection con= RepositorioConexao.conectaBD();
				String sql="select * from Disciplinas ;" ;
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				
			    for (int i = 0 ; i <3 ; i++) { 
				 if(rs.next() ) {
					String disciplina= rs.getString("disciplina");
					String assunto= rs.getString("assunto");
					String datacadastro= rs.getString("datacdastro");
					String linkPDF= rs.getString("linkPDF");
					
					String tbData[]= {disciplina,assunto,datacadastro,linkPDF};
					DefaultTableModel tblModel=(DefaultTableModel)table.getModel();
					tblModel.addRow(tbData);
					
				 
				 }
			    }
			     stmt.close();
			     con.close();
			     rs.close();
			}catch (SQLException e1) {
				e1.printStackTrace();
			}
	        
	        JButton btnBaixa = new JButton("Baixar pdf");
	        btnBaixa.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		ConsultasSql consulta= new ConsultasSql();
	        		try {
	        		    URL url = new URL(consulta.link); // Cria um objeto URL com a URL do arquivo a ser baixado
	        		    URLConnection conn = url.openConnection(); // Abre uma conexão com a URL
	        		    int size = conn.getContentLength(); // Obtém o tamanho do arquivo em bytes
	        		    InputStream in = url.openStream(); // Cria um objeto InputStream para ler o conteúdo da URL
	        		    FileOutputStream out = new FileOutputStream(System.getProperty("user.home") + "/Downloads/"+consulta.assunto+".pdf"); // Cria um objeto FileOutputStream para gravar o conteúdo do arquivo baixado
	        		    byte[] buffer = new byte[1024]; // Cria um buffer de bytes para armazenar os dados lidos da URL
	        		    int len;
	        		    int downloaded = 0;
	        		    while ((len = in.read(buffer)) > 0) { // Lê os dados da URL em blocos de 1024 bytes e grava-os no arquivo de saída
	        		        out.write(buffer, 0, len);
	        		        downloaded += len;
	        		        int progress = (int) ((downloaded / (float) size) * 100); // Calcula o progresso do download em porcentagem
	        		        progressBar.setValue(progress); // Atualiza a barra de progresso com o valor do progresso atual
	        		    }
	        		    in.close(); // Fecha o objeto InputStream
	        		    out.close(); // Fecha o objeto FileOutputStream
	        		} catch (IOException e1) { // Captura qualquer exceção que possa ocorrer durante o download ou gravação do arquivo
	        		    e1.printStackTrace(); // Imprime a pilha de exceções para depuração
	        		}
	        	}
	        });
	        btnBaixa.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        btnBaixa.setBounds(574, 266, 122, 23);
	        contentPane.add(btnBaixa);
	        
	        JButton btnsair = new JButton("Sair");
	        btnsair.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		TrocarTelas trocar =new TrocarTelas();
	        		trocar.telaHome();
	        		setVisible(false);
	        	}
	        });
	        btnsair.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        btnsair.setBounds(82, 416, 89, 23);
	        contentPane.add(btnsair);
	        
	        JLabel lblNewLabel = new JLabel("Selecione o link que você deseja ");
	        lblNewLabel.setForeground(new Color(255, 255, 255));
	        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
	        lblNewLabel.setBounds(40, 216, 491, 28);
	        contentPane.add(lblNewLabel);
	        
	        JProgressBar progressBar = new JProgressBar(0,100);
	        progressBar.setBounds(442, 396, 89, 23);
	        contentPane.add(progressBar);
	        
	        JLabel lblNewLabel_1 = new JLabel("Progresso do Dowload");
	        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
	        lblNewLabel_1.setForeground(new Color(255, 255, 255));
	        lblNewLabel_1.setBounds(273, 396, 182, 23);
	        contentPane.add(lblNewLabel_1);

	    }



		private static void listaDePequisa() {

			try {
				Connection con= RepositorioConexao.conectaBD();
				String sql="select * from Disciplinas ;" ;
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next() ) {
					String disciplina= rs.getString("disciplina");
					String assunto= rs.getString("assunto");
					String datacadastro= rs.getString("datacdastro");
					String linkPDF= rs.getString("linkPDF");
					
					String tbData[]= {disciplina,assunto,datacadastro,linkPDF};
					DefaultTableModel tblModel=(DefaultTableModel)table.getModel();
					tblModel.addRow(tbData);
					
				 
				}
				 stmt.close();
			     con.close();
			     rs.close();
			}catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			
		}
}




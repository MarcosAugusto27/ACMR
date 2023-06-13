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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	ConsultasSql consulta = new ConsultasSql();
	 private DefaultTableModel tblModel;
	
	

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
		protected String link;
		protected String assunto;
		protected String[] row;



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
	        	     consulta.buscarItemTabela(pesquisa); 
	        	     lista.setVisible(true);
	        	     model.addElement(consulta.getListaDiscplina());
	        	     model.addElement(consulta.getListaAssunto());
	        	     lista.setModel(model);
	        	     txtPesquisa.setText("");
	        	       
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
	        		consulta.pegarDadosLista(linha);
	        		tblModel=(DefaultTableModel)table.getModel();
	        		tblModel.addRow(consulta.montandoTabela());
							
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
	        		int selectedRow = table.getSelectedRow();
	        		 link = table.getValueAt(selectedRow, 3).toString();
	        		 assunto=table.getValueAt(selectedRow, 1).toString();
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
	        	 consulta.caminhoPDF(link, assunto, progressBar);
	        		
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
}
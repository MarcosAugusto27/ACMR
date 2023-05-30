package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.RepositorioConexao;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField tfEmail;
	private JPasswordField pfSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 495);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(13, 20, 89));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel miniJanela3 = new JPanel();
		miniJanela3.setBackground(new Color(13, 20, 89));
		miniJanela3.setBounds(10, 11, 728, 434);
		contentPane.add(miniJanela3);
		miniJanela3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("                                          L O G I N");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(18, 143, 692, 25);
		miniJanela3.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(141, 207, 54, 25);
		miniJanela3.add(lblNewLabel_1);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(197, 207, 374, 25);
		miniJanela3.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(135, 256, 60, 25);
		miniJanela3.add(lblNewLabel_2);
		
		JButton btnEntrar1 = new JButton("Entrar ");
		btnEntrar1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEntrar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				try {
					Connection con= RepositorioConexao.conectaBD();
					String sql="select * from CadastroUsuarios where email=? and senha=?";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1,tfEmail.getText());
					stmt.setString(2,new String(pfSenha.getPassword()));
					ResultSet rs = stmt.executeQuery();
					
					if(rs.next()) {
					
						TelaCurso principal = new TelaCurso();
						principal.setVisible(true);
						
						setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null, "Email ou senha incorreto");
					}
					stmt.close();
					con.close(); 
					pfSenha.setText("");
					tfEmail.setText("");
				}catch (SQLException e1) {
					e1.printStackTrace();
				}
			
			}
		});
		btnEntrar1.setForeground(new Color(13, 20, 89));
		btnEntrar1.setBounds(518, 379, 89, 23);
		miniJanela3.add(btnEntrar1);
		
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaHomePrincipal inicio =new TelaHomePrincipal();
				inicio.setVisible(true);
				setVisible(false);
				
			}
		});
		btnVoltar.setForeground(new Color(13, 20, 89));
		btnVoltar.setBounds(162, 379, 89, 23);
		miniJanela3.add(btnVoltar);
		
		JButton btnEsqueceuSenha = new JButton("Esqueceu a senha?");
		btnEsqueceuSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEsqueceuSenha.setBackground(new Color(255, 255, 255));
		btnEsqueceuSenha.setForeground(new Color(13, 20, 89));
		btnEsqueceuSenha.setBounds(296, 326, 152, 23);
		miniJanela3.add(btnEsqueceuSenha);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(197, 259, 374, 25);
		miniJanela3.add(pfSenha);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TelaLogin.class.getResource("/views/imagens/logo_resized.png")));
		lblNewLabel_3.setBounds(259, 11, 209, 143);
		miniJanela3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ACMR");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(334, 108, 46, 14);
		miniJanela3.add(lblNewLabel_4);
	}
}

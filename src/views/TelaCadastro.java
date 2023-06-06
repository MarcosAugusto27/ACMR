package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import controller.ConsultasSql;
import controller.TrocarTelas;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;


public class TelaCadastro extends JFrame {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JTextField txtNomeCompleto;
		private JTextField tf_Email;
		private JPasswordField pf_Senha;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						TelaCadastro frame = new TelaCadastro();
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
		public TelaCadastro() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 764, 495);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(13, 20, 89));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel telacadastro = new JPanel();
			telacadastro.setBounds(10, 11, 728, 434);
			telacadastro.setBackground(new Color(13, 20, 89));
			contentPane.add(telacadastro);
			telacadastro.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("C A D A S T R O");
			lblNewLabel.setBounds(265, 118, 197, 26);
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
			telacadastro.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Preencha seus dados ");
			lblNewLabel_1.setForeground(new Color(255, 255, 255));
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
			lblNewLabel_1.setBounds(74, 176, 197, 26);
			telacadastro.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Nome Completo:");
			lblNewLabel_2.setForeground(new Color(255, 255, 255));
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
			lblNewLabel_2.setBounds(74, 228, 140, 26);
			telacadastro.add(lblNewLabel_2);
			
			txtNomeCompleto = new JTextField();
			txtNomeCompleto.setBounds(214, 228, 347, 26);
			telacadastro.add(txtNomeCompleto);
			txtNomeCompleto.setColumns(10);
			
			JLabel lblNewLabel_2_1 = new JLabel("Email:");
			lblNewLabel_2_1.setForeground(Color.WHITE);
			lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
			lblNewLabel_2_1.setBounds(162, 272, 52, 26);
			telacadastro.add(lblNewLabel_2_1);
			
			tf_Email = new JTextField();
			tf_Email.setColumns(10);
			tf_Email.setBounds(214, 272, 347, 26);
			telacadastro.add(tf_Email);
			
			JLabel lblNewLabel_2_1_1 = new JLabel("Senha:");
			lblNewLabel_2_1_1.setForeground(Color.WHITE);
			lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
			lblNewLabel_2_1_1.setBounds(154, 324, 60, 26);
			telacadastro.add(lblNewLabel_2_1_1);
			
			pf_Senha = new JPasswordField();
			pf_Senha.setBounds(214, 323, 347, 27);
			telacadastro.add(pf_Senha);
			
			JButton btnNewButton = new JButton("Cancelar ");
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnNewButton.setBackground(new Color(255, 255, 255));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TrocarTelas trocar = new TrocarTelas();
					trocar.telaHome();
					setVisible(false);
				}
			});
			btnNewButton.setForeground(new Color(13, 20, 89));
			btnNewButton.setBounds(125, 385, 105, 23);
			telacadastro.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Finalizar Cadastro");
			btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnNewButton_1.setBackground(new Color(255, 255, 255));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ConsultasSql consulta = new ConsultasSql();
					consulta.inserirDados(txtNomeCompleto, tf_Email, pf_Senha);
					setVisible(false);
					pf_Senha.setText("");
					tf_Email.setText("");
					txtNomeCompleto.setText("");
				
				}
				
			});
			btnNewButton_1.setForeground(new Color(13, 20, 89));
			btnNewButton_1.setBounds(470, 385, 149, 23);
			telacadastro.add(btnNewButton_1);
			
			JLabel lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setIcon(new ImageIcon(TelaCadastro.class.getResource("/views/imagens/logo_resized.png")));
			lblNewLabel_3.setBounds(258, 0, 212, 126);
			telacadastro.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("ACMR");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_4.setForeground(new Color(255, 255, 255));
			lblNewLabel_4.setBounds(336, 93, 39, 14);
			telacadastro.add(lblNewLabel_4);
			
			
			
			
		}
	}

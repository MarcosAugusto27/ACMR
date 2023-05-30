package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;

public class TelaHomePrincipal extends JFrame {

	private JPanel contentPane1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaHomePrincipal frame = new TelaHomePrincipal();
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
	public TelaHomePrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 495);
		contentPane1 = new JPanel();
		contentPane1.setBackground(new Color(13, 20, 89));
		contentPane1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));

		setContentPane(contentPane1);
		
		JPanel miniJanela = new JPanel();
		miniJanela.setBorder(null);
		miniJanela.setForeground(new Color(255, 255, 255));
		miniJanela.setBackground(new Color(13, 20, 89));
		
		JLabel lbTitulo = new JLabel("BEM-VINDOS AO GRUPO ACMR ");
		lbTitulo.setBounds(184, 142, 353, 33);
		lbTitulo.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitulo.setForeground(new Color(255, 255, 255));
		
		JButton btnNewButton = new JButton("Cadastro ");
		btnNewButton.setBounds(10, 384, 237, 37);
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	        TelaCadastro cadastro = new TelaCadastro();
	        cadastro.setVisible(true);
	        setVisible(false);

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		
		JTextPane txtpnOOrganizadorDe = new JTextPane();
		txtpnOOrganizadorDe.setBounds(207, 186, 453, 103);
		txtpnOOrganizadorDe.setForeground(new Color(255, 255, 255));
		txtpnOOrganizadorDe.setBackground(new Color(13, 20, 89));
		txtpnOOrganizadorDe.setEditable(false);
		txtpnOOrganizadorDe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnOOrganizadorDe.setText("O organizador de estudo foi criado por alunos e professores do curso de Desenvolvimento de Sistemas.\n\n0 nosso objetivo é proporcionar um ambiente de aprendizagem e organização dos materiais dos cursos.");
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(666, 311, 1, 1);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(413, 384, 237, 37);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin login =new TelaLogin();
				login.setVisible(true);
				setVisible(false);
			}
		});
		btnEntrar.setForeground(new Color(0, 0, 0));
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEntrar.setBackground(new Color(255, 255, 255));
		
		JLabel lbImagem = new JLabel("");
		lbImagem.setBounds(25, 151, 178, 167);
		lbImagem.setIcon(new ImageIcon(TelaHomePrincipal.class.getResource("/views/imagens/rounded-in-photoretrica.png")));
		GroupLayout gl_contentPane1 = new GroupLayout(contentPane1);
		gl_contentPane1.setHorizontalGroup(
			gl_contentPane1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane1.createSequentialGroup()
					.addGap(14)
					.addComponent(miniJanela, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(8))
		);
		gl_contentPane1.setVerticalGroup(
			gl_contentPane1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane1.createSequentialGroup()
					.addGap(11)
					.addComponent(miniJanela, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(11))
		);
		miniJanela.setLayout(null);
		miniJanela.add(lbTitulo);
		miniJanela.add(btnNewButton);
		miniJanela.add(btnEntrar);
		miniJanela.add(lbImagem);
		miniJanela.add(txtpnOOrganizadorDe);
		miniJanela.add(layeredPane);
		
		JLabel lbLogo = new JLabel("");
		lbLogo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbLogo.setIcon(new ImageIcon(TelaHomePrincipal.class.getResource("/views/imagens/logo_resized.png")));
		lbLogo.setBounds(261, 11, 200, 120);
		miniJanela.add(lbLogo);
		
		JLabel lblNewLabel_2 = new JLabel("ACMR");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(338, 105, 46, 14);
		miniJanela.add(lblNewLabel_2);
		contentPane1.setLayout(gl_contentPane1);
	}
}

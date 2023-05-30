package views;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaCurso extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCurso frame = new TelaCurso();
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
	public TelaCurso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 495);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(13, 20, 89));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel miniJanela4 = new JPanel();
		miniJanela4.setBackground(new Color(13, 20, 89));
		
		JLabel lblCurso = new JLabel("Selecione o seu curso:");
		lblCurso.setBounds(68, 109, 198, 21);
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCurso.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel = new JLabel("Selecione o seu Modulo e Turma:");
		lblNewLabel.setBounds(68, 194, 281, 21);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		
		JButton btnEntrar1 = new JButton("Entrar");
		btnEntrar1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEntrar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInteraçao interaçao;
				interaçao = new TelaInteraçao();
				interaçao.setVisible(true);
				setVisible(false);
				
			}
		});
		btnEntrar1.setBounds(434, 352, 106, 33);
		
		JButton btnVoltar1 = new JButton("Voltar");
		btnVoltar1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVoltar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin login=new TelaLogin();
				login.setVisible(true);
				setVisible(false);
				
			}
		});
		btnVoltar1.setBounds(128, 352, 112, 33);
		
		JLabel lblNewLabel_1 = new JLabel("Estamos quase la...");
		lblNewLabel_1.setBounds(275, 41, 216, 36);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		
		JComboBox cb_Curso = new JComboBox();
		cb_Curso.setBounds(68, 141, 115, 25);
		cb_Curso.setToolTipText("Escolha o seu curso");
		cb_Curso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cb_Curso.setModel(new DefaultComboBoxModel(new String[] {"Curso", "Administração", "Desenvovilmento de Sistemas", "Enfermagem"}));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(miniJanela4, GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
					.addGap(5))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(miniJanela4, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
					.addGap(6))
		);
		
		JComboBox cb_Modulo = new JComboBox();
		cb_Modulo.setBounds(68, 226, 120, 25);
		cb_Modulo.setToolTipText("Escolha o seu modulo");
		cb_Modulo.setModel(new DefaultComboBoxModel(new String[] {"Modulo", "1°", "2°", "3°"}));
		cb_Modulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox cb_Turma = new JComboBox();
		cb_Turma.setBounds(68, 271, 120, 25);
		cb_Turma.setToolTipText("Escolha a sua turma");
		cb_Turma.setModel(new DefaultComboBoxModel(new String[] {"Turma", "A", "B"}));
		cb_Turma.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(480, 109, 200, 150);
		lblNewLabel_2.setIcon(new ImageIcon(TelaCurso.class.getResource("/views/imagens/logo_resized.png")));
		
		JLabel lblNewLabel_3 = new JLabel("ACMR");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(556, 213, 46, 14);
		miniJanela4.setLayout(null);
		miniJanela4.add(lblNewLabel_2);
		miniJanela4.add(lblNewLabel_3);
		miniJanela4.add(lblNewLabel_1);
		miniJanela4.add(cb_Modulo);
		miniJanela4.add(cb_Turma);
		miniJanela4.add(lblCurso);
		miniJanela4.add(lblNewLabel);
		miniJanela4.add(cb_Curso);
		miniJanela4.add(btnVoltar1);
		miniJanela4.add(btnEntrar1);
		
		JLabel lblNewLabel_4 = new JLabel("TECNOLOGIA NA EDUCAÇÃO");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(480, 226, 200, 25);
		miniJanela4.add(lblNewLabel_4);
		contentPane.setLayout(gl_contentPane);
	}
}

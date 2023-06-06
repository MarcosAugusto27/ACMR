package views;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

public class TelaEsqueciSenha extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEsqueciSenha frame = new TelaEsqueciSenha();
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
	public TelaEsqueciSenha() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 495);
		JPanel contentPane1 = new JPanel();
		contentPane1.setBackground(new Color(13, 20, 89));
		contentPane1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));

		setContentPane(contentPane1);
		contentPane1.setLayout(null);
		
		JPanel miniJanela = new JPanel();
		miniJanela.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		miniJanela.setForeground(new Color(255, 255, 255));
		miniJanela.setBackground(new Color(0, 0, 204));
		
	}
}

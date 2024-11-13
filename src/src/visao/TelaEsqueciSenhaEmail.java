package visao;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;

public class TelaEsqueciSenhaEmail extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEsqueciSenhaEmail frame = new TelaEsqueciSenhaEmail();
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
	public TelaEsqueciSenhaEmail() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 695);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane = new ImagePanel("src/img/bgSenha.png");
		setContentPane(contentPane);

		contentPane.setLayout(new MigLayout("", "[300px,grow][grow][grow]", "[100px][100px][100px][][][][][][][][][][][][][][50px][][][]"));
		
		JLabel lblNewLabel = new JLabel("Esqueceu sua Senha?");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		contentPane.add(lblNewLabel, "cell 1 5 2 1");

		JLabel lblNewLabel_2 = new JLabel("<html>Verifique sua senha no e-mail informado e"
		+ " <br>toque em \"Login\" para se conectar.</html>");
		lblNewLabel_2.setBackground(new Color(153, 162, 209));
		lblNewLabel_2.setOpaque(true);  // Torna o fundo do JLabel visível
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lblNewLabel_2, "cell 1 9 2 1");
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setPreferredSize(new Dimension(200, 200)); 
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(32, 60, 115));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(btnNewButton, "cell 1 16,growy");
		

		btnNewButton.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
		 dispose();
		 TelaLogin telaLogin = new TelaLogin();
		 telaLogin.setVisible(true);
		 }
		});

	}

}

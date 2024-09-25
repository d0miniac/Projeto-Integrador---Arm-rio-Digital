package visao;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginView extends JFrame {

	private JPanel contentPane;
	public JTextField textUsuario;
	public JPasswordField textSenha;
	public JLabel lblStatus;
	public JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblUsuario = new JLabel("Usuario");

		textUsuario = new JTextField();
		textUsuario.setColumns(10);

		btnLogin = new JButton("Login");

		JLabel lblSenha = new JLabel("Senha:");

		textSenha = new JPasswordField();
		textSenha.setColumns(10);

		lblStatus = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(25)
						.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE).addGap(5)
						.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(25)
						.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE).addGap(5)
						.addComponent(textSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(138).addComponent(btnLogin,
						GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(25).addComponent(lblStatus,
						GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(6)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(lblUsuario))
								.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(40)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(lblSenha))
								.addComponent(textSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(78).addComponent(btnLogin).addGap(7)
						.addComponent(lblStatus, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)));
		contentPane.setLayout(gl_contentPane);
	}
}
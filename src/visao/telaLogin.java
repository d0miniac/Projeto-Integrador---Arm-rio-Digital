package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class telaLogin extends JFrame {
	private static final long serialVersionUID = 1L;
	private ImagePanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel backgroundLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaLogin frame = new telaLogin();
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
	public telaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1526, 1313);
		contentPane = new ImagePanel("src/img/background1.png");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		contentPane.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow 50][grow 50,fill][grow]", "[bottom][][][][][][][][][][][][::100px][::100px][][][][40px][][70px][][][][][][][][][70px][][][][][][][][][][][][][][][][][][][][][][::100px][::100px][]"));

		JLabel lblBemVindo = new JLabel("Bem vindo");
		lblBemVindo.setForeground(new Color(255, 255, 255));
		lblBemVindo.setFont(new Font("Tahoma", Font.BOLD, 50));
		contentPane.add(lblBemVindo, "cell 5 13,alignx left");
		
		JLabel lblNovamente = new JLabel("novamente!");
		lblNovamente.setForeground(new Color(255, 255, 255));
		lblNovamente.setFont(new Font("Tahoma", Font.BOLD, 50));
		contentPane.add(lblNovamente, "cell 5 14,alignx left");
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setForeground(new Color(255, 255, 255));
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblCpf, "cell 5 18,alignx left");
		textField_2 = new JTextField();
		contentPane.add(textField_2, "cell 5 19 2 1,grow");
		textField_2.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(new Color(255, 255, 255));
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblSenha, "cell 5 27,alignx left");
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		contentPane.add(textField_1, "cell 5 28 2 1,alignx right,grow");
		
		JCheckBox chckbxMostrarSenha = new JCheckBox("Mostrar senha");
		chckbxMostrarSenha.setForeground(new Color(255, 255, 255));
		chckbxMostrarSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxMostrarSenha.setBackground(new Color(32, 60, 115));
		contentPane.add(chckbxMostrarSenha, "cell 5 29,alignx left");
		
		JButton btnEsqueciSenha = new JButton("Esqueci a senha");
		btnEsqueciSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		btnEsqueciSenha.setForeground(new Color(255, 255, 255));
		btnEsqueciSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEsqueciSenha.setFocusPainted(false);
		btnEsqueciSenha.setBorderPainted(false);
		btnEsqueciSenha.setBackground(new Color(32, 60, 115));
		contentPane.add(btnEsqueciSenha, "cell 6 29,alignx right");
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLogin.setBackground(new Color(103, 203, 239));
		contentPane.add(btnLogin, "cell 5 51 2 1,alignx right,grow");
		JLabel lblNovaConta = new JLabel("Ainda não tem uma conta?");
		lblNovaConta.setForeground(new Color(255, 255, 255));
		lblNovaConta.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblNovaConta, "cell 5 52,alignx left");
		JButton btnCadastrese = new JButton("Cadastre-se");
		btnCadastrese.setHorizontalAlignment(SwingConstants.RIGHT);
		btnCadastrese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrese.setForeground(new Color(255, 255, 255));
		btnCadastrese.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnCadastrese.setFocusPainted(false);
		btnCadastrese.setBorderPainted(false);
		btnCadastrese.setBackground(new Color(32, 60, 115));
		contentPane.add(btnCadastrese, "cell 6 52,alignx right");

		setLocationRelativeTo(null); // Centraliza a janela na tela
	}
}

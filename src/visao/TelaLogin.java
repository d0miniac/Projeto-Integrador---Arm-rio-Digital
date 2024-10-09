package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.FuncionarioDAO;
import modelo.Funcionario;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSenha;
	private JTextField txtEmail;
	private JLabel backgroundLabel;

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
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1526, 1313);
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(1, 2));
		setContentPane(contentPane);
				
				
		ImagePanel panelDireito = new ImagePanel("src/img/background1D.png");
		ImagePanel panelEsquerdo= new ImagePanel("src/img/background1E.png");

		
		contentPane.add(panelEsquerdo);
		contentPane.add(panelDireito);
		
		
		panelDireito.setBorder(new EmptyBorder(5, 5, 5, 5));
        

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		panelDireito.setLayout(new MigLayout("", "[grow][grow 50][grow 50,fill][grow]", "[bottom][][][][][][][][][][][][::100px][::100px][][][][40px][][70px][][][][][][][][][70px][][][][][][][][][][][][][][][][][][][70px][]"));

		JLabel lblBemVindo = new JLabel("Bem vindo");
		lblBemVindo.setForeground(new Color(255, 255, 255));
		lblBemVindo.setFont(new Font("Tahoma", Font.BOLD, 50));
		panelDireito.add(lblBemVindo, "cell 1 13,alignx left");
		
		JLabel lblNovamente = new JLabel("novamente!");
		lblNovamente.setForeground(new Color(255, 255, 255));
		lblNovamente.setFont(new Font("Tahoma", Font.BOLD, 50));
		panelDireito.add(lblNovamente, "cell 1 14,alignx left");
		
		JLabel lblCpf = new JLabel("Email:");
		lblCpf.setForeground(new Color(255, 255, 255));
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelDireito.add(lblCpf, "cell 1 18,alignx left");
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panelDireito.add(txtEmail, "cell 1 19 2 1,grow");
		txtEmail.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(new Color(255, 255, 255));
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelDireito.add(lblSenha, "cell 1 27,alignx left");
		txtSenha = new JTextField();
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtSenha.setColumns(10);
		panelDireito.add(txtSenha, "cell 1 28 2 1,alignx right,grow");
		
		JCheckBox chckbxMostrarSenha = new JCheckBox("Mostrar senha");
		chckbxMostrarSenha.setForeground(new Color(255, 255, 255));
		chckbxMostrarSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxMostrarSenha.setBackground(new Color(32, 60, 115));
		panelDireito.add(chckbxMostrarSenha, "cell 1 29,alignx left");
		
		chckbxMostrarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxMostrarSenha.isSelected()) {
					txtSenha.setVisible(true);
				} else {
					txtSenha.setVisible(false);
				}
			}
		});
		
		JButton btnEsqueciSenha = new JButton("Esqueci a senha");
		btnEsqueciSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		btnEsqueciSenha.setForeground(new Color(255, 255, 255));
		btnEsqueciSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEsqueciSenha.setFocusPainted(false);
		btnEsqueciSenha.setBorderPainted(false);
		btnEsqueciSenha.setBackground(new Color(32, 60, 115));
		panelDireito.add(btnEsqueciSenha, "cell 2 29,alignx right");
		
		btnEsqueciSenha.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			 dispose();
			 TelaEsqueciSenha telaEsqueciSenha = new TelaEsqueciSenha();
			 telaEsqueciSenha.setVisible(true);
			 }
			});
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario login = new Funcionario();
				login.setEmail(txtEmail.getText());
				login.setSenha(txtSenha.getText());
				FuncionarioDAO dao = new FuncionarioDAO();
				Funcionario f = dao.logarFuncionario(login);
				if(f != null) {
					dispose();
				TelaMenu tela = new TelaMenu();
				tela.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Usuário Nulo");
				}
				
			}
		});
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnLogin.setBackground(new Color(103, 203, 239));
		panelDireito.add(btnLogin, "cell 1 47 2 1,alignx right,grow");
		JLabel lblNovaConta = new JLabel("Ainda não tem uma conta?");
		lblNovaConta.setForeground(new Color(255, 255, 255));
		lblNovaConta.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelDireito.add(lblNovaConta, "cell 1 48,alignx left");
		
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
		panelDireito.add(btnCadastrese, "cell 2 48,alignx right");


		btnCadastrese.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
		 dispose();
		 TelaCadastroFuncionario telaCadastro = new TelaCadastroFuncionario();
		 telaCadastro.setVisible(true);
		 }
		});

		setLocationRelativeTo(null); // Centraliza a janela na tela
	}
}

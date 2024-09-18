package visao;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Conta;
import net.miginfocom.swing.MigLayout;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CadastroContas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtSenha;
	private JTextField txtConfirma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroContas frame = new CadastroContas();
					frame.setVisible(true);
					frame.setSize(1215, 850);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroContas() {
		setResizable(false);
		setTitle("Cadastro de Contas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1018, 680);

		contentPane = new ImagePanel("src/img/background3.png");
		setContentPane(contentPane);

		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel PainelVazio = new JPanel();
		PainelVazio.setBackground(new Color(0, 0, 0, 0));
		contentPane.add(PainelVazio);

		JPanel PainelComponentes = new JPanel();
		PainelComponentes.setBackground(new Color(243, 244, 240));
		contentPane.add(PainelComponentes);
		PainelComponentes
				.setLayout(new MigLayout("", "[46px,grow]", "[40px][14px][][100px][][][][][][][][][][][][][]"));

		JLabel lblNewLabel = new JLabel("Crie uma nova conta!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 60));
		PainelComponentes.add(lblNewLabel, "cell 0 1,alignx left,aligny top");

		JLabel lblNewLabel_6 = new JLabel("Já tem uma conta?");
		PainelComponentes.add(lblNewLabel_6, "flowx,cell 0 2");

		JLabel lblNewLabel_1 = new JLabel("Nome Completo:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		PainelComponentes.add(lblNewLabel_1, "cell 0 4");

		txtNome = new JTextField(25);
		txtNome.setBackground(new Color(128, 128, 192));
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 25));
		PainelComponentes.add(txtNome, "cell 0 5,alignx left");
		txtNome.setColumns(25);

		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		PainelComponentes.add(lblNewLabel_2, "cell 0 6");

		txtCpf = new RoundJTextField(25);
		txtCpf.setBackground(new Color(65, 82, 179, 128));
		txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 25));
		PainelComponentes.add(txtCpf, "cell 0 7,alignx left");
		txtCpf.setColumns(25);

		JLabel lblNewLabel_3 = new JLabel("E-mail:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		PainelComponentes.add(lblNewLabel_3, "cell 0 8");

		txtEmail = new RoundJTextField(25);
		txtEmail.setBackground(new Color(65, 82, 179, 128));
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		PainelComponentes.add(txtEmail, "cell 0 9,alignx left");
		txtEmail.setColumns(25);

		JLabel lblNewLabel_4 = new JLabel("Senha:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		PainelComponentes.add(lblNewLabel_4, "cell 0 10");

		txtSenha = new RoundJTextField(25);
		txtSenha.setBackground(new Color(65, 82, 179, 128));
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 25));
		PainelComponentes.add(txtSenha, "cell 0 11,alignx left");
		txtSenha.setColumns(25);

		JLabel lblNewLabel_5 = new JLabel("Confirme a Senha:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		PainelComponentes.add(lblNewLabel_5, "cell 0 12");

		txtConfirma = new RoundJTextField(25);
		txtConfirma.setBackground(new Color(65, 82, 179, 128));
		txtConfirma.setFont(new Font("Tahoma", Font.PLAIN, 25));
		PainelComponentes.add(txtConfirma, "cell 0 13,alignx left");
		txtConfirma.setColumns(25);

		JButton btnCadastro = new JButton("Cadastrar");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conta novo = new Conta();
				novo.setNome(txtNome.getText());
				novo.setEmail(txtEmail.getText());
				try {
					novo.setCpf(Long.parseLong(txtCpf.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					TelaErro erro = new TelaErro();
					erro.setVisible(true);
					return;
				}

				if (txtSenha.getText().equals(txtConfirma.getText())) {
					novo.setSenha(txtConfirma.getText());
				} else {
					TelaErro erroTela = new TelaErro();
					erroTela.setVisible(true);

				}
				dispose();
				telaLogin tela = new telaLogin();
				tela.setVisible(true);
			}
		});
		btnCadastro.setForeground(new Color(243, 244, 240));
		btnCadastro.setBackground(new Color(65, 82, 179));
		btnCadastro.setFont(new Font("Tahoma", Font.PLAIN, 30));
		PainelComponentes.add(btnCadastro, "cell 0 15,alignx left");

		JLabel lblNewLabel_7 = new JLabel("Login");
		lblNewLabel_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override

			public void mouseClicked(MouseEvent e) {
				dispose();
				telaLogin tela = new telaLogin();
				tela.setVisible(true);
			}
		});
		PainelComponentes.add(lblNewLabel_7, "cell 0 2");

	}
}

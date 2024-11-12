package visao;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import modelo.Funcionario;
import controle.FornecedorDAO;
import controle.FuncionarioDAO;

import javax.swing.SwingConstants;

public class TelaEditarFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNome;
	private JTextField txtSenha;
	private JTextField txtEmail;
	private JTextField txtCpf;
	private Funcionario funcionario;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Funcionario funcionario = new Funcionario();
					TelaEditarFuncionario frame = new TelaEditarFuncionario(funcionario);
					frame.setVisible(true);
					frame.setSize(657, 425);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaEditarFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
		setSize(657, 425);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new ImagePanel("src/img/bgEditarFuncionarios.png");
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[70px][][grow][][100px][150px][150px][100px]"));

		// Cabeçalho com botão de voltar
		JPanel vazio = new JPanel();
		vazio.setOpaque(false);
		contentPane.add(vazio, "cell 0 0,alignx left,growy");

		JLabel lblVoltar = new JLabel("");
		lblVoltar.setHorizontalAlignment(SwingConstants.LEFT);
		lblVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ImageIcon seta = new ImageIcon(TelaEditarFornecedores.class.getResource("/img/de-volta.png"));
		Image voltar = seta.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		lblVoltar.setIcon(new ImageIcon(voltar));
		vazio.add(lblVoltar);
		lblVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaFornecedores tela = new TelaFornecedores();
				dispose();
				tela.setVisible(true);
			}
		});

		// Título da tela
		JLabel lblTitulo = new JLabel("Alteração das informações do funcionário");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setForeground(new Color(153, 162, 209));
		contentPane.add(lblTitulo, "cell 0 3");

		// Painel superior com campos de edição
		JPanel topo = new JPanel();
		topo.setBorder(new MatteBorder(0, 0, 5, 0, new Color(32, 60, 115, 124)));
		topo.setOpaque(false);
		contentPane.add(topo, "cell 0 5,grow");
		topo.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[][][]"));

		JLabel lblID = new JLabel("ID Funcionario");
		topo.add(lblID, "cell 0 2,alignx center");

		txtID = new JTextField(String.valueOf(funcionario.getId()));
		txtID.setEnabled(false);
		topo.add(txtID, "cell 1 2,alignx center");
		txtID.setColumns(10);

		JLabel lblNomeFornecedor = new JLabel("Nome");
		topo.add(lblNomeFornecedor, "cell 2 2,alignx center");

		txtNome = new JTextField(funcionario.getNome());
		topo.add(txtNome, "cell 3 2,alignx center");
		txtNome.setColumns(10);

		JPanel topo_1 = new JPanel();
		topo_1.setOpaque(false);
		topo_1.setBorder(new MatteBorder(0, 0, 5, 0, new Color(32, 60, 115, 124)));
		contentPane.add(topo_1, "cell 0 6,grow");
		topo_1.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow]", "[][]"));

		JLabel lblSenha = new JLabel("Senha");
		topo_1.add(lblSenha, "cell 0 1,alignx center");
		txtSenha = new JTextField(funcionario.getSenha());
		topo_1.add(txtSenha, "cell 1 1,alignx center");
		txtSenha.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail");
		topo_1.add(lblEmail, "flowx,cell 2 1,alignx center");

		txtEmail = new JTextField(funcionario.getEmail());
		topo_1.add(txtEmail, "cell 3 1,alignx center");
		txtEmail.setColumns(10);

		JLabel lblCpf = new JLabel("Cpf");
		topo_1.add(lblCpf, "flowx,cell 4 1,alignx center");

		txtCpf = new JTextField(funcionario.getCpf());
		topo_1.add(txtCpf, "cell 5 1,alignx center");
		txtCpf.setColumns(10);

		// Painel inferior com botão de alteração
		JPanel inferior = new JPanel();
		inferior.setOpaque(false);
		contentPane.add(inferior, "cell 0 7,grow");
		inferior.setLayout(new MigLayout("", "[100px][100px][grow][grow][]", "[][][][][][][]"));

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAlterar.setBackground(new Color(32, 60, 115));
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				funcionario.setNome(txtNome.getText());
				funcionario.setEmail(txtEmail.getText());
				funcionario.setSenha(txtSenha.getText());
				funcionario.setCpf(txtCpf.getText());
				FuncionarioDAO dao = new FuncionarioDAO();
				try {
					dao.alterarFuncionario(funcionario);
					JOptionPane.showMessageDialog(null, "Funcionario alterado com sucesso!");
					TelaFuncionarios tela = new TelaFuncionarios();
					dispose();
					tela.setVisible(true);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro ao alterar funcionario: " + ex.getMessage(), "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		inferior.add(btnAlterar, "cell 0 4,growx");

		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
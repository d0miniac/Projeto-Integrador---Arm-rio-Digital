package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;

import net.miginfocom.swing.MigLayout;
import javax.swing.border.TitledBorder;

import modelo.Funcionario;

public class TelaMenu extends JFrame {
	public JButton btnFuncionarios;
	
	public static void main(String[] args) {
	    EventQueue.invokeLater(() -> {
	        try {
	            Funcionario funcionario = new Funcionario(); 
	            String mensagem = "Bem-vindo ao sistema!";
	            TelaMenu frame = new TelaMenu(funcionario, mensagem);
	            frame.setVisible(true);
	            frame.setSize(657, 425);
	            frame.setLocationRelativeTo(null);
	        } catch (Exception e) {

	            TelaErro telaErro = new TelaErro("Erro crítico: " + e.getMessage());
	            telaErro.setVisible(true);
	        }
	    });
	}

	public TelaMenu(Funcionario func, String mensagem) {

		setTitle("MENU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1215, 850);
		setLocationRelativeTo(null);
		setResizable(false);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(new Color(230, 230, 230));

		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(33, 64, 154));
		topPanel.setPreferredSize(new Dimension(600, 100));
		topPanel.setLayout(new MigLayout("", "[87px][][160px]", "[][][][][][][]"));

		JLabel lblIconeUser = new JLabel("");
		lblIconeUser.setIcon(new ImageIcon(TelaMenu.class.getResource("/img/user.png")));
		topPanel.add(lblIconeUser, "cell 0 0 1 5,alignx left,aligny top");

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		buttonPanel.setBackground(new Color(230, 230, 230));

		buttonPanel.setLayout(
				new MigLayout("", "[][173px][173px][173px][173px][173px][173px]", "[100px,grow][100px,grow]"));

		JButton btnProdutos = new ImageButton("src/img/icone_produtos.png");
		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaProdutos telaProdutos;
				telaProdutos = new TelaProdutos(func, mensagem);
				telaProdutos.setVisible(true);
				telaProdutos.setSize(1215, 850);
				telaProdutos.setLocationRelativeTo(null);

			}
		});

		JButton btnFornecedores = new ImageButton("src/img/icone_fornecedores.png");
		btnFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaFornecedores telaFornecedores = new TelaFornecedores(func, mensagem);
				telaFornecedores.setVisible(true);
			}
		});

		btnFuncionarios = new ImageButton("src/img/icone_funcionarios.png");
		if (!func.getPerfil().equals("Admin")) {
			btnFuncionarios.setEnabled(false);
		}
		btnFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				TelaFuncionarios telaFuncionarios = null;
				try {
					telaFuncionarios = new TelaFuncionarios(func, mensagem);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				telaFuncionarios.setVisible(true);

			}
		});
		JButton btnHistorico = new ImageButton("src/img/icone_historico.png");
		btnHistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaHistoricoVendas telaHistoricoVendas = new TelaHistoricoVendas(func, mensagem);
				telaHistoricoVendas.setVisible(true);
			}
		});

		JButton btnVendas = new ImageButton("src/img/icone_vendas.png");
		btnVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaVendas telaVendas = new TelaVendas(func, mensagem);
				telaVendas.setVisible(true);
			}
		});

		buttonPanel.add(btnFornecedores, "cell 3 0 2 1,grow");
		buttonPanel.add(btnHistorico, "cell 5 0 2 1,grow");
		buttonPanel.add(btnFuncionarios, "cell 2 1 2 1,grow");
		buttonPanel.add(btnProdutos, "cell 1 0 2 1,grow");
		buttonPanel.add(btnVendas, "cell 4 1 2 1,grow");

		mainPanel.add(topPanel, BorderLayout.NORTH);

		JLabel msg1 = new JLabel("Bem vindo!", SwingConstants.CENTER);
		msg1.setForeground(Color.WHITE);
		msg1.setFont(new Font("Arial", Font.BOLD, 30));
		msg1.setBorder(null);

		topPanel.add(msg1, "cell 1 1");

		JLabel lblNewLabel_1 = new JLabel(func.getNome());
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(Color.WHITE);
		topPanel.add(lblNewLabel_1, "cell 1 2,alignx left");
		mainPanel.add(buttonPanel, BorderLayout.CENTER);

		getContentPane().add(mainPanel);

		setVisible(true);
	}

}

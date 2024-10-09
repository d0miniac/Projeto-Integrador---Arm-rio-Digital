package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import net.miginfocom.swing.MigLayout;
import javax.swing.border.TitledBorder;

public class TelaMenu extends JFrame {

	public TelaMenu() {
		// janela principal
		setTitle("MENU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);

		// Painel principal
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(new Color(230, 230, 230));

		// Painel superior
		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(33, 64, 154));
		topPanel.setPreferredSize(new Dimension(600, 100));
		topPanel.setLayout(new MigLayout("", "[87px][][160px][][][][][]", "[][][][][][][]"));

		JLabel lblIconeUser = new JLabel("");
		lblIconeUser.setIcon(new ImageIcon(TelaMenu.class.getResource("/img/user.png")));
		topPanel.add(lblIconeUser, "cell 0 0 1 5,alignx left,aligny top");

		// Painel de botões
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		buttonPanel.setBackground(new Color(230, 230, 230));
		
		

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				btnProdutos.repaint();
				btnFornecedores.repaint();
				btnHistorico.repaint();
				btnFuncionarios.repaint();
				btnVendas.repaint();

			}
		});
		buttonPanel.setLayout(new MigLayout("", "[grow 50][grow 50][grow 50][grow 50][grow 50][grow 50]", "[100px,grow][100px,grow]"));
		JButton btnHistorico = new ImageButton("src/img/icone_historico.png");
		btnHistorico.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			 dispose();
			 TelaHistoricoVendas telaHistoricoVendas = new TelaHistoricoVendas();
			 telaHistoricoVendas.setVisible(true);
			 }
			});
		
				// Criando os botões
				JButton btnProdutos = new ImageButton("src/img/icone_produtos.png");
				btnProdutos.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent e) {
					 dispose();
					 TelaProdutos telaProdutos = new TelaProdutos();
					 telaProdutos.setVisible(true);
					 }
					});
				// Adiciona os botões ao painel
				buttonPanel.add(btnProdutos, "cell 0 0 2 1,grow");
		JButton btnFornecedores = new ImageButton("src/img/icone_fornecedores.png");
		btnFornecedores.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			 dispose();
			 TelaFornecedores telaFornecedores = new TelaFornecedores();
			 telaFornecedores.setVisible(true);
			 }
			});
		buttonPanel.add(btnFornecedores, "cell 2 0 2 1,grow");
		buttonPanel.add(btnHistorico, "cell 4 0 2 1,grow");

		// Adiciona os painéis ao painel principal
		mainPanel.add(topPanel, BorderLayout.NORTH);

		JLabel msg1 = new JLabel("Bem vindo!", SwingConstants.CENTER);
		msg1.setForeground(Color.WHITE);
		msg1.setFont(new Font("Arial", Font.BOLD, 30));
		msg1.setBorder(null);

		topPanel.add(msg1, "cell 1 1");
		
				JLabel lblNewLabel_1 = new JLabel("Nome de Usuário");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblNewLabel_1.setForeground(Color.WHITE);
				topPanel.add(lblNewLabel_1, "cell 1 2,alignx left");
		mainPanel.add(buttonPanel, BorderLayout.CENTER);
		JButton btnFuncionarios = new ImageButton("src/img/icone_funcionarios.png");
		btnFuncionarios.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			 dispose();
			 TelaFuncionarios telaFuncionarios= new TelaFuncionarios();
			 telaFuncionarios.setVisible(true);
			 }
			});
		JButton btnVendas = new ImageButton("src/img/icone_vendas.png");
		btnVendas.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			 dispose();
			 TelaVendas telaVendas= new TelaVendas();
			 telaVendas.setVisible(true);
			 }
			});
		buttonPanel.add(btnVendas, "cell 1 1 2 1,grow");
		buttonPanel.add(btnFuncionarios, "cell 3 1 2 1,grow");

		getContentPane().add(mainPanel);

		// Mostra janela
		setVisible(true);
	}

	// Método para criar um botão com imagem
	private JButton criarBotao(String texto, String caminhoIcone) {
		JButton button = new JButton(texto);
		button.setBackground(new Color(255, 255, 255));
		button.setForeground(new Color(0, 0, 128));
		button.setFont(new Font("Arial", Font.PLAIN, 16));
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setHorizontalTextPosition(SwingConstants.CENTER);

		// Adiciona imagem ao botão
		ImageIcon icon = new ImageIcon(caminhoIcone);

		// Carrega a imagem e redimensiona
		ImageIcon icon1 = new ImageIcon(caminhoIcone);
		Image img = icon1.getImage();
		Image scaledImg = img.getScaledInstance(200, 120, Image.SCALE_SMOOTH); // Redimensiona a imagem
		button.setIcon(new ImageIcon(scaledImg));

		return button;
	}

	public static void main(String[] args) {
		// Executa a tela de menu
		new TelaMenu();
	}

}

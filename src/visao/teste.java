package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class teste extends JFrame {

	public teste() {
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
		topPanel.setLayout(new BorderLayout());

		JLabel msg1 = new JLabel("Bem vindo!", JLabel.LEFT);
		msg1.setForeground(Color.WHITE);
		msg1.setFont(new Font("Arial", Font.BOLD, 24));
		msg1.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));

		JLabel nomeUser = new JLabel("Nome do Usuário", JLabel.LEFT);
		nomeUser.setForeground(Color.WHITE);
		nomeUser.setFont(new Font("Arial", Font.PLAIN, 18));
		nomeUser.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 10));

		topPanel.add(msg1, BorderLayout.NORTH);
		topPanel.add(nomeUser, BorderLayout.CENTER);

		// Painel de botões
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2, 3, 20, 20));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		buttonPanel.setBackground(new Color(230, 230, 230));

		// Criando os botões
		JButton btnProdutos = criarBotao("Produtos", "src/img/icone_produtos.png");
		JButton btnFornecedores = criarBotao("Fornecedores", "src/img/icone_fornecedores.png");
		JButton btnHistorico = criarBotao("Histórico de vendas", "src/img/icone_historico.png");
		JButton btnFuncionarios = criarBotao("Funcionários", "src/img/icone_funcionarios.png");
		JButton btnVendas = criarBotao("Vendas", "src/img/icone_vendas.png");

		// Adiciona os botões ao painel
		buttonPanel.add(btnProdutos);
		buttonPanel.add(btnFornecedores);
		buttonPanel.add(btnHistorico);
		buttonPanel.add(btnFuncionarios);
		buttonPanel.add(btnVendas);

		// Adiciona os painéis ao painel principal
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(buttonPanel, BorderLayout.CENTER);

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
		button.setIcon(icon);

		// Carrega a imagem e redimensiona
		ImageIcon icon1 = new ImageIcon(caminhoIcone);
		Image img = icon1.getImage();
		Image scaledImg = img.getScaledInstance(200, 120, Image.SCALE_SMOOTH); // Redimensiona a imagem
		button.setIcon(new ImageIcon(scaledImg));

		return button;
	}

	public static void main(String[] args) {
		// Executa a tela de menu
		new teste();
	}
}

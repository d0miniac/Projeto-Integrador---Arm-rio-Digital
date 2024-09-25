package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class teste extends JFrame {

	public teste() {
		// Configurações da janela principal
		setTitle("Tela de Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);

		// Painel principal
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(new Color(230, 230, 230));

		// Painel superior (bem-vindo)
		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(33, 64, 154));
		topPanel.setPreferredSize(new Dimension(600, 100));
		topPanel.setLayout(new BorderLayout());

		// Label de bem-vindo
		JLabel welcomeLabel = new JLabel("Bem vindo!", JLabel.LEFT);
		welcomeLabel.setForeground(Color.WHITE);
		welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
		welcomeLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));

		// Label de nome do usuário
		JLabel userNameLabel = new JLabel("Nome do Usuário", JLabel.LEFT);
		userNameLabel.setForeground(Color.WHITE);
		userNameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		userNameLabel.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 10));

		// Adiciona os labels ao painel superior
		topPanel.add(welcomeLabel, BorderLayout.NORTH);
		topPanel.add(userNameLabel, BorderLayout.CENTER);

		// Painel de botões (grid)
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

		// Adiciona o painel principal ao JFrame
		add(mainPanel);

		// Torna a janela visível
		setVisible(true);
	}

	// Método auxiliar para criar um botão com ícone
	private JButton criarBotao(String texto, String caminhoIcone) {
		JButton button = new JButton(texto);
		button.setFont(new Font("Arial", Font.PLAIN, 16));
		button.setFocusPainted(false);
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setHorizontalTextPosition(SwingConstants.CENTER);

		// Adiciona o ícone ao botão (se o ícone existir)
		ImageIcon icon = new ImageIcon(caminhoIcone);
		button.setIcon(icon);

		// Carrega a imagem e redimensiona, se necessário
		ImageIcon icon1 = new ImageIcon(caminhoIcone);
		Image img = icon1.getImage();
		Image scaledImg = img.getScaledInstance(60, 60, Image.SCALE_SMOOTH); // Redimensiona a imagem para 500x200
		button.setIcon(new ImageIcon(scaledImg));

		return button;
	}

	public static void main(String[] args) {
		// Executa a tela de menu
		new teste();
	}
}

package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.TitledBorder;

public class Teste extends JFrame {

	public Teste() {
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
		topPanel.setLayout(new MigLayout("", "[87px][][160px][][][][][][][][grow]", "[][80][][][][][][][]"));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Teste.class.getResource("/img/user.png")));
		topPanel.add(lblNewLabel, "cell 0 0 1 7,alignx left,aligny top");

		// Painel de botões
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2, 3, 20, 20));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		buttonPanel.setBackground(new Color(230, 230, 230));

		// Criando os botões
		
		JButton btnProdutos = criarBotao("", "src/img/icone_produtos.png");
		btnProdutos.setPreferredSize(new Dimension(100, 100));
		btnProdutos.setBorderPainted(false);// remove a borda do botao
		btnProdutos.setContentAreaFilled(false);// remove o fundo
		btnProdutos.setFocusPainted(false);// remove o foco
		JButton btnFornecedores = criarBotao("", "src/img/icone_fornecedores.png");
		btnFornecedores.setPreferredSize(new Dimension(100, 100));
		btnFornecedores.setBorderPainted(false);// remove a borda do botao
		btnFornecedores.setContentAreaFilled(false);// remove o fundo
		btnFornecedores.setFocusPainted(false);// remove o foco
		JButton btnHistorico = criarBotao("", "src/img/icone_historico.png");
		btnHistorico.setBorderPainted(false);// remove a borda do botao
		btnHistorico.setContentAreaFilled(false);// remove o fundo
		btnHistorico.setFocusPainted(false);// remove o foco
		JButton btnFuncionarios = criarBotao("", "src/img/icone_funcionarios.png");
		btnFuncionarios.setBorderPainted(false);// remove a borda do botao
		btnFuncionarios.setContentAreaFilled(false);// remove o fundo
		btnFuncionarios.setFocusPainted(false);// remove o foco
		JButton btnVendas = criarBotao("", "src/img/icone_vendas.png");
		btnVendas.setBorderPainted(false);// remove a borda do botao
		btnVendas.setContentAreaFilled(false);// remove o fundo
		btnVendas.setFocusPainted(false);// remove o foco
		
		

		// Adiciona os botões ao painel
		buttonPanel.add(btnProdutos);
		buttonPanel.add(btnFornecedores);
		buttonPanel.add(btnHistorico);
		buttonPanel.add(btnFuncionarios);
		buttonPanel.add(btnVendas);

		// Adiciona os painéis ao painel principal
		mainPanel.add(topPanel, BorderLayout.NORTH);

		JLabel msg1 = new JLabel("Bem vindo!", SwingConstants.CENTER);
		msg1.setForeground(Color.WHITE);
		msg1.setFont(new Font("Arial", Font.BOLD, 24));
		msg1.setBorder(null);

		topPanel.add(msg1, "cell 1 1,aligny bottom");

		JButton btnTresPontos = new JButton("");
		btnTresPontos.setForeground(new Color(0, 0, 160));
		topPanel.add(btnTresPontos, "cell 10 1 1 2,alignx right");
		btnTresPontos.setIcon(new ImageIcon(Teste.class.getResource("/img/tresPontos.png")));
		btnTresPontos.setBorderPainted(false);// remove a borda do botao
		btnTresPontos.setContentAreaFilled(false);// remove o fundo
		btnTresPontos.setFocusPainted(false);// remove o foco

		JLabel lblNewLabel_1 = new JLabel("Nome de Usuário");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(Color.WHITE);
		topPanel.add(lblNewLabel_1, "cell 1 2,alignx left,aligny top");
		mainPanel.add(buttonPanel, BorderLayout.CENTER);

		getContentPane().add(mainPanel);

		// Mostra janela
		setVisible(true);
	}

	// Método para criar um botão com imagem
	private JButton criarBotao(String texto, String caminhoIcone) {
		JButton button = new JButton(texto);
		button.setBackground(new Color(230, 230, 230));
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
		new Teste();
	}
}

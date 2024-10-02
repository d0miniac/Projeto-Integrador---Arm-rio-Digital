package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.EmptyBorder;

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
		topPanel.setLayout(new MigLayout("", "[80px,left][70px][100px][160px][][][][][][][][grow]", "[][80,grow][][][][][][][]"));

		// Painel de botões
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		buttonPanel.setBackground(new Color(230, 230, 230));
		buttonPanel.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow]"));

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
		buttonPanel.add(btnProdutos, "cell 0 0,grow");
		buttonPanel.add(btnFornecedores, "cell 1 0,grow");
		buttonPanel.add(btnHistorico, "cell 2 0,grow");
		buttonPanel.add(btnFuncionarios, "cell 0 1,grow");
		buttonPanel.add(btnVendas, "cell 1 1,grow");

		// Adiciona os painéis ao painel principal
		mainPanel.add(topPanel, BorderLayout.NORTH);
		
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon(TelaMenu.class.getResource("/img/user.png")));
				topPanel.add(lblNewLabel, "cell 0 1,alignx right,aligny top");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(33, 64, 154));
		topPanel.add(panel, "cell 1 1,grow");
		panel.setLayout(new MigLayout("", "[195px]", "[31px][]"));
		
		JLabel lblNewLabel_1 = new JLabel("BEM VINDO(A)!");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(lblNewLabel_1, "cell 0 0,alignx left,aligny top");
		
		JLabel lblNewLabel_2 = new JLabel("Nome de Usuário");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_2, "cell 0 1");

		JButton btnTresPontos = new JButton("");
		btnTresPontos.setForeground(new Color(0, 0, 160));
		topPanel.add(btnTresPontos, "cell 11 1 1 2,alignx right");
		btnTresPontos.setIcon(new ImageIcon(TelaMenu.class.getResource("/img/tresPontos.png")));
		btnTresPontos.setBorderPainted(false);// remove a borda do botao
		btnTresPontos.setContentAreaFilled(false);// remove o fundo
		btnTresPontos.setFocusPainted(false);
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
		new TelaMenu();
	}
}

package visao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import net.miginfocom.swing.MigLayout;
import controle.ProdutoDAO;
import modelo.Produto;

import java.util.ArrayList;

public class TelaVendas extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane_1;
	private ArrayList<Produto> listaProdutos;
	private ProdutoDAO produtoDAO;

	public TelaVendas() {
		produtoDAO = new ProdutoDAO();
		listaProdutos = produtoDAO.selecionarProdutos(); 

		setTitle("Catálogo de Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1215, 850);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel(new BorderLayout());
		contentPane_1 = new ImagePanel("src/img/bgVendas.png");
		contentPane_1.setBackground(new Color(243, 244, 240));
		setContentPane(contentPane_1);

		JPanel panelVazio = new JPanel();
		panelVazio.setBackground(new Color(0, 0, 0));
		panelVazio.setOpaque(false);
		contentPane_1.add(panelVazio, "cell 0 0,grow");
		panelVazio.setLayout(null);

		JLabel lblSeta = new JLabel((String) null);
		lblSeta.setHorizontalAlignment(SwingConstants.LEFT);
		lblSeta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSeta.setIcon(new ImageIcon(TelaCadastroProdutos.class.getResource("/img/de-volta.png")));
		lblSeta.setBounds(0, 0, 110, 100);
		panelVazio.add(lblSeta);
		lblSeta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaMenu tela = new TelaMenu();
				dispose();
				tela.setVisible(true);
				
				
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(123, 150, 212), 2, true));
		contentPane_1.add(scrollPane, BorderLayout.SOUTH);
		
				JPanel panelProdutos = new JPanel();
				contentPane_1.add(panelProdutos);
				panelProdutos.setBackground(new Color(243, 244, 240));
				panelProdutos.setLayout(new MigLayout("", "[grow, fill]", "[]"));

		for (Produto produto : listaProdutos) {
			JButton btnProduto = new JButton();
			btnProduto.setPreferredSize(new Dimension(200, 250));
			btnProduto.setLayout(new BorderLayout());

			ImageIcon imageIcon = new ImageIcon(produto.getFoto());
			Image image = imageIcon.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
			JLabel lblImage = new JLabel(new ImageIcon(image));
			btnProduto.add(lblImage, BorderLayout.CENTER);

			JLabel lblNome = new JLabel(produto.getFoto(), SwingConstants.CENTER);
			lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnProduto.add(lblNome, BorderLayout.SOUTH);

			btnProduto.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					TelaDetalhesProduto telaDetalhes = new TelaDetalhesProduto(produto); 
					telaDetalhes.setVisible(true); 
				}
			});

			panelProdutos.add(btnProduto);
			btnProduto.setBackground(new Color(243, 244, 240));
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				TelaVendas frame = new TelaVendas();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}

class TelaDetalhesProduto extends JFrame {

	public TelaDetalhesProduto(Produto produto) {
		setTitle("Detalhes do Produto");
		setSize(400, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());

		ImageIcon imageIcon = new ImageIcon(produto.getFoto());
		Image image = imageIcon.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
		JLabel lblImage = new JLabel(new ImageIcon(image));
		add(lblImage, BorderLayout.NORTH);

		JPanel panelInfo = new JPanel(new GridLayout(0, 1));
		JLabel lblNome = new JLabel("Nome: " + produto.getFoto()); 
		JLabel lblPreco = new JLabel("Preço: R$" + produto.getPreco());

		lblNome.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPreco.setFont(new Font("Tahoma", Font.BOLD, 16));

		panelInfo.add(lblNome);
		panelInfo.add(lblPreco);
		add(panelInfo, BorderLayout.CENTER);


		JPanel panelBotao = new JPanel();
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); 
			}
		});
		panelBotao.add(btnVoltar);
		add(panelBotao, BorderLayout.SOUTH);

		setVisible(true);
	}
}

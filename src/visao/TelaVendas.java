package visao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import controle.ProdutoDAO;
import modelo.Funcionario;
import modelo.Produto;
import net.miginfocom.swing.MigLayout;

import java.util.ArrayList;

public class TelaVendas extends JFrame {

	private JPanel contentPane_1;
	private JPanel panelVazio;
	private ArrayList<Produto> listaProdutos;
	private ProdutoDAO produtoDAO;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				Funcionario funcionario = new Funcionario();
				String mensagem = "Bem-vindo ao sistema!";
				TelaVendas frame = new TelaVendas(funcionario, mensagem);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public TelaVendas(Funcionario func, String mensagem) {
		produtoDAO = new ProdutoDAO();
		listaProdutos = produtoDAO.selecionarProdutos();

		setTitle("Catálogo de Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1215, 850);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane_1 = new ImagePanel("src/img/bgVendas.png");
		contentPane_1.setBackground(new Color(243, 244, 240));
		setContentPane(contentPane_1);

		contentPane_1.setLayout(new BoxLayout(contentPane_1, BoxLayout.Y_AXIS));

		panelVazio = new JPanel();
		panelVazio.setLayout(null);
		panelVazio.setOpaque(false);
		panelVazio.setBackground(Color.BLACK);

		Dimension dimVazio = new Dimension(getWidth(), (int) (getHeight() * 0.20));
		panelVazio.setPreferredSize(dimVazio);

		contentPane_1.add(panelVazio);

		JPanel panelProdutosComScroll = new JPanel();
		panelProdutosComScroll.setLayout(new BorderLayout());

		Dimension dimProdutos = new Dimension(getWidth(), (int) (getHeight() * 0.99));
		panelProdutosComScroll.setPreferredSize(dimProdutos);

		contentPane_1.add(panelProdutosComScroll);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(123, 150, 212), 2, true));
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 0)));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelProdutosComScroll.add(scrollPane, BorderLayout.CENTER);

		JPanel panelProdutos = new JPanel();
		scrollPane.setViewportView(panelProdutos);
		panelProdutos.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 0)));
		panelProdutos.setBackground(new Color(243, 244, 240));
		panelProdutos.setLayout(new MigLayout("wrap 3", "[grow]", "[]"));
		for (Produto produto : listaProdutos) {
			JButton btnProduto = new JButton();
			  btnProduto.setPreferredSize(new Dimension(350, 400));
		        btnProduto.setMaximumSize(new Dimension(350, 400));
		        btnProduto.setMinimumSize(new Dimension(350, 400));
		        // Definindo layout para ocupar todo o botão com a imagem
		        btnProduto.setLayout(new BorderLayout());

		        // Carregando a imagem e ajustando para preencher todo o botão
		        ImageIcon imageIcon = new ImageIcon(produto.getFoto());
		        Image image = imageIcon.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
		        JLabel lblImage = new JLabel(new ImageIcon(image));
		        btnProduto.add(lblImage, BorderLayout.CENTER); // Imagem ocupa o centro do botão

		        // Definindo o título do produto abaixo da imagem
		        JLabel lblNome = new JLabel(produto.getCategoria()+" "+produto.getMarca()+" "+produto.getCor()+" "+produto.getTamanho(), SwingConstants.CENTER);
		        lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		        lblNome.setPreferredSize(new Dimension(350, 50)); // Espaço fixo para o título
		        btnProduto.add(lblNome, BorderLayout.SOUTH);

			btnProduto.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					TelaDetalhesProduto telaDetalhes = new TelaDetalhesProduto(produto);
					telaDetalhes.setVisible(true);
				}
			});

			JLabel lblSeta = new JLabel("");
			lblSeta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblSeta.setIcon(new ImageIcon(TelaCadastroProdutos.class.getResource("/img/de-volta.png")));
			lblSeta.setBounds(0, 0, 110, 100);
			ImageIcon seta = new ImageIcon(TelaCadastroProdutos.class.getResource("/img/de-volta.png"));
			Image voltar = seta.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
			lblSeta.setIcon(new ImageIcon(voltar));
			panelVazio.add(lblSeta);
			lblSeta.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					TelaMenu tela = new TelaMenu(func, mensagem);
					dispose();
					tela.setVisible(true);
					
				}
			});
			panelVazio.add(lblSeta);
			
			panelProdutos.add(btnProduto);
			btnProduto.setBackground(new Color(243, 244, 240));
		}
	}

	
}

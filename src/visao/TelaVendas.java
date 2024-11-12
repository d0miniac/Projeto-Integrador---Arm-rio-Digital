package visao;

<<<<<<< Updated upstream
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import controle.ProdutoDAO;
import modelo.Produto;
=======
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
>>>>>>> Stashed changes
import net.miginfocom.swing.MigLayout;

public class TelaVendas extends JFrame {

<<<<<<< Updated upstream
    private JPanel contentPane;
    private ArrayList<Produto> listaProdutos;
    private ProdutoDAO produtoDAO;

    public TelaVendas() {
        produtoDAO = new ProdutoDAO();
        listaProdutos = produtoDAO.selecionarProdutos(); // Carregar produtos do banco de dados

        setTitle("Catálogo de Produtos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1215, 850);
        setLocationRelativeTo(null);
        setResizable(false);

        contentPane = new JPanel(new BorderLayout());
        contentPane.setBackground(new Color(243, 244, 240));
        setContentPane(contentPane);
        
        JPanel panelVazio = new JPanel();
        panelVazio.setBackground(new Color(0, 0, 0));
        panelVazio.setOpaque(false);
        contentPane.add(panelVazio, BorderLayout.NORTH);
        
        JLabel lblSeta = new JLabel("");
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

        JPanel panelProdutos = new JPanel();
        panelProdutos.setBackground(new Color(243, 244, 240));
        
        JScrollPane scrollPane = new JScrollPane(panelProdutos);
        panelProdutos.setLayout(new MigLayout("", "[grow, fill]", "[]"));
        scrollPane.setBorder(new LineBorder(new Color(123, 150, 212), 2, true));
        contentPane.add(scrollPane, BorderLayout.CENTER);

        // Adicionar os produtos como botões com imagens e nomes
        for (Produto produto : listaProdutos) {
            JButton btnProduto = new JButton();
            
            btnProduto.setPreferredSize(new Dimension(200, 250));
            btnProduto.setLayout(new BorderLayout());

            // Adicionar imagem do produto ao botão
            ImageIcon imageIcon = new ImageIcon(produto.getFoto());
            Image image = imageIcon.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
            JLabel lblImage = new JLabel(new ImageIcon(image));
            btnProduto.add(lblImage, BorderLayout.CENTER);

            // Adicionar título do produto
            JLabel lblNome = new JLabel(produto.getFoto(), SwingConstants.CENTER);  // Corrigido para usar getNome()
            lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
            btnProduto.add(lblNome, BorderLayout.SOUTH);  // Corrigido para adicionar lblNome

            // Configurar ação do botão para abrir a tela de detalhes
            btnProduto.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    TelaDetalhesProduto telaDetalhes = new TelaDetalhesProduto(produto);  // Cria a tela de detalhes
                    telaDetalhes.setVisible(true);  // Exibe a tela
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

        // Exibir a imagem do produto
        ImageIcon imageIcon = new ImageIcon(produto.getFoto());
        Image image = imageIcon.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        JLabel lblImage = new JLabel(new ImageIcon(image));
        add(lblImage, BorderLayout.NORTH);

        // Exibir nome e preço do produto
        JPanel panelInfo = new JPanel(new GridLayout(0, 1));
        JLabel lblNome = new JLabel("Nome: " + produto.getFoto());  // Corrigido para usar getNome()
        JLabel lblPreco = new JLabel("Preço: R$" + produto.getPreco());

        lblNome.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblPreco.setFont(new Font("Tahoma", Font.BOLD, 16));
        
        panelInfo.add(lblNome);
        panelInfo.add(lblPreco);
        add(panelInfo, BorderLayout.CENTER);
=======
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVendas frame = new TelaVendas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaVendas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][grow]", "[grow][grow]"));
		
		JButton btnNewButton = new JButton("");
		contentPane.add(btnNewButton, "cell 0 0,grow");
	}
>>>>>>> Stashed changes

        setVisible(true);
    }
}

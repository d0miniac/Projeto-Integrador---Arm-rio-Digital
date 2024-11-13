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


        // Painel vazio para o botão de voltar
        JPanel panelVazio = new JPanel();
        panelVazio.setBackground(new Color(0, 0, 0));
        panelVazio.setOpaque(false);
        contentPane.add(panelVazio, BorderLayout.NORTH);


        // Adicionando o botão de voltar
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


        // Painel para exibir os produtos
        JPanel panelProdutos = new JPanel();
        panelProdutos.setBackground(new Color(243, 244, 240));


        // ScrollPane para a lista de produtos
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


        // Exibir o botão de "Voltar"
        JPanel panelBotao = new JPanel();
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a tela de detalhes
            }
        });
        panelBotao.add(btnVoltar);
        add(panelBotao, BorderLayout.SOUTH);


        setVisible(true);
    }
}



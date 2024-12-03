package visao;

import javax.swing.*;
import javax.swing.border.MatteBorder;

import java.awt.*;
import java.awt.event.*;
import controle.FornecedorDAO;
import controle.ProdutoDAO;
import modelo.*;
import net.miginfocom.swing.MigLayout;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class TelaEditarProdutos extends JFrame {

    private JPanel contentPane;
    private JTextField txtPreco;
    private JTextField txtQuantidade;
    JLabel lblimagem;
    private String novoCaminho;
    ArrayList<Fornecedor> listaFornecedores;
    FornecedorDAO fdao;

    public TelaEditarProdutos(Produto prod, Funcionario func) throws SQLException {

        setTitle("Alteração de Produtos");
        contentPane = new ImagePanel("src/img/bgEditarProduto.png");
        setContentPane(contentPane);
        contentPane.setLayout(new MigLayout("", "[grow]", "[70px][100px][100px][200px]"));

        
        JPanel topo = new JPanel();
        topo.setBorder(new MatteBorder(0, 0, 5, 0, (Color) new Color(32, 60, 115, 124)));
        topo.setBackground(new Color(0, 128, 255));
        contentPane.add(topo, "cell 0 1,grow");
        topo.setOpaque(false);
        topo.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[][]"));

      
        JLabel lblNewLabel_1 = new JLabel("PREÇO");
        topo.add(lblNewLabel_1, "flowx,cell 2 0,alignx center");

        txtPreco = new JTextField();
        txtPreco.setText(String.valueOf(prod.getPreco()));
        topo.add(txtPreco, "cell 2 0,alignx center");
        txtPreco.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("MARCA");
        topo.add(lblNewLabel_2, "flowx,cell 4 0,alignx center");

        JComboBox<Marca> cbxMarca = new JComboBox<Marca>();
        cbxMarca.addItem(Marca.NIKE);
        cbxMarca.addItem(Marca.ADIDAS);
        cbxMarca.addItem(Marca.PUMA);
        cbxMarca.setSelectedItem(prod.getMarca());
        topo.add(cbxMarca, "cell 4 0,alignx center");

        listaFornecedores = new ArrayList<>();
        fdao = new FornecedorDAO();
        listaFornecedores = fdao.selecionarFornecedores();
        JComboBox<Fornecedor> cbxFornecedor = new JComboBox<Fornecedor>();
        for (Fornecedor fornecedor : listaFornecedores) {
            cbxFornecedor.addItem(fornecedor);
        }
        for (Fornecedor fornecedor : listaFornecedores) {
            if(fornecedor.getIdFornecedor() == prod.getFornecedor()) {
                cbxFornecedor.setSelectedItem(fornecedor);
            }
        }
        topo.add(cbxFornecedor, "cell 0 0");

        
        JPanel meio = new JPanel();
        meio.setBorder(new MatteBorder(0, 0, 5, 0, (Color) new Color(32, 60, 115, 124)));
        meio.setBackground(new Color(0, 255, 0));
        contentPane.add(meio, "cell 0 2,grow");
        meio.setOpaque(false);
        meio.setLayout(new MigLayout("", "[grow][grow][grow]", "[][][]"));

        JLabel lblNewLabel_3 = new JLabel("QUANTIDADE NO ESTOQUE");
        meio.add(lblNewLabel_3, "flowx,cell 0 0,alignx center");

        txtQuantidade = new JTextField();
        txtQuantidade.setText(String.valueOf(prod.getQuantidade()));
        meio.add(txtQuantidade, "cell 0 0,alignx center");
        txtQuantidade.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("COR");
        meio.add(lblNewLabel_4, "flowx,cell 2 0,alignx center");

        JComboBox<Cor> cbxCor = new JComboBox<Cor>();
        cbxCor.addItem(Cor.AMARELO);
        cbxCor.addItem(Cor.AZUL);
        cbxCor.addItem(Cor.BRANCO);
        cbxCor.addItem(Cor.CINZA);
        cbxCor.addItem(Cor.LARANJA);
        cbxCor.addItem(Cor.MARROM);
        cbxCor.addItem(Cor.PRETO);
        cbxCor.addItem(Cor.ROSA);
        cbxCor.addItem(Cor.ROXO);
        cbxCor.addItem(Cor.VERDE);
        cbxCor.addItem(Cor.VERMELHO);
        cbxCor.setSelectedItem(prod.getCor());
        meio.add(cbxCor, "cell 2 0,alignx center");

       
        JPanel inferior = new JPanel();
        inferior.setBackground(new Color(128, 0, 255));
        contentPane.add(inferior, "cell 0 3,grow");
        inferior.setOpaque(false);
        inferior.setLayout(new MigLayout("", "[grow][grow][]", "[][][][][][]"));

        JLabel lblNewLabel_5 = new JLabel("CATEGORIA");
        inferior.add(lblNewLabel_5, "flowx,cell 0 0,alignx center");

        JComboBox<Categoria> cbxCategoria = new JComboBox();
        cbxCategoria.addItem(Categoria.BLUSA);
        cbxCategoria.addItem(Categoria.CALÇA);
        cbxCategoria.addItem(Categoria.CAMISA);
        cbxCategoria.addItem(Categoria.INTIMA);
        cbxCategoria.addItem(Categoria.JAQUETA);
        cbxCategoria.addItem(Categoria.VESTIDO);
        cbxCategoria.addItem(Categoria.SHORTS);
        cbxCategoria.setSelectedItem(prod.getCategoria());
        inferior.add(cbxCategoria, "cell 0 0,alignx center");

        JLabel lblNewLabel_6 = new JLabel("IMAGEM DO PRODUTO");
        inferior.add(lblNewLabel_6, "cell 2 0,alignx center");

        lblimagem = new JLabel("");
        lblimagem.setIcon(new ImageIcon(TelaEditarProdutos.class.getResource("/img/user.png")));
        if (prod.getFoto() != null) {
            ImageIcon imagem = new ImageIcon(prod.getFoto());
            Image img = imagem.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            lblimagem.setIcon(new ImageIcon(img));
        }
        inferior.add(lblimagem, "cell 2 3 1 2");

        
        JButton btnNewButton = new JButton("Alterar");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(32, 60, 115));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             
                if (txtPreco.getText().isEmpty() || txtQuantidade.getText().isEmpty() ||
                    cbxFornecedor.getSelectedItem() == null || cbxCategoria.getSelectedItem() == null) {
                    
                    TelaErro telaErro = new TelaErro("Por favor, preencha todos os campos obrigatórios!");
                    telaErro.setVisible(true);
                } else {
              
                    Fornecedor fnc = (Fornecedor) cbxFornecedor.getSelectedItem();
                    prod.setFornecedor(fnc.getIdFornecedor());
                    try {
                        Float preco = Float.parseFloat(txtPreco.getText());
                        int quantidade = Integer.parseInt(txtQuantidade.getText());

                        Cor corselecionada = (Cor) cbxCor.getSelectedItem();
                        Marca marcaselecionada = (Marca) cbxMarca.getSelectedItem();
                        Categoria categoriaSelecionada = (Categoria) cbxCategoria.getSelectedItem();

                        
                        prod.setPreco(preco);
                        prod.setQuantidade(quantidade);
                        prod.setCor(corselecionada);
                        prod.setMarca(marcaselecionada);
                        prod.setCategoria(categoriaSelecionada);

                       
                        ProdutoDAO dao = new ProdutoDAO();
                        dao.alterarProdutos(prod);

                       
                        TelaProdutos tela = new TelaProdutos(func, novoCaminho);
                        tela.setVisible(true);
                        tela.setSize(1215, 850);
                        dispose();
                    } catch (NumberFormatException ex) {
                        TelaErro telaErro = new TelaErro("Os campos de preço e quantidade devem ser numéricos.");
                        telaErro.setVisible(true);
                    } catch (SQLException ex) {
                        TelaErro telaErro = new TelaErro("Erro ao atualizar o produto. Tente novamente.");
                        telaErro.setVisible(true);
                    }
                }
            }
        });
        inferior.add(btnNewButton, "flowx,cell 0 5,alignx left,growy");
    }
}

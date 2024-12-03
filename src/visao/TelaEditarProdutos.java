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
	private JTextField txtTitulo;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public TelaEditarProdutos(Produto prod, Funcionario func) throws SQLException {

		setTitle("Alteração de Produtos");
		contentPane = new ImagePanel("src/img/bgEditarProduto.png");
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[70px][100px][100px][200px]"));

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

		JPanel topo = new JPanel();
		topo.setBorder(new MatteBorder(0, 0, 5, 0, (Color) new Color(32, 60, 115, 124)));
		topo.setBackground(new Color(0, 128, 255));
		contentPane.add(topo, "cell 0 1,grow");
		topo.setOpaque(false);
		topo.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[][]"));

		JLabel lblNewLabel_9 = new JLabel("FORNECEDOR");
		topo.add(lblNewLabel_9, "flowx,cell 0 0,alignx left,growy");

		JLabel lblTitulo = new JLabel("TÍTULO");
		topo.add(lblTitulo, "flowx,cell 1 0");

		txtTitulo = new JTextField();
		txtTitulo.setText(String.valueOf(prod.getTitulo()));
		topo.add(txtTitulo, "cell 1 0");
		txtTitulo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("PREÇO");
		topo.add(lblNewLabel_1, "flowx,cell 2 0,alignx center");

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
			if (fornecedor.getIdFornecedor() == prod.getFornecedor()) {
				cbxFornecedor.setSelectedItem(fornecedor);
			}
		}

		topo.add(cbxFornecedor, "cell 0 0,alignx left");

		JPanel meio = new JPanel();
		meio.setBorder(new MatteBorder(0, 0, 5, 0, (Color) new Color(32, 60, 115, 124)));
		meio.setBackground(new Color(0, 255, 0));
		contentPane.add(meio, "cell 0 2,grow");
		meio.setOpaque(false);
		meio.setLayout(new MigLayout("", "[grow][grow][grow]", "[][][]"));

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

		JLabel lblNewLabel_8 = new JLabel("TAMANHO");
		meio.add(lblNewLabel_8, "flowx,cell 1 0,alignx center");

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

		JComboBox<Tamanho> cbxTamanho = new JComboBox<Tamanho>();
		cbxTamanho.addItem(Tamanho.PP);
		cbxTamanho.addItem(Tamanho.P);
		cbxTamanho.addItem(Tamanho.M);
		cbxTamanho.addItem(Tamanho.G);
		cbxTamanho.addItem(Tamanho.GG);
		cbxTamanho.addItem(Tamanho.XG);
		cbxTamanho.addItem(Tamanho.XGG);
		cbxTamanho.addItem(Tamanho.EG);
		cbxTamanho.addItem(Tamanho.EGG);
		cbxTamanho.setSelectedItem(prod.getTamanho());
		meio.add(cbxTamanho, "cell 1 0");

		JPanel inferior = new JPanel();
		inferior.setBackground(new Color(128, 0, 255));
		contentPane.add(inferior, "cell 0 3,grow");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 568);
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

                        prod.setCor(corselecionada);
                        prod.setPreco(preco);
                        prod.setQuantidade(quantidade);
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
				String titulo = txtTitulo.getText();
				prod.setTitulo(titulo);
}

package visao;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

import controle.FornecedorDAO;
import controle.ProdutoDAO;
import modelo.Categoria;
import modelo.Cor;
import modelo.Fornecedor;
import modelo.Funcionario;
import modelo.Marca;
import modelo.Produto;
import modelo.Tamanho;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

		JPanel vazio = new JPanel();
		vazio.setBackground(new Color(255, 0, 0));
		contentPane.add(vazio, "cell 0 0,grow");
		vazio.setOpaque(false);
		vazio.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_7.setIcon(new ImageIcon(TelaEditarProdutos.class.getResource("/img/de-volta.png")));
		lblNewLabel_7.setBounds(0, 0, 40, 40);
		ImageIcon seta = new ImageIcon(TelaEditarProdutos.class.getResource("/img/de-volta.png"));
		Image voltar = seta.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		lblNewLabel_7.setIcon(new ImageIcon(voltar));
		vazio.add(lblNewLabel_7);
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaProdutos tela;
				tela = new TelaProdutos(func, novoCaminho);
				dispose();
				tela.setSize(1215, 850);
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);

			}
		});

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

		txtPreco = new JTextField();
		txtPreco.setUI(new HintTextFieldUI("R$"));
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

		JLabel lblNewLabel_3 = new JLabel("QUANTIDADE NO ESTOQUE");
		meio.add(lblNewLabel_3, "flowx,cell 0 0,alignx center");

		txtQuantidade = new JTextField();
		txtQuantidade.setText(String.valueOf(prod.getQuantidade()));

		meio.add(txtQuantidade, "cell 0 0,alignx center");
		txtQuantidade.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("TAMANHO");
		meio.add(lblNewLabel_8, "flowx,cell 1 0,alignx center");

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

		JButton btnLoad = new JButton("Selecionar Imagem");
		inferior.add(btnLoad, "cell 2 5,alignx center");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser("C://Users//Aluno//Pictures");
				file.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int i = file.showSaveDialog(null);

				if (i == 1) {
				} else {
					File arquivo = file.getSelectedFile();

					String caminhoOrigem = arquivo.getAbsolutePath();

					Date now = new Date();
					String nome_imagem = "ImagensProdutos/prod_" + now.getTime() + ".png";
					Path f = Paths.get(nome_imagem);
					novoCaminho = f.toString();
					InputStream is = null;
					OutputStream os = null;
					try {
						if (novoCaminho != prod.getFoto()) {
							is = new FileInputStream(caminhoOrigem);
							os = new FileOutputStream(novoCaminho);
							byte[] buffer = new byte[1024];
							int length;
							while ((length = is.read(buffer)) > 0) {
								os.write(buffer, 0, length);
							}
							is.close();
							os.close();
							if (novoCaminho != null) {
								prod.setFoto(novoCaminho);
							} else {
								novoCaminho = prod.getFoto();
							}
						}

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						prod.setFoto(null);
					} finally {

						prod.setFoto(nome_imagem);

						ImageIcon imagem = new ImageIcon(novoCaminho);
						Image img = imagem.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);

						lblimagem.setIcon(new ImageIcon(img));

					}

					ImageIcon imagem = new ImageIcon(novoCaminho);
					Image img = imagem.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);

					lblimagem.setIcon(new ImageIcon(img));

				}

			}
		});
		JButton btnNewButton = new JButton("Alterar");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(32, 60, 115));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Fornecedor fnc = (Fornecedor) cbxFornecedor.getSelectedItem();
				prod.setFornecedor(fnc.getIdFornecedor());
				
				String titulo = txtTitulo.getText();
				prod.setTitulo(titulo);
				
				Float preco = Float.parseFloat(txtPreco.getText());
				
				int quantidade = Integer.parseInt(txtQuantidade.getText());

				Cor corselecionada = (Cor) cbxCor.getSelectedItem();

				Marca marcaselecionada = (Marca) cbxMarca.getSelectedItem();

				Tamanho tamanhoselecionado = (Tamanho) cbxTamanho.getSelectedItem();

				Categoria categoriaSelecionada = (Categoria) cbxCategoria.getSelectedItem();

				prod.setCategoria(categoriaSelecionada);

				prod.setMarca(marcaselecionada);
				prod.setPreco(preco);
				prod.setQuantidade(quantidade);
				prod.setCor(corselecionada);
				prod.setTamanho(tamanhoselecionado);

				ProdutoDAO dao = new ProdutoDAO();
				try {
					dao.alterarProdutos(prod);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				TelaProdutos tela;
				tela = new TelaProdutos(func, novoCaminho);
				tela.setVisible(true);
				tela.setSize(1215, 850);
				dispose();

			}
		});
		inferior.add(btnNewButton, "flowx,cell 0 5,alignx left,growy");

	}
}

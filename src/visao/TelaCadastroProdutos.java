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

import controle.ProdutoDAO;
import modelo.Cor;
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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCadastroProdutos extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtPreco;
	private JTextField txtQuantidade;
	JLabel lblimagem;
	Produto produto;
	private JTextField txtFornecedor;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProdutos frame = new TelaCadastroProdutos();
					frame.setVisible(true);
					frame.setSize(657, 425);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroProdutos() {
		produto = new Produto();
		setTitle("Cadastro de Produtos");
		contentPane = new ImagePanel("src/img/bgCadastroProdutos.png");
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[70px][100px][100px][200px]"));
		
		JPanel vazio = new JPanel();
		vazio.setBackground(new Color(255, 0, 0));
		contentPane.add(vazio, "cell 0 0,grow");
		vazio.setOpaque(false);
		vazio.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_7.setIcon(new ImageIcon(TelaCadastroProdutos.class.getResource("/img/de-volta.png")));
		lblNewLabel_7.setBounds(0, 0, 40, 40);
		ImageIcon seta = new ImageIcon(TelaCadastroProdutos.class.getResource("/img/de-volta.png"));
		Image voltar = seta.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		lblNewLabel_7.setIcon(new ImageIcon(voltar));
		vazio.add(lblNewLabel_7);
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaProdutos tela = new TelaProdutos();
				dispose();
				tela.setSize(1215, 850);
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);
			}
		});
		
		
		JPanel topo = new JPanel();
		topo.setBorder(new MatteBorder(0, 0, 5, 0, (Color) new Color(32, 60, 115,124)));
		topo.setBackground(new Color(0, 128, 255));
		contentPane.add(topo, "cell 0 1,grow");
		topo.setOpaque(false);
		topo.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[][]"));
		
		JLabel lblNewLabel = new JLabel("ID Produto");
		topo.add(lblNewLabel, "flowx,cell 0 0,alignx center");
		
		txtID = new JTextField();
		topo.add(txtID, "cell 0 0,alignx center");
		txtID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("PREÇO");
		topo.add(lblNewLabel_1, "flowx,cell 2 0,alignx center");
		
		txtPreco = new JTextField();
		txtPreco.setUI(new HintTextFieldUI("R$"));
		topo.add(txtPreco, "cell 2 0,alignx center");
		txtPreco.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("MARCA");
		topo.add(lblNewLabel_2, "flowx,cell 4 0,alignx center");
		
		JComboBox cbxMarca = new JComboBox();
//		cbxMarca.setModel(new DefaultComboBoxModel(new String[] {"NIKE", "ADIDAS", "LACOSTE", "GUCCI", "PUMA"}));
		cbxMarca.addItem(Marca.NIKE);
		cbxMarca.addItem(Marca.ADIDAS);

		topo.add(cbxMarca, "cell 4 0,alignx center");
		
		JLabel lblNewLabel_9 = new JLabel("ID Fornecedor");
		topo.add(lblNewLabel_9, "flowx,cell 0 1,alignx center");
		
		txtFornecedor = new JTextField();
		topo.add(txtFornecedor, "cell 0 1,alignx center");
		txtFornecedor.setColumns(10);
		
		JPanel meio = new JPanel();
		meio.setBorder(new MatteBorder(0, 0, 5, 0, (Color) new Color(32, 60, 115,124)));
		meio.setBackground(new Color(0, 255, 0));
		contentPane.add(meio, "cell 0 2,grow");
		meio.setOpaque(false);
		meio.setLayout(new MigLayout("", "[grow][grow][grow]", "[][][]"));
		
		JLabel lblNewLabel_3 = new JLabel("QUANTIDADE NO ESTOQUE");
		meio.add(lblNewLabel_3, "flowx,cell 0 0,alignx center");
		
		txtQuantidade = new JTextField();
		meio.add(txtQuantidade, "cell 0 0,alignx center");
		txtQuantidade.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Tamanho");
		meio.add(lblNewLabel_8, "flowx,cell 1 0,alignx center");
		
		JLabel lblNewLabel_4 = new JLabel("COR");
		meio.add(lblNewLabel_4, "flowx,cell 2 0,alignx center");
		
		JComboBox cbxCor = new JComboBox();
		cbxCor.setModel(new DefaultComboBoxModel(new String[] {"VERMELHO", "LARANJA", "AMARELO", "ROSA", "AZUL", "VERDE", "ROXO", "PRETO", "BRANCO", "CINZA"}));
		meio.add(cbxCor, "cell 2 0,alignx center");
		
		JComboBox cbxTamanho = new JComboBox();
		cbxTamanho.setModel(new DefaultComboBoxModel(new String[] {"PP", "P", "M", "G", "GG", "XG", "XGG", "EG", "EGG"}));
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
		
		JComboBox cbxCategoria = new JComboBox();
		cbxCategoria.setModel(new DefaultComboBoxModel(new String[] {"CAMISA", "CALÇA", "BLUSA", "JAQUETA", "SAIA/VESTIDO", "BERMUDA/SHORTS", "ROUPA INTÍMA"}));
		inferior.add(cbxCategoria, "cell 0 0,alignx center");
		
		JLabel lblNewLabel_6 = new JLabel("IMAGEM DO PRODUTO");
		inferior.add(lblNewLabel_6, "cell 2 0,alignx center");
		
		lblimagem = new JLabel("");
		lblimagem.setIcon(new ImageIcon(TelaCadastroProdutos.class.getResource("/img/user.png")));
		inferior.add(lblimagem, "cell 2 3 1 2");
		
		
		
		
		JButton btnLoad = new JButton("Selecionar Imagem");
		inferior.add(btnLoad, "cell 2 5,alignx center");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser file = new JFileChooser("C://Users//Aluno//Pictures"); 
		          file.setFileSelectionMode(JFileChooser.FILES_ONLY);
		          int i= file.showSaveDialog(null);
		            System.out.println(i);

		        if (i==1){
		           // JtextFieldLocal.setText("");
		        } else {
		            File arquivo = file.getSelectedFile();
		
		            String caminhoOrigem = arquivo.getAbsolutePath();
		            
		            Date now = new Date();
		            Path f = Paths.get("ImagensProdutos/prod_"+now.getTime()+".png");
		            String caminhoDestino = f.toAbsolutePath().toString();
		            InputStream is = null;
		            OutputStream os = null;
		            try {
		                is = new FileInputStream(caminhoOrigem);
		                os = new FileOutputStream(caminhoDestino);
		                byte[] buffer = new byte[1024];
		                int length;
		                while ((length = is.read(buffer)) > 0) {
		                    os.write(buffer, 0, length);
		                }
		                is.close();
		                os.close();
		                produto.setFoto(caminhoDestino);
		            } catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						produto.setFoto(null);
					} finally {
		              
		            }

		            
		            produto.setFoto(caminhoDestino);

		            ImageIcon imagem = new ImageIcon(caminhoDestino);
		            Image img = imagem.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		            System.out.println(arquivo);
		            lblimagem.setIcon(new ImageIcon(img));
		            
		        }

				
			}
		});
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Float preco = Float.parseFloat(txtPreco.getText());
				int quantidade = Integer.parseInt(txtQuantidade.getText());
				Long id = Long.parseLong(txtID.getText());
				Long idF = Long.parseLong(txtFornecedor.getText());
				String categoria = null;
				if(cbxCategoria.getSelectedItem().equals("CAMISA")) {
					categoria = "Camisa";
				}
				if(cbxCategoria.getSelectedItem().equals("CALÇA")) {
					categoria = "Calça";
				}
				if(cbxCategoria.getSelectedItem().equals("BERMUDA/SHORTS")) {
					categoria = "Bermuda/Shorts";
				}
				if(cbxCategoria.getSelectedItem().equals("SAIA/VESTIDO")) {
					categoria = "Saia/Vestido";
				}
				if(cbxCategoria.getSelectedItem().equals("ROUPA INTÍMA")) {
					categoria = "Roupa Intíma";
				}
				if(cbxCategoria.getSelectedItem().equals("JAQUETA")) {
					categoria = "Jaqueta";
				}
				if(cbxCategoria.getSelectedItem().equals("BLUSA")) {
					categoria = "Blusa";
				}
				
				String cor = null;
				Cor corselecionada = (Cor)cbxCor.getSelectedItem();
				cor = corselecionada.getDescricao();
				
				String marca = null;
				Marca marcaselecionada = (Marca) cbxMarca.getSelectedItem();
				marca = marcaselecionada.getDescricao();
				
				
				String tamanho = null;
				Tamanho tamanhoselecionado = (Tamanho) cbxTamanho.getSelectedItem();
				tamanho = tamanhoselecionado.getDescricao();
				
				
				produto.setCategoria(categoria);
				//produto.setFoto(caminhoDestino);
				produto.setId(id);
				produto.setFornecedor(idF);
				produto.setMarca(marca);
				produto.setPreco(preco);
				produto.setQuantidade(quantidade);
				produto.setCor(cor);
				produto.setTamanho(tamanho);
				
				TelaProdutos tela = new TelaProdutos();
				dispose();
				tela.setVisible(true);
				tela.setSize(1215, 850);
				
				//testes
				System.out.println(produto.getCategoria());
				System.out.println(produto.getFoto());
				System.out.println(produto.getMarca());
				System.out.println(produto.getQuantidade());
				System.out.println(produto.getId());
				System.out.println(produto.getPreco());
				ProdutoDAO dao = new ProdutoDAO();
				int res1=dao.cadastrarProduto(produto);
				
				
				
			}
		});
		inferior.add(btnNewButton, "flowx,cell 0 5,alignx center");
		
		JButton btnNewButton_1 = new JButton("New button");
		inferior.add(btnNewButton_1, "cell 0 5,alignx center");
		
		

	}
}

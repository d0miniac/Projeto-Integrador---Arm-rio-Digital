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
import modelo.Produto;

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
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;

public class TelaCadastroFornecedores extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	Produto produto;
	private JTextField textEMAIL;
	private JTextField textNOMECONTATO;
	private JTextField textMARCA;
	private JTextField textTELEFONE;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFornecedores frame = new TelaCadastroFornecedores();
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
	public TelaCadastroFornecedores() {
		setResizable(false);
		produto = new Produto();
		setTitle("Cadastro de Produtos");
		contentPane = new ImagePanel("src/img/bgTelaFornecedores.png");
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[70px][][grow][][100px][150px][150px][100px]"));
		
		JPanel vazio = new JPanel();
		FlowLayout flowLayout = (FlowLayout) vazio.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		vazio.setBackground(new Color(255, 0, 0));
		contentPane.add(vazio, "cell 0 0,grow");
		vazio.setOpaque(false);
		//vazio.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_7.setIcon(new ImageIcon(TelaCadastroFornecedores.class.getResource("/img/de-volta.png")));
		lblNewLabel_7.setBounds(0, 0, 40, 40);
		ImageIcon seta = new ImageIcon(TelaCadastroFornecedores.class.getResource("/img/de-volta.png"));
		Image voltar = seta.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		lblNewLabel_7.setIcon(new ImageIcon(voltar));
		vazio.add(lblNewLabel_7);
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaFornecedores tela = new TelaFornecedores();
				dispose();
				tela.setSize(1215, 850);
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Informações do fornecedor");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setForeground(new Color(153, 162, 209));
		contentPane.add(lblNewLabel, "cell 0 3");
		
		JPanel topo_1_1 = new JPanel();
		topo_1_1.setOpaque(false);
		topo_1_1.setBorder(new MatteBorder(0, 0, 5, 0, (Color) new Color(32, 60, 115,124)));
		topo_1_1.setBackground(new Color(0, 128, 255));
		contentPane.add(topo_1_1, "cell 0 4,grow");
		topo_1_1.setLayout(new MigLayout("", "[]", "[]"));
		
		
		JPanel topo = new JPanel();
		topo.setBorder(new MatteBorder(0, 0, 5, 0, (Color) new Color(32, 60, 115,124)));
		topo.setBackground(new Color(0, 128, 255));
		contentPane.add(topo, "cell 0 5,grow");
		topo.setOpaque(false);
		topo.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[]"));
		
		JLabel lblID = new JLabel("ID");
		topo.add(lblID, "flowx,cell 0 0,alignx center");
		
		txtID = new JTextField();
		topo.add(txtID, "cell 0 0,alignx center");
		txtID.setColumns(10);
		
		JLabel lblEMAIL = new JLabel("EMAIL");
		topo.add(lblEMAIL, "flowx,cell 2 0,alignx center");
		
		JLabel lblMARCA = new JLabel("MARCA");
		topo.add(lblMARCA, "flowx,cell 4 0,alignx center");
		
		textEMAIL = new JTextField();
		textEMAIL.setColumns(10);
		topo.add(textEMAIL, "cell 2 0");
		
		textMARCA = new JTextField();
		topo.add(textMARCA, "cell 4 0");
		textMARCA.setColumns(10);
		
		JPanel topo_1 = new JPanel();
		topo_1.setOpaque(false);
		topo_1.setBorder(new MatteBorder(0, 0, 5, 0, (Color) new Color(32, 60, 115,124)));
		topo_1.setBackground(new Color(0, 128, 255));
		contentPane.add(topo_1, "cell 0 6,grow");
		topo_1.setLayout(new MigLayout("", "[70px][100px][][][70px][70px][][][][][][][][]", "[][]"));
		
		JLabel lblNOMECONTATO = new JLabel("NOME P/ CONTATO");
		topo_1.add(lblNOMECONTATO, "cell 1 1,alignx trailing");
		
		textNOMECONTATO = new JTextField();
		textNOMECONTATO.setColumns(10);
		topo_1.add(textNOMECONTATO, "cell 3 1");
		
		JLabel lblTELEFONE = new JLabel("TELEFONE");
		topo_1.add(lblTELEFONE, "cell 6 1");
		
		textTELEFONE = new JTextField();
		topo_1.add(textTELEFONE, "cell 7 1,alignx center");
		textTELEFONE.setColumns(10);
		
		JPanel inferior = new JPanel();
		inferior.setBackground(new Color(128, 0, 255));
		contentPane.add(inferior, "cell 0 7,grow");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 568);
		inferior.setOpaque(false);
		inferior.setLayout(new MigLayout("", "[100px][100px][grow][grow][]", "[][][][][][]"));
		
		JButton btnNewButton_1 = new JButton("EXCLUIR");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(32, 60, 115));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		JButton btnNewButton = new JButton("SALVAR");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(32, 60, 115));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Float preco = Float.parseFloat(txtPreco.getText());
				int quantidade = Integer.parseInt(txtQuantidade.getText());
				Long id = Long.parseLong(txtID.getText());
				
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
				if(cbxCor.getSelectedItem().equals("LARANJA")) {
					cor = "Laranja";
				}
				if(cbxCor.getSelectedItem().equals("VERMELHO")) {
					cor = "Vermelho";
				}
				if(cbxCor.getSelectedItem().equals("AMARELO")) {
					cor = "Amarelo";
				}
				if(cbxCor.getSelectedItem().equals("ROSA")) {
					cor = "Rosa";
				}
				if(cbxCor.getSelectedItem().equals("AZUL")) {
					cor = "Azul";
				}
				if(cbxCor.getSelectedItem().equals("VERDE")) {
					cor = "Verde";
				}
				if(cbxCor.getSelectedItem().equals("ROXO")) {
					cor = "Roxo";
				}
				if(cbxCor.getSelectedItem().equals("PRETO")) {
					cor = "Preto";
				}
				if(cbxCor.getSelectedItem().equals("BRANCO")) {
					cor = "Branco";
				}
				if(cbxCor.getSelectedItem().equals("CINZA")) {
					cor = "Cinza";
				}
				
				String marca = null;
				if(cbxMarca.getSelectedItem().equals("NIKE")) {
					marca = "Nike";
				}
				if(cbxMarca.getSelectedItem().equals("ADIDAS")) {
					marca = "Adidas";
				}
				if(cbxMarca.getSelectedItem().equals("LACOSTE")) {
					marca = "Lacoste";
				}
				if(cbxMarca.getSelectedItem().equals("GUCCI")) {
					marca = "Gucci";
				}
				if(cbxMarca.getSelectedItem().equals("PUMA")) {
					marca = "Puma";
				}
				
				String tamanho = null;
				if(cbxTamanho.getSelectedItem().equals("PP")) {
					tamanho = "PP";
				}
				if(cbxTamanho.getSelectedItem().equals("P")) {
					tamanho = "P";
				}
				if(cbxTamanho.getSelectedItem().equals("M")) {
					tamanho = "M";
				}
				if(cbxTamanho.getSelectedItem().equals("G")) {
					tamanho = "G";
				}
				if(cbxTamanho.getSelectedItem().equals("GG")) {
					tamanho = "GG";
				}
				if(cbxTamanho.getSelectedItem().equals("XG")) {
					tamanho = "XG";
				}
				if(cbxTamanho.getSelectedItem().equals("XGG")) {
					tamanho = "XGG";
				}
				if(cbxTamanho.getSelectedItem().equals("EG")) {
					tamanho = "EG";
				}
				if(cbxTamanho.getSelectedItem().equals("EGG")) {
					tamanho = "EGG";
				}
				
				
				produto.setCategoria(categoria);
				//produto.setFoto(caminhoDestino);
				produto.setId(id);
				produto.setMarca(marca);
				produto.setPreco(preco);
				produto.setQuantidade(quantidade);
				produto.setCor(cor);
				produto.setTamanho(tamanho);
				
				TelaProdutos tela = new TelaProdutos();
				tela.cadastrar(produto);
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
				dao.cadastrarProduto(produto);
				
				
			}
		});
		inferior.add(btnNewButton, "cell 0 5,alignx center");
		inferior.add(btnNewButton_1, "cell 1 5,alignx center");
		
		

	}
}

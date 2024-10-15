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
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCadastroFornecedor extends JFrame {
	public TelaCadastroFornecedor() {
		getContentPane().setLayout(new MigLayout("", "[30px][20px,grow][50px,grow][50px,grow][50px,grow][50px,grow][50px,grow][20px,grow][30px]", "[20px,grow][20px,grow][20px,grow][20px,grow][20px,grow][20px,grow][20px,grow][20px,grow][20px,grow]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 192));
		getContentPane().add(panel, "cell 1 1 7 7,grow");
	}

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	JLabel lblimagem;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFornecedor  frame = new TelaCadastroFornecedor ();
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
	public TelaCadastroFornecedor() {
		setTitle("Cadastro de Fornecedor ");
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
		lblNewLabel_7.setIcon(new ImageIcon(TelaCadastroFornecedor .class.getResource("/img/de-volta.png")));
		lblNewLabel_7.setBounds(0, 0, 40, 40);
		ImageIcon seta = new ImageIcon(TelaCadastroFornecedor .class.getResource("/img/de-volta.png"));
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
		topo.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[]"));
		
		JLabel lblNewLabel = new JLabel("ID");
		topo.add(lblNewLabel, "flowx,cell 0 0,alignx center");
		
		textField = new JTextField();
		topo.add(textField, "cell 0 0,alignx center");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("PREÇO");
		topo.add(lblNewLabel_1, "flowx,cell 2 0,alignx center");
		
		textField_1 = new JTextField();
		topo.add(textField_1, "cell 2 0,alignx center");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("MARCA");
		topo.add(lblNewLabel_2, "flowx,cell 4 0,alignx center");
		
		JComboBox comboBox_1 = new JComboBox();
		topo.add(comboBox_1, "cell 4 0,alignx center");
		
		JPanel meio = new JPanel();
		meio.setBorder(new MatteBorder(0, 0, 5, 0, (Color) new Color(32, 60, 115,124)));
		meio.setBackground(new Color(0, 255, 0));
		contentPane.add(meio, "cell 0 2,grow");
		meio.setOpaque(false);
		meio.setLayout(new MigLayout("", "[grow][grow][grow]", "[][][]"));
		
		JLabel lblNewLabel_3 = new JLabel("QUANTIDADE NO ESTOQUE");
		meio.add(lblNewLabel_3, "flowx,cell 0 0,alignx center");
		
		textField_3 = new JTextField();
		meio.add(textField_3, "cell 0 0,alignx center");
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("COR");
		meio.add(lblNewLabel_4, "flowx,cell 2 0,alignx center");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Vermelho", "Laranja", "Amarelo", "Rosa", "Azul", "Verde", "Roxo", "Preto", "Branco", "Cinza"}));
		meio.add(comboBox, "cell 2 0,alignx center");
		
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
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Camisa", "Calça", "Blusa", "Jaqueta", "Saia/Vestido", "Bermuda/Shorts", "Roupa Intíma"}));
		inferior.add(comboBox_2, "cell 0 0,alignx center");
		
		JLabel lblNewLabel_6 = new JLabel("IMAGEM DO PRODUTO");
		inferior.add(lblNewLabel_6, "cell 2 0,alignx center");
		
		lblimagem = new JLabel("");
		lblimagem.setIcon(new ImageIcon(TelaCadastroProdutos.class.getResource("/img/user.png")));
		inferior.add(lblimagem, "cell 2 3 1 2");
		
		JButton btnNewButton = new JButton("Salvar");
		inferior.add(btnNewButton, "flowx,cell 0 5,alignx center");
		
		JButton btnLoad = new JButton("Selecionar Imagem");
		inferior.add(btnLoad, "cell 2 5,alignx center");
		
		JButton btnNewButton_1 = new JButton("New button");
		inferior.add(btnNewButton_1, "cell 0 5,alignx center");
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
		
		            String caminho = arquivo.getAbsolutePath();
		            ImageIcon imagem = new ImageIcon(caminho);
		            Image img = imagem.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		            System.out.println(arquivo);
		            lblimagem.setIcon(new ImageIcon(img));
		            
		        }

				
			}
		});
		

	}

}

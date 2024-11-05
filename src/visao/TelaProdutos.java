package visao;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controle.ProdutoDAO;
import modelo.Produto;
import modelo.ProdutoTableModel;
import net.miginfocom.swing.MigLayout;

public class TelaProdutos extends JFrame {

	private JPanel contentPane;
	private JTextField txtFiltro;
	private JTable tableProdutos;
	private ArrayList<Produto> listaProdutos;
	private ProdutoTableModel ptm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProdutos frame = new TelaProdutos();
					frame.setVisible(true);
					frame.setSize(1215, 850);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public TelaProdutos() throws SQLException {
		listaProdutos = new ArrayList<>();
		ProdutoDAO pDao = new ProdutoDAO();
		listaProdutos = pDao.selecionarProdutos();
		
		setTitle("Produtos");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 841, 545);
		contentPane = new ImagePanel("src/img/bgProdutos.png");
		contentPane.setBackground(new Color(243, 244, 240));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow,fill]", "[120px][grow]"));
		
		JPanel panelVazio = new JPanel();
		panelVazio.setBackground(new Color(0, 0, 0));
		panelVazio.setOpaque(false);
		contentPane.add(panelVazio, "cell 0 0,grow");
		panelVazio.setLayout(null);
		
		
		
		JPanel panelComponentes = new JPanel();
		panelComponentes.setBackground(new Color(255, 0, 0));
		panelComponentes.setOpaque(false);
		contentPane.add(panelComponentes, "cell 0 1,grow");
		panelComponentes.setLayout(new MigLayout("", "[][][][][grow][]", "[][][grow]"));
		
		
		txtFiltro = new JTextField();
		txtFiltro.setUI(new HintTextFieldUI("Pesquisa"));
		txtFiltro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFiltro.setBorder(new LineBorder(new Color(123, 150, 212), 2, true));
		panelComponentes.add(txtFiltro, "cell 4 0,alignx left");
		txtFiltro.setColumns(90);
		txtFiltro.setPreferredSize(new Dimension(450,45));
		
		JButton btnAdd = new JButton("Adicionar");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaCadastroProdutos tela = new TelaCadastroProdutos();
				tela.setVisible(true);
				tela.setSize(657, 425);
				tela.setLocationRelativeTo(null);
				
			}
		});
		btnAdd.setBackground(new Color(243, 244, 240));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnAdd.setMinimumSize(new Dimension(150, 30));
		btnAdd.setMaximumSize(new Dimension(150, 30));
		btnAdd.setBorder(new LineBorder(new Color(123, 150, 212), 2, true));
		panelComponentes.add(btnAdd, "cell 4 1,alignx left,growy");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(123, 150, 212), 2, true));
		panelComponentes.add(scrollPane, "cell 4 2,grow");
		
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
				TelaMenu tela = new TelaMenu();
				dispose();
				tela.setVisible(true);
				TelaMenu telaMenu = new TelaMenu();
				dispose();
				tela.setVisible(true);
			}
		});
		ptm = new ProdutoTableModel(listaProdutos);
		tableProdutos = new JTable();
		tableProdutos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tableProdutos.setGridColor(new Color(0,0,0));
		tableProdutos.setBackground(new Color(123, 150, 212));
		tableProdutos.setForeground(new Color(255,255,255));
		tableProdutos.setModel(ptm);
		theader();
		scrollPane.setViewportView(tableProdutos);
	}
	private void theader() {
		JTableHeader thead= tableProdutos.getTableHeader();
		thead.setForeground(new Color(123,150,212));
		thead.setBackground(new Color(255,255,255));
		thead.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
	}
	
	
	
	
}


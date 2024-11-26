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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.JTextComponent;

import controle.ProdutoDAO;
import modelo.Funcionario;
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
	

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public TelaProdutos(Funcionario func, String mensagem)  {
		listaProdutos = new ArrayList<>();
		ProdutoDAO p = new ProdutoDAO();
		listaProdutos = p.selecionarProdutos();
		
		setTitle("Produtos");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new ImagePanel("src/img/bgProdutos.png");
		contentPane.setBackground(new Color(243, 244, 240));
		setContentPane(contentPane);
		setSize(1215, 850);
		setLocationRelativeTo(null);
		setResizable(false);

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
		txtFiltro.setUI(new HintTextFieldUI("Pesquise por categoria, marca, cor ou tamanho"));
		txtFiltro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFiltro.setBorder(new LineBorder(new Color(123, 150, 212), 2, true));
		panelComponentes.add(txtFiltro, "flowx,cell 4 0,alignx left");
		txtFiltro.setColumns(90);
		txtFiltro.setPreferredSize(new Dimension(450,45));
		
		JButton btnAdd = new JButton("Adicionar");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaCadastroProdutos tela;
				try {
					tela = new TelaCadastroProdutos(func, mensagem);
					tela.setVisible(true);
					tela.setSize(657, 425);
					tela.setLocationRelativeTo(null);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnAdd.setBackground(new Color(243, 244, 240));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnAdd.setMinimumSize(new Dimension(150, 30));
		btnAdd.setMaximumSize(new Dimension(150, 30));
		btnAdd.setBorder(new LineBorder(new Color(123, 150, 212), 2, true));
		panelComponentes.add(btnAdd, "flowx,cell 4 1,alignx left,aligny center");
		
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
				TelaMenu tela = new TelaMenu(func, mensagem);
				dispose();
				tela.setVisible(true);
				
			}
		});
		tableProdutos = new JTable();
		tableProdutos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tableProdutos.setGridColor(new Color(0,0,0));
		tableProdutos.setBackground(new Color(123, 150, 212));
		tableProdutos.setForeground(new Color(255,255,255));
		
		ptm = new ProdutoTableModel(listaProdutos);
		tableProdutos.setModel(ptm);
		
		theader();
		
		scrollPane.setViewportView(tableProdutos);
		
		JButton btnUpdate = new JButton("Alterar");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tableProdutos.getSelectedRow();
				
				
				
				Long id = (Long) tableProdutos.getModel().getValueAt(i, 0);
				Produto pdt = listaProdutos.get(i);// Produto();
				/*
				for (Produto produto : listaProdutos) {
					if(produto.getId()==id) {
						pdt.setId(produto.getId());
						pdt.setCategoria(produto.getCategoria());
						pdt.setCor(produto.getCor());
						pdt.setFornecedor(produto.getFornecedor());
						pdt.setFoto(produto.getFoto());
						pdt.setMarca(produto.getMarca());
						pdt.setPreco(produto.getPreco());
						pdt.setQuantidade(produto.getQuantidade());
						pdt.setTamanho(produto.getTamanho());
					}
				}*/
				
				TelaEditarProdutos tela = new TelaEditarProdutos(pdt,func, mensagem);
				dispose();
				tela.setVisible(true);
			}
		});
		btnUpdate.setBackground(new Color(243, 244, 240));
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnUpdate.setMinimumSize(new Dimension(150, 30));
		btnUpdate.setMaximumSize(new Dimension(150, 30));
		btnUpdate.setBorder(new LineBorder(new Color(123, 150, 212), 2, true));
		panelComponentes.add(btnUpdate, "cell 4 1");
		
		JButton btnDelete = new JButton("Deletar");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int r=JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esse produto?", "Exclusão", JOptionPane.YES_NO_OPTION);
				if(r==JOptionPane.YES_OPTION) {
					int i = tableProdutos.getSelectedRow();
					Long id = (Long) tableProdutos.getModel().getValueAt(i, 0);
					
					
					
					
					try {
						p.excluirProdutos(id);
						listaProdutos = p.selecionarProdutos();
						ptm = new ProdutoTableModel(listaProdutos);
						tableProdutos.setModel(ptm);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
				
				
			}
		});
		btnDelete.setBackground(new Color(243, 244, 240));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnDelete.setMinimumSize(new Dimension(150, 30));
		btnDelete.setMaximumSize(new Dimension(150, 30));
		btnDelete.setBorder(new LineBorder(new Color(123, 150, 212), 2, true));
		panelComponentes.add(btnDelete, "cell 4 1");
		
		
		
		JButton btnPesquisa = new JButton("PESQUISAR");
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!txtFiltro.getText().trim().isEmpty()) {
					String filtro = txtFiltro.getText();
					listaProdutos = p.pesquisarProdutos(filtro);
					ptm = new ProdutoTableModel(listaProdutos);
					tableProdutos.setModel(ptm);
					
				}
				
				else {
					listaProdutos = p.selecionarProdutos();
					ptm = new ProdutoTableModel(listaProdutos);
					tableProdutos.setModel(ptm);
				}
				
				
			}
		});
		panelComponentes.add(btnPesquisa, "cell 4 0,alignx center,aligny center");
		btnPesquisa.setBackground(new Color(243, 244, 240));
		btnPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnPesquisa.setMinimumSize(new Dimension(150, 30));
		btnPesquisa.setMaximumSize(new Dimension(150, 30));
		btnPesquisa.setBorder(new LineBorder(new Color(123, 150, 212), 2, true));
	}
	private void theader() {
		JTableHeader thead= tableProdutos.getTableHeader();
		thead.setForeground(new Color(123,150,212));
		thead.setBackground(new Color(255,255,255));
		thead.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
	}
	
	
	
	
}


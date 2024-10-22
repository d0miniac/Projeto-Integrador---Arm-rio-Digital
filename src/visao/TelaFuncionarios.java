package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import junit.framework.Test;
import modelo.Produto;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class TelaFuncionarios extends JFrame {

	private JPanel contentPane;
	private JTextField txtFiltro;
	private JTable table;
	ArrayList<Produto> listaFuncionarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFuncionarios frame = new TelaFuncionarios();
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
	 */
	public TelaFuncionarios() {
		setTitle("Funcionarios");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 841, 545);
		contentPane = new ImagePanel("src/img/bgFuncionarios.png");
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
				TelaCadastroFuncionario tela = new TelaCadastroFuncionario();
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
		lblSeta.setIcon(new ImageIcon(TelaCadastroFuncionario.class.getResource("/img/de-volta.png")));
		lblSeta.setBounds(0, 0, 110, 100);
		ImageIcon seta = new ImageIcon(TelaCadastroFuncionario.class.getResource("/img/de-volta.png"));
		Image voltar = seta.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		lblSeta.setIcon(new ImageIcon(voltar));
		panelVazio.add(lblSeta);
		lblSeta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("No futuro vai voltar pro menu principal");
				/*TelaMenu tela = new TelaMenu(f);
				dispose();
				tela.setVisible(true);*/
			}
		});
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setGridColor(new Color(0,0,0));
		table.setBackground(new Color(123, 150, 212));
		table.setForeground(new Color(255,255,255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "Letícia Gehrke", "126.055.319-10", "leticiaghrke@gmail.com","1234"},
			},
			new String[] {
				"ID", "Nome Completo", "CPF", "Email", "Senha"
			}
		));
		theader();
		scrollPane.setViewportView(table);
	}
	private void theader() {
		JTableHeader thead= table.getTableHeader();
		thead.setForeground(new Color(123,150,212));
		thead.setBackground(new Color(255,255,255));
		thead.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
	}
	
	public void cadastrar(Produto p) {
		listaFuncionarios.add(p);
		atualizarTabela();
	}
	
	protected void atualizarTabela() {
		DefaultTableModel tableModel = new DefaultTableModel(
				new Object[][] {
					{"1", "Letícia Gehrke", "126.055.319-10", "leticiaghrke@gmail.com","1234"},
				},
				new String[] {
					"ID", "Nome Completo", "CPF", "Email", "Senha"
				}
				);
		
		for (Produto produto : listaFuncionarios) {
			tableModel.addRow(new Object[] {produto.getId(),produto.getCategoria(),produto.getMarca(),produto.getCor(),produto.getTamanho(),produto.getQuantidade(),produto.getPreco()});
		}
		
		}
}


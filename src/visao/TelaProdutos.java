package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import junit.framework.Test;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import net.miginfocom.swing.MigLayout;
import java.awt.Color;
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
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class TelaProdutos extends JFrame {

	private JPanel contentPane;
	private JTextField txtFiltro;
	private JTable table;

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
	 */
	public TelaProdutos() {
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
		
		
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setGridColor(new Color(0,0,0));
		table.setBackground(new Color(123, 150, 212));
		table.setForeground(new Color(255,255,255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "Cal\u00E7a", "Nike", "Preta", "38", "150", "R$ 200,00"},
			},
			new String[] {
				"ID", "Categoria", "Marca", "Cor", "Tamanho", "Quantidade", "Pre\u00E7o"
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

}

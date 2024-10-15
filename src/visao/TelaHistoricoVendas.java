package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaHistoricoVendas extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaHistoricoVendas frame = new TelaHistoricoVendas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaHistoricoVendas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][grow][]", "[][grow]"));
		
		JLabel lblNewLabel = new JLabel("Categoria");
		contentPane.add(lblNewLabel, "flowx,cell 0 0,alignx left");
		
		JComboBox<String> comboCategoria = new JComboBox<>();
		contentPane.add(comboCategoria, "cell 1 0,growx");
		comboCategoria.addItem("Todos");
		comboCategoria.addItem("Camisa");
		comboCategoria.addItem("Calça");
		comboCategoria.addItem("Blusa");
		comboCategoria.addItem("Jaqueta");
		comboCategoria.addItem("Saia/Vestido");
		comboCategoria.addItem("Bermuda/Shorts");
		comboCategoria.addItem("Roupa Intíma");

		
		JButton btnBuscar = new JButton("Buscar");
		contentPane.add(btnBuscar, "cell 2 0");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buscarVendas();		
	
		}
	

	protected void buscarVendas() {
		// TODO Auto-generated method stub
		
	}
		});
				
				JScrollPane scrollPane = new JScrollPane();
				contentPane.add(scrollPane, "flowx,cell 1 1,grow");
				table = new JTable();
				scrollPane.setViewportView(table);
				table.setModel(new DefaultTableModel(

				new Object[][] {
					{"1", "Cal\u00E7a", "Nike", "Preta", "38", "150", "R$ 200,00"},
				},
				new String[] {
					"ID", "Categoria", "Marca", "Cor", "Tamanho", "Quantidade", "Pre\u00E7o"
				}
			));
		theader();
		
	}
	

	private void theader() {
		JTableHeader thead= table.getTableHeader();
		thead.setForeground(new Color(123,150,212));
		thead.setBackground(new Color(255,255,255));
		thead.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
	}
	
}


	


	

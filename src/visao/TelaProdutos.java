package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaProdutos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow,fill]", "[120px][grow]"));
		
		JPanel panelVazio = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelVazio.getLayout();
		flowLayout.setHgap(0);
		panelVazio.setBackground(new Color(0, 0, 0));
		panelVazio.setOpaque(false);
		contentPane.add(panelVazio, "cell 0 0,grow");
		
		JPanel panelComponentes = new JPanel();
		panelComponentes.setBackground(new Color(255, 0, 0));
		panelComponentes.setOpaque(false);
		contentPane.add(panelComponentes, "cell 0 1,grow");
		panelComponentes.setLayout(new MigLayout("", "[][][][]", "[][][][][][][]"));
		
		textField = new JTextField();
		panelComponentes.add(textField, "cell 1 0 3 1,alignx center");
		textField.setColumns(90);
		
		JButton btnNewButton = new JButton("New button");
		panelComponentes.add(btnNewButton, "cell 1 1");
	}

}

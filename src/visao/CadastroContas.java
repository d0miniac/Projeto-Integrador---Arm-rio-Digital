package visao;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CadastroContas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroContas frame = new CadastroContas();
					frame.setVisible(true);
					frame.setSize(1215,850);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroContas() {
		setResizable(false);
		setTitle("Cadastro de Contas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 640);

		
		contentPane = new ImagePanel("src/img/background3.png");
		setContentPane(contentPane);
		

		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel PainelVazio = new JPanel();
		PainelVazio.setBackground(new Color(0, 0, 0,0));
		contentPane.add(PainelVazio);
		
		
		JPanel PainelComponentes = new JPanel();
		PainelComponentes.setBackground(new Color(243, 244, 240));
		contentPane.add(PainelComponentes);
		PainelComponentes.setLayout(new MigLayout("", "[46px,grow]", "[40px][14px][100px][][][][][][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Crie uma nova conta!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 60));
		PainelComponentes.add(lblNewLabel, "cell 0 1,alignx left,aligny top");
		
		JLabel lblNewLabel_1 = new JLabel("Nome Completo:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		PainelComponentes.add(lblNewLabel_1, "cell 0 3");
		
		txtNome = new RoundJTextField(25);
		txtNome.setBackground(new Color(65, 82, 179,128));
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 25));
		PainelComponentes.add(txtNome, "cell 0 4,alignx left");
		txtNome.setColumns(25);
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		PainelComponentes.add(lblNewLabel_2, "cell 0 5");
		
		textField_1 = new RoundJTextField(25);
		textField_1.setBackground(new Color(65, 82, 179,128));
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		PainelComponentes.add(textField_1, "cell 0 6,alignx left");
		textField_1.setColumns(25);
		
		JLabel lblNewLabel_3 = new JLabel("E-mail:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		PainelComponentes.add(lblNewLabel_3, "cell 0 7");
		
		textField_2 = new RoundJTextField(25);
		textField_2.setBackground(new Color(65, 82, 179,128));
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		PainelComponentes.add(textField_2, "cell 0 8,alignx left");
		textField_2.setColumns(25);
		
		JLabel lblNewLabel_4 = new JLabel("Senha:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		PainelComponentes.add(lblNewLabel_4, "cell 0 9");
		
		textField_3 = new RoundJTextField(25);
		textField_3.setBackground(new Color(65, 82, 179,128));
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		PainelComponentes.add(textField_3, "cell 0 10,alignx left");
		textField_3.setColumns(25);
		
		JLabel lblNewLabel_5 = new JLabel("Confirme a Senha:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		PainelComponentes.add(lblNewLabel_5, "cell 0 11");
		
		textField_4 = new RoundJTextField(25);
		textField_4.setBackground(new Color(65, 82, 179,128));
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		PainelComponentes.add(textField_4, "cell 0 12,alignx left");
		textField_4.setColumns(25);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setForeground(new Color(243, 244, 240));
		btnNewButton.setBackground(new Color(65, 82, 179));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		PainelComponentes.add(btnNewButton, "cell 0 14,alignx center");
		
	}
}

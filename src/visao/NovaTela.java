package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

public class NovaTela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovaTela frame = new NovaTela();
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
	public NovaTela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1039, 676);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow 50,fill][grow 25][][grow 25]", "[][][][][][][][][][][][][][][]"));
        ImageIcon icon = new ImageIcon("src/img/background1.png");
        Image image = icon.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel backgroundLabel = new JLabel(scaledIcon);
        backgroundLabel.setForeground(new Color(255, 255, 255));
        backgroundLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        backgroundLabel.setBounds(-20, 0, 1904, 1041);
        //contentPane.add(backgroundLabel, "cell 0 0");
        
        JLabel lblNewLabel = new JLabel("Bem vindo");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
        contentPane.add(lblNewLabel, "cell 1 1");
        
        JLabel lblNewLabel_2 = new JLabel("novamente!");
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 50));
        contentPane.add(lblNewLabel_2, "cell 1 2");
        
        JLabel lblNewLabel_1 = new JLabel("CPF:");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        contentPane.add(lblNewLabel_1, "cell 1 5");
        
        textField = new JTextField();
        textField.setColumns(10);
        contentPane.add(textField, "cell 1 6 3 1,growx");
        
        JLabel lblNewLabel_3 = new JLabel("Senha:");
        lblNewLabel_3.setForeground(Color.WHITE);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
        contentPane.add(lblNewLabel_3, "cell 1 8");
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        contentPane.add(textField_1, "cell 1 9 3 1,growx");
        
        JCheckBox chckbxNewCheckBox = new JCheckBox("Mostrar senha");
        chckbxNewCheckBox.setForeground(Color.WHITE);
        chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
        chckbxNewCheckBox.setBackground(new Color(32, 60, 115));
        contentPane.add(chckbxNewCheckBox, "cell 1 10");
        
        JButton btnNewButton = new JButton("Esqueci a senha");
        btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.setFocusPainted(false);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setBackground(new Color(32, 60, 115));
        contentPane.add(btnNewButton, "cell 3 10,alignx center,aligny center");
        
        JButton btnNewButton_1 = new JButton("Login");
        btnNewButton_1.setForeground(Color.WHITE);
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
        btnNewButton_1.setBackground(new Color(103, 203, 239));
        contentPane.add(btnNewButton_1, "cell 1 12 3 1,grow");
        
        JLabel lblNewLabel_4 = new JLabel("Ainda não tem uma conta?");
        lblNewLabel_4.setForeground(Color.WHITE);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
        contentPane.add(lblNewLabel_4, "cell 1 13");
        
        JButton btnCadastrese = new JButton("cadastre-se");
        btnCadastrese.setForeground(Color.WHITE);
        btnCadastrese.setFont(new Font("Tahoma", Font.PLAIN, 25));
        btnCadastrese.setFocusPainted(false);
        btnCadastrese.setBorderPainted(false);
        btnCadastrese.setBackground(new Color(32, 60, 115));
        contentPane.add(btnCadastrese, "cell 2 13");

	}

}

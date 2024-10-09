package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class TelaEsqueciSenha extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEsqueciSenha frame = new TelaEsqueciSenha();
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
	public TelaEsqueciSenha() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 695);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane = new ImagePanel("src/img/backgroundSenha.png");
		setContentPane(contentPane);

		contentPane.setLayout(new MigLayout("", "[200px,grow][grow][grow]", "[50px][100px][100px][][][][][][][][][][][][][][50px][][][]"));
		
		JLabel lblNewLabel = new JLabel("Esqueceu sua Senha?");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		contentPane.add(lblNewLabel, "cell 1 5 2 1");
		
		JLabel lblNewLabel_2 = new JLabel("Para redefinir sua senha, precisamos do");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lblNewLabel_2, "cell 1 9 2 1");
		
		JLabel lblNewLabel_1 = new JLabel("e-mail utilizado para a criação da conta.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lblNewLabel_1, "cell 1 10 2 1");
		
		JLabel lblNewLabel_3 = new JLabel("Insira seu e-mail:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblNewLabel_3, "cell 1 14");
		
		textField = new JTextField();
		textField.setBackground(new Color(162, 208, 255));
		contentPane.add(textField, "cell 1 16,grow");
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(32, 60, 115));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(btnNewButton, "cell 1 19,alignx center");
		
		btnNewButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			 dispose();
			 TelaEsqueciSenhaEmail telaEsqueciSenhaEmail = new TelaEsqueciSenhaEmail();
			 telaEsqueciSenhaEmail.setVisible(true);
			 }
			});

		

	}

}

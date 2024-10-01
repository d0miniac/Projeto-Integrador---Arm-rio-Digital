package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Funcionario;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;

public class TelaMenu extends JFrame {

	private JPanel contentPane;
	public JLabel nome;

	/**
	 * Create the frame.
	 * @param f 
	 */
	public TelaMenu(Funcionario f) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel menu = new  ImagePanel("src/img/backgroundFundo.png");
		panel.add(menu, BorderLayout.CENTER);
		
		JButton btnNewButton_1 = new JButton("2222");
		menu.add(btnNewButton_1);
		
		JPanel barra = new  ImagePanel("src/img/azulr.png");
		contentPane.add(barra, BorderLayout.NORTH);
		barra.setLayout(new MigLayout("", "[69px][53px][82px]", "[23px]"));
		
		JButton btnNewButton = new JButton("111111");
		barra.add(btnNewButton, "cell 0 0,alignx left,aligny top");
		
		JLabel saudacao = new JLabel("Bem vindo!");
		saudacao.setFont(new Font("Tahoma", Font.PLAIN, 25));
		saudacao.setForeground(new Color(255, 255, 255));
		barra.add(saudacao, "cell 1 0,alignx left,aligny center");
		
		nome = new JLabel(f.getNome());
		nome.setForeground(new Color(255, 255, 255));
		barra.add(nome, "cell 2 0,alignx left");
		
	}

}

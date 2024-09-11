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

public class CadastroContas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroContas frame = new CadastroContas();
					frame.setVisible(true);
					frame.setSize(1215,735);
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
		setBounds(100, 100, 449, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		ImagePanel panel = new ImagePanel("img/background3.png");
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[620px:n][700px:n]", "[grow]"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(243, 244, 240));
		panel.add(panel_1, "cell 1 0,grow");
		panel_1.setLayout(new MigLayout("", "[][]", "[]"));
		
	}
	
	
	
	
}

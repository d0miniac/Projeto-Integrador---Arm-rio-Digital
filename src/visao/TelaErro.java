
package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaErro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaErro frame = new TelaErro("Algo está errado");
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
	public TelaErro(String mensagem) {
		setTitle("Tela de Erro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 220);
		
		

		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(243, 244, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5,   5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[50px][]", "[73px][][][73px]"));
		
		JLabel lblNewLabel = new JLabel(mensagem);
		lblNewLabel.setBackground(new Color(243, 244, 240));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, "cell 1 0,grow");
		
		JButton btnNewButton = new JButton("Tentar novamente");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(243, 244, 240));
		btnNewButton.setBackground(new Color(30, 62, 115));
		contentPane.add(btnNewButton, "cell 1 2,alignx center");
	}

}

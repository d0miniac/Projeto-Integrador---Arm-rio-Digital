
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
					TelaErro frame = new TelaErro();
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
	public TelaErro() {
		setTitle("Tela de Erro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 292, 158);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(243, 244, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5,   5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][]", "[73px][73px]"));
		
		JLabel lblNewLabel = new JLabel("Erro, algo está errado");
		lblNewLabel.setBackground(new Color(243, 244, 240));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, "cell 2 0,alignx center,aligny center");
		
		JButton btnNewButton = new JButton("Tentar Novamente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(243, 244, 240));
		btnNewButton.setBackground(new Color(0, 151, 178));
		contentPane.add(btnNewButton, "cell 2 1,alignx center");
	}

}

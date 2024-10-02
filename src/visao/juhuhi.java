package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class juhuhi extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					juhuhi frame = new juhuhi();
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
	public juhuhi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][]", "[][]"));
		
		JLabel lblNewLabel = new JLabel("New label");
		contentPane.add(lblNewLabel, "cell 0 0");
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		contentPane.add(lblNewLabel_1, "cell 1 0");
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		contentPane.add(lblNewLabel_2, "cell 2 0");
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		contentPane.add(lblNewLabel_3, "cell 0 1");
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		contentPane.add(lblNewLabel_4, "cell 1 1");
		
		JButton btnNewButton = new JButton("New button");
		contentPane.add(btnNewButton, "cell 2 1,grow");
	}

}

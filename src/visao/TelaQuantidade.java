package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class TelaQuantidade extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaQuantidade frame = new TelaQuantidade();
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
	public TelaQuantidade() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 259, 232);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][]", "[][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Quantidade");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, "cell 0 3 3 1,alignx center");
		
		JButton btnNewButton = new JButton("-");
		contentPane.add(btnNewButton, "cell 0 4");
		
		JLabel lblQuantidade = new JLabel("0");
		contentPane.add(lblQuantidade, "cell 1 4");
		
		JButton btnNewButton_1 = new JButton("+");
		contentPane.add(btnNewButton_1, "cell 2 4");
	}

}

package visao;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Produto;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaQuantidade extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int quantidade;
	private JLabel lblQuantidade;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaQuantidade frame = new TelaQuantidade(Produto p);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public TelaQuantidade(Produto p) {
		
		quantidade=0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 319, 232);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][][][][grow]", "[][][][][][][]"));
		
		ImageIcon imageIcon = new ImageIcon(p.getFoto());
		Image image = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		JLabel lblFoto = new JLabel("");
		lblFoto.setIcon(new ImageIcon(image));
		contentPane.add(lblFoto, "cell 1 0 3 3,alignx center,aligny center");
		
		JLabel label = new JLabel("Quantidade");
		contentPane.add(label, "cell 1 3 3 1,alignx center");
		
		JButton btnMenos = new JButton("-");
		btnMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(quantidade>0) {
					quantidade--;
					lblQuantidade.setText(String.valueOf(quantidade));
				}
				else {
					System.out.println("Não dá pra ser menos que 0");
				}
			}
		});
		contentPane.add(btnMenos, "cell 1 4");
		
		lblQuantidade = new JLabel("0");
		lblQuantidade.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblQuantidade, "cell 2 4");
		
		JButton btnMais = new JButton("+");
		btnMais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(quantidade<p.getQuantidade()) {
					quantidade++;
					lblQuantidade.setText(String.valueOf(quantidade));
				}
				else {
					System.out.println("Esse é o máximo");
				}
			
			}
		});
		contentPane.add(btnMais, "cell 3 4");
		
		JButton btnNewButton_2 = new JButton("ADICIONAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCarrinho carrinho = new TelaCarrinho();
				carrinho.setVisible(true);
				//c.adicionar(item);
//				dao.adicionar(item);
			}
		});
		contentPane.add(btnNewButton_2, "cell 1 5 3 1,alignx center");
	}

}

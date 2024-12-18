package visao;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Carrinho;
import modelo.ItemVenda;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class TelaCarrinho extends JFrame {

	private JPanel contentPane;
	private Carrinho carrinho;
	ArrayList<ItemVenda> listaItens;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaCarrinho frame = new TelaCarrinho();
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
	public TelaCarrinho(Carrinho c){
		
		listaItens = new ArrayList<>();
		listaItens = c.getItens();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("Voltar");
		panel.add(btnNewButton);
		for (ItemVenda item : listaItens) {
			JLabel lblItem = new JLabel(item.getNome());
			contentPane.add(lblItem);
		}
	}

}

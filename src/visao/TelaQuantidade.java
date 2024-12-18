package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Carrinho;
import modelo.ItemVenda;
import modelo.Produto;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.mail.FetchProfile.Item;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaQuantidade extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int quantidade;
	private JLabel lblQuantidade;
	private Item item;
	private Carrinho carrinho;
	private ArrayList<ItemVenda> itens;

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
		setBounds(100, 100, 319, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][][][grow]", "[][][][][][][][][]"));
		
		ImageIcon imageIcon = new ImageIcon(p.getFoto());
		Image image = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		
		JLabel lblNewLabel = new JLabel(p.getCategoria()+" "+p.getMarca()+" "+p.getCor()+" "+p.getTamanho());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, "cell 1 1 3 1,alignx center");
		JLabel lblFoto = new JLabel("");
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto.setIcon(new ImageIcon(image));
		lblFoto.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
		contentPane.add(lblFoto, "cell 1 2 3 3,alignx center,aligny center");
		
		JLabel label = new JLabel("Quantidade");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label, "cell 1 5 3 1,alignx center");
		
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
		contentPane.add(btnMenos, "cell 1 6,alignx center");
		
		lblQuantidade = new JLabel("0");
		lblQuantidade.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblQuantidade, "cell 2 6,alignx center");
		
		JButton btnNewButton_2 = new JButton("ADICIONAR");
		
		
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
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				ItemVenda item = new ItemVenda();
				if(p.getFoto()==null) {
					item.setFoto("abcd");
				}
				else {
					item.setFoto(p.getFoto());
				}
				
				
				item.setNome(p.getCategoria()+" "+p.getMarca()+" "+p.getCor()+" "+p.getTamanho());
				item.setQuantidade(quantidade);
				if(carrinho==null  ) {
					carrinho=new Carrinho();
				}
				
				System.out.println(item.getNome());
				System.out.println(item.getQuantidade());
				System.out.println(item.getFoto());
				carrinho.adicionar(item);
				
				
				TelaCarrinho tela = new TelaCarrinho(carrinho);
				tela.setVisible(true);
				//c.adicionar(item);
//				dao.adicionar(item);
			}
		});
		contentPane.add(btnMais, "cell 3 6,alignx center");
		contentPane.add(btnNewButton_2, "cell 1 7 3 1,alignx center");
	}

}

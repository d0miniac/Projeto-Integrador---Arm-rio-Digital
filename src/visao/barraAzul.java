package visao;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class barraAzul extends ImagePanel {

	/**
	 * Create the panel.
	 */
	public barraAzul(String nomeImagem) {
		super(nomeImagem);
		setLayout(new MigLayout("", "[center][][][]", "[][][][][]"));
		
		JLabel msg = new JLabel("Bem vindo(a)!");
		msg.setFont(new Font("Tahoma", Font.BOLD, 30));
		msg.setForeground(new Color(255, 255, 255));
		add(msg, "cell 3 3");
		
		JLabel img = new JLabel("IMAGEM");
		add(img, "cell 1 4");
		
		JLabel nome = new JLabel("Nome do Usuário");
		nome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nome.setForeground(new Color(255, 255, 255));
		add(nome, "cell 3 4");

		//JPanel barra = new ImagePanel("src/img/azulr.png");
		setLayout(new MigLayout("", "[69px][53px][82px]", "[23px]"));

	}

}

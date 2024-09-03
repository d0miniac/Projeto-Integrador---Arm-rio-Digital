package visao;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class ccc extends JFrame {
	
	public static void main(String[] args) {
		ccc c = new ccc();
		c.setVisible(true);;
	}
	public ccc() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		

		ImagePanel panel = new ImagePanel("src/img/aaa.png");
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][][][][][][][][][][][][][]", "[][][][][][][]"));
		// TODO Auto-generated constructor stub
	}

}

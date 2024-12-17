package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TelaErro extends JDialog {
	private static final long serialVersionUID = 1L;
	int resposta;

	/**
	 * @wbp.parser.constructor
	 */
	public TelaErro(String mensagem, int tipo) {
		setTitle("Mensagem");
		setModal(true);
		setSize(350,200);
		setLocationRelativeTo(null);
		setResizable(false);

		JPanel painel = new JPanel();
		painel.setLayout(new BorderLayout());
		getContentPane().add(painel);

		JLabel lblMensagem = new JLabel(mensagem, SwingConstants.CENTER);
		painel.add(lblMensagem, BorderLayout.CENTER);

		String iconeURL;
		switch (tipo) {
		case 0:
			iconeURL = "/img/erro.png";
			lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconeURL)));
			break;
		case 1:
			iconeURL = "/img/info.png";
			lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconeURL)));
			break;
		case 2:
			iconeURL = "/img/alerta.png";
			lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconeURL)));
			break;
		case 3:
			iconeURL = "/img/sucesso.png";
			lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconeURL)));
			break;
		case 10:
			iconeURL = "/img/armariodigital.png";
			lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconeURL)));
			break;
		}
		
		JPanel painelSul = new JPanel(new FlowLayout(FlowLayout.CENTER,20,10));
		painelSul.add(new JPanel());
		JButton btOk = new JButton("Ok");
		btOk.setForeground(new Color(0,0,0));
		btOk.setBackground(new Color(211, 211, 211));
		btOk.setPreferredSize(new Dimension(100,30));
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}});
		
		painelSul.add(btOk);
		painelSul.add(new JPanel());
		painelSul.setBorder(new EmptyBorder(10,10,10,10));
		painel.add(painelSul,BorderLayout.SOUTH);
		
		getRootPane().setDefaultButton(btOk);
		setVisible(true);
	}
	
	public TelaErro(String mensagem) {
        setTitle("Confirmação");
        setModal(true);
        setSize(350, 200);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        getContentPane().add(painel);

        JLabel lblMensagem = new JLabel(mensagem, SwingConstants.CENTER);
        painel.add(lblMensagem, BorderLayout.CENTER);
        lblMensagem.setIcon(new ImageIcon(getClass().getResource("/img/alerta.png")));

        JPanel painelSul = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton btSim = new JButton("Sim");
        btSim.setPreferredSize(new Dimension(100, 30));
        btSim.setForeground(new Color(0,0,0));
		btSim.setBackground(new Color(211, 211, 211));
        btSim.addActionListener(e -> {
            resposta = 0; 
            setVisible(false);
        });

        JButton btNao = new JButton("Não");
        btNao.setPreferredSize(new Dimension(100, 30));
        btNao.setForeground(new Color(0,0,0));
		btNao.setBackground(new Color(211, 211, 211));
        btNao.addActionListener(e -> {
            resposta = 1;
            setVisible(false);
        });

        painelSul.add(btSim);
        painelSul.add(btNao);
        painelSul.setBorder(new EmptyBorder(10, 10, 10, 10));
        painel.add(painelSul, BorderLayout.SOUTH);

        setVisible(true);
    }

	

	public int getResposta() {
		return resposta;
	}

}

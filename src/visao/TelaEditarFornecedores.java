package visao;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import modelo.Fornecedor;
import controle.FornecedorDAO;

public class TelaEditarFornecedores extends JFrame {

    private JPanel contentPane;
    private JTextField txtID;
    private JTextField txtNomeFornecedor;
    private JTextField txtNomeContato;
    private JTextField txtEmail;
    private JTextField txtTelefone;
    private Fornecedor fornecedor;

    public TelaEditarFornecedores(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
        setTitle("Alteração de Fornecedor");
        contentPane = new JPanel();
        contentPane.setLayout(new MigLayout("", "[grow]", "[70px][100px][100px][200px]"));
        setContentPane(contentPane);

        // Cabeçalho com botão de voltar
        JPanel vazio = new JPanel();
        vazio.setBackground(new Color(255, 0, 0));
        contentPane.add(vazio, "cell 0 0,grow");
        vazio.setOpaque(false);

        JLabel lblVoltar = new JLabel("");
        lblVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblVoltar.setIcon(new ImageIcon(TelaEditarFornecedores.class.getResource("/img/de-volta.png")));
        lblVoltar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TelaFornecedores tela = new TelaFornecedores();
                dispose();
                tela.setVisible(true);
            }
        });
        vazio.add(lblVoltar);

        // Título e campos do topo
        JPanel topo = new JPanel();
        topo.setBorder(new MatteBorder(0, 0, 5, 0, new Color(32, 60, 115, 124)));
        topo.setBackground(new Color(0, 128, 255));
        contentPane.add(topo, "cell 0 1,grow");
        topo.setOpaque(false);
        topo.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[][]"));

        JLabel lblID = new JLabel("ID Fornecedor");
        lblID.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblID.setForeground(Color.WHITE);
        topo.add(lblID, "flowx,cell 0 0,alignx center");

        txtID = new JTextField();
        txtID.setText(String.valueOf(fornecedor.getIdFornecedor()));
        txtID.setEnabled(false);
        topo.add(txtID, "cell 0 0,alignx center");
        txtID.setColumns(10);

        // Nome do Fornecedor
        JLabel lblNomeFornecedor = new JLabel("Nome do Fornecedor");
        lblNomeFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNomeFornecedor.setForeground(Color.WHITE);
        topo.add(lblNomeFornecedor, "flowx,cell 1 0,alignx center");

        txtNomeFornecedor = new JTextField();
        txtNomeFornecedor.setText(fornecedor.getNomeFornecedor());
        topo.add(txtNomeFornecedor, "cell 1 0,alignx center");
        txtNomeFornecedor.setColumns(10);

        // Nome de Contato
        JLabel lblNomeContato = new JLabel("Nome do Contato");
        lblNomeContato.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNomeContato.setForeground(Color.WHITE);
        topo.add(lblNomeContato, "flowx,cell 2 0,alignx center");

        txtNomeContato = new JTextField();
        txtNomeContato.setText(fornecedor.getNomeCtt());
        topo.add(txtNomeContato, "cell 2 0,alignx center");
        txtNomeContato.setColumns(10);

        // Campos de e-mail e telefone
        JPanel meio = new JPanel();
        meio.setBackground(new Color(255, 255, 255));
        contentPane.add(meio, "cell 0 2,grow");
        meio.setLayout(new MigLayout("", "[grow][grow]", "[][]"));

        JLabel lblEmail = new JLabel("E-mail");
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblEmail.setForeground(Color.BLACK);
        meio.add(lblEmail, "flowx,cell 0 0,alignx center");

        txtEmail = new JTextField();
        txtEmail.setText(fornecedor.getEmail());
        meio.add(txtEmail, "cell 0 0,alignx center");
        txtEmail.setColumns(10);

        JLabel lblTelefone = new JLabel("Telefone");
        lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTelefone.setForeground(Color.BLACK);
        meio.add(lblTelefone, "flowx,cell 1 0,alignx center");

        txtTelefone = new JTextField();
        txtTelefone.setText(fornecedor.getTelefone());
        meio.add(txtTelefone, "cell 1 0,alignx center");
        txtTelefone.setColumns(10);

        // Botão de Alterar
        JPanel inferior = new JPanel();
        inferior.setBackground(new Color(128, 0, 255));
        contentPane.add(inferior, "cell 0 3,grow");
        inferior.setOpaque(false);

        JButton btnAlterar = new JButton("Alterar");
        btnAlterar.setBackground(new Color(32, 60, 115));
        btnAlterar.setForeground(Color.WHITE);
        btnAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Atualizando as informações do fornecedor
                Fornecedor f = new Fornecedor();
                f.setIdFornecedor(Long.parseLong(txtID.getText()));
                f.setNomeFornecedor(txtNomeFornecedor.getText());
                f.setNomeCtt(txtNomeContato.getText());
                f.setEmail(txtEmail.getText());
                f.setTelefone(txtTelefone.getText());

                
                FornecedorDAO dao = new FornecedorDAO();
                try {
                    dao.alterarFornecedor(f);
                    JOptionPane.showMessageDialog(null, "Fornecedor alterado com sucesso!");
                    TelaFornecedores tela = new TelaFornecedores();
                    dispose();
                    tela.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao alterar fornecedor: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        inferior.add(btnAlterar);

        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Fornecedor fornecedor = new Fornecedor();
                    TelaEditarFornecedores frame = new TelaEditarFornecedores(fornecedor);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

package visao;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.border.MatteBorder;
import controle.FornecedorDAO;
import modelo.Fornecedor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;

public class TelaEditarFornecedores extends JFrame {

    private JPanel contentPane;
    private JTextField txtID;
    private JTextField textEMAIL;
    private JTextField textNOMECONTATO;
    private JTextField textNOME_FORNECEDOR; // Alterado para 'textNOME_FORNECEDOR'
    private JTextField textTELEFONE;
    private TelaFornecedores telaFornecedores;  

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaEditarFornecedores frame = new TelaEditarFornecedores(null);
                    frame.setVisible(true);
                    frame.setSize(657, 425);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TelaEditarFornecedores(TelaFornecedores telaFornecedores) {
        this.telaFornecedores = telaFornecedores;
        setResizable(false);
        setTitle("Cadastro de Fornecedores");
        contentPane = new ImagePanel("src/img/bgEditarFornecedores.png");
        setContentPane(contentPane);
        contentPane.setLayout(new MigLayout("", "[grow]", "[70px][][grow][][100px][150px][150px][100px]"));

        JPanel vazio = new JPanel();
        FlowLayout flowLayout = (FlowLayout) vazio.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        vazio.setBackground(new Color(255, 0, 0));
        contentPane.add(vazio, "cell 0 0,grow");
        vazio.setOpaque(false);

        JLabel lblNewLabel_7 = new JLabel("");
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ImageIcon seta = new ImageIcon(TelaEditarFornecedores.class.getResource("/img/de-volta.png"));
        Image voltar = seta.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        lblNewLabel_7.setIcon(new ImageIcon(voltar));
        vazio.add(lblNewLabel_7);
        lblNewLabel_7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TelaFornecedores tela = new TelaFornecedores();
                dispose();
                tela.setSize(1215, 850);
                tela.setLocationRelativeTo(null);
                tela.setVisible(true);
            }
        });

        JLabel lblNewLabel = new JLabel("Informações do fornecedor");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setForeground(new Color(153, 162, 209));
        contentPane.add(lblNewLabel, "cell 0 3");

        JPanel topo = new JPanel();
        topo.setBorder(new MatteBorder(0, 0, 5, 0, new Color(32, 60, 115, 124)));
        contentPane.add(topo, "cell 0 5,grow");
        topo.setOpaque(false);
        topo.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[]"));

        JLabel lblID = new JLabel("ID");
        topo.add(lblID, "flowx,cell 0 0,alignx center");

        txtID = new JTextField();
        topo.add(txtID, "cell 0 0,alignx center");
        txtID.setColumns(10);

        JLabel lblEMAIL = new JLabel("EMAIL");
        topo.add(lblEMAIL, "flowx,cell 2 0,alignx center");

        JLabel lblNOME_FORNECEDOR = new JLabel("NOME DO FORNECEDOR");
        topo.add(lblNOME_FORNECEDOR, "flowx,cell 4 0,alignx center");

        textEMAIL = new JTextField();
        textEMAIL.setColumns(10);
        topo.add(textEMAIL, "cell 2 0");

        textNOME_FORNECEDOR = new JTextField(); 
        topo.add(textNOME_FORNECEDOR, "cell 4 0");
        textNOME_FORNECEDOR.setColumns(10);

        JPanel topo_1 = new JPanel();
        topo_1.setOpaque(false);
        topo_1.setBorder(new MatteBorder(0, 0, 5, 0, new Color(32, 60, 115, 124)));
        contentPane.add(topo_1, "cell 0 6,grow");
        topo_1.setLayout(new MigLayout("", "[70px][100px][][][70px][70px][][][][][][][][]", "[][]"));

        JLabel lblNOMECONTATO = new JLabel("NOME P/ CONTATO");
        topo_1.add(lblNOMECONTATO, "cell 1 1,alignx trailing");

        textNOMECONTATO = new JTextField();
        textNOMECONTATO.setColumns(10);
        topo_1.add(textNOMECONTATO, "cell 3 1");

        JLabel lblTELEFONE = new JLabel("TELEFONE");
        topo_1.add(lblTELEFONE, "cell 6 1");

        textTELEFONE = new JTextField();
        topo_1.add(textTELEFONE, "cell 7 1,alignx center");
        textTELEFONE.setColumns(10);

        JPanel inferior = new JPanel();
        inferior.setBackground(new Color(128, 0, 255));
        contentPane.add(inferior, "cell 0 7,grow");
        inferior.setOpaque(false);
        inferior.setLayout(new MigLayout("", "[100px][100px][][grow][][grow][]", "[][][][][][]"));

        JButton btnCadastrar = new JButton("CADASTRAR");
        btnCadastrar.setBackground(new Color(32, 60, 115));
        btnCadastrar.setForeground(Color.WHITE);
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	Fornecedor fornecedor = new Fornecedor();
            	fornecedor.setEmail(textEMAIL.getText());
            	fornecedor.setNomeFornecedor(textNOME_FORNECEDOR.getText());
            	fornecedor.setNomeCtt(textNOMECONTATO.getText()); 
            	fornecedor.setTelefone(textTELEFONE.getText());
            	
                FornecedorDAO dao = new FornecedorDAO();
                int resultado = dao.cadastrarFornecedor(fornecedor);
                if (resultado == 1) {
                   
                    System.out.println("Fornecedor cadastrado com sucesso!");
                   
                    limparCampos();
                } else {
                    System.out.println("Erro ao cadastrar fornecedor.");
                }
            }
        });
        inferior.add(btnCadastrar, "cell 0 0");
        
        JButton btnCancelar = new JButton("CANCELAR");
        btnCancelar.setForeground(new Color(255, 255, 255));
        btnCancelar.setBackground(new Color(32, 60, 115));
        btnCancelar.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
        	 dispose();
        	 TelaFornecedores telaFornecedores = new TelaFornecedores();
        	 telaFornecedores.setVisible(true);
                
                 
            }
        });
        inferior.add(btnCancelar, "flowx,cell 1 0");
        
        JButton btnExcluir = new JButton("EXCLUIR");
        btnExcluir.setForeground(new Color(255, 255, 255));
        btnExcluir.setBackground(new Color(255, 0, 0));
        inferior.add(btnExcluir, "cell 1 0");
        btnExcluir = new JButton("EXCLUIR");
        btnExcluir.setForeground(new Color(255, 255, 255));
        btnExcluir.setBackground(new Color(255, 0, 0));
        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Pega o ID do fornecedor a ser excluído
                String idText = txtID.getText();

                // Verifica se o ID foi preenchido
                if (idText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha o ID do fornecedor para excluir.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    // Converte o ID para um inteiro (caso o usuário tenha inserido um valor válido)
                    int id = Integer.parseInt(idText);

                    // Cria uma instância do FornecedorDAO e chama o método para excluir o fornecedor
                    FornecedorDAO dao = new FornecedorDAO();
                    int resultado = dao.excluirFornecedor(id);  // Chama o método de exclusão no DAO

                    if (resultado == 1) {
                        JOptionPane.showMessageDialog(null, "Fornecedor excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        limparCampos();  // Limpa os campos após a exclusão
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao excluir fornecedor.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido. Por favor, insira um ID numérico válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        
    }

    private void limparCampos() {
        txtID.setText("");
        textEMAIL.setText("");
        textNOME_FORNECEDOR.setText("");
        textNOMECONTATO.setText("");
        textTELEFONE.setText("");
    }
}
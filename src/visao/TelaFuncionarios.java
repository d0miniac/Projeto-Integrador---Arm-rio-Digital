package visao;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import br.com.loja.assistec.controller.UsuarioController;
import br.com.loja.assistec.model.Usuario;
import controle.FuncionarioController;
import net.miginfocom.swing.MigLayout;

public class TelaFuncionarios extends JFrame {

    private JPanel contentPane;
    private JTextField txtFiltro;
    private JTable table;
    private ArrayList<Usuario> listaUsuarios;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaFuncionarios frame = new TelaFuncionarios();
                    frame.setVisible(true);
                    frame.setSize(1215, 850);
                    frame.setLocationRelativeTo(null);
                    frame.setResizable(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public TelaFuncionarios() throws SQLException {
        setTitle("Funcionarios");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 841, 545);
        contentPane = new ImagePanel("src/img/bgFuncionarios.png");
        contentPane.setBackground(new Color(243, 244, 240));
        setContentPane(contentPane);
        contentPane.setLayout(new MigLayout("", "[grow,fill]", "[120px][grow]"));
        
        JPanel panelVazio = new JPanel();
        panelVazio.setBackground(new Color(0, 0, 0));
        panelVazio.setOpaque(false);
        contentPane.add(panelVazio, "cell 0 0,grow");
        panelVazio.setLayout(null);
        
        JPanel panelComponentes = new JPanel();
        panelComponentes.setBackground(new Color(255, 0, 0));
        panelComponentes.setOpaque(false);
        contentPane.add(panelComponentes, "cell 0 1,grow");
        panelComponentes.setLayout(new MigLayout("", "[][][][][grow][]", "[][][grow]"));
        
        txtFiltro = new JTextField();
        txtFiltro.setUI(new HintTextFieldUI("Pesquisa"));
        txtFiltro.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtFiltro.setBorder(new LineBorder(new Color(123, 150, 212), 2, true));
        panelComponentes.add(txtFiltro, "cell 4 0,alignx left");
        txtFiltro.setColumns(90);
        txtFiltro.setPreferredSize(new Dimension(450,45));
        
        JButton btnAdd = new JButton("Adicionar");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                TelaCadastroFuncionario tela = new TelaCadastroFuncionario();
                tela.setVisible(true);
                tela.setSize(657, 425);
                tela.setLocationRelativeTo(null);
            }
        });
        btnAdd.setBackground(new Color(243, 244, 240));
        btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 24));
        btnAdd.setMinimumSize(new Dimension(150, 30));
        btnAdd.setMaximumSize(new Dimension(150, 30));
        btnAdd.setBorder(new LineBorder(new Color(123, 150, 212), 2, true));
        panelComponentes.add(btnAdd, "cell 4 1,alignx left,growy");
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new LineBorder(new Color(123, 150, 212), 2, true));
        panelComponentes.add(scrollPane, "cell 4 2,grow");
        
        JLabel lblSeta = new JLabel("");
        lblSeta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblSeta.setIcon(new ImageIcon(TelaCadastroFuncionario.class.getResource("/img/de-volta.png")));
        lblSeta.setBounds(0, 0, 110, 100);
        ImageIcon seta = new ImageIcon(TelaCadastroFuncionario.class.getResource("/img/de-volta.png"));
        Image voltar = seta.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        lblSeta.setIcon(new ImageIcon(voltar));
        panelVazio.add(lblSeta);
        lblSeta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Voltar para o menu principal ou outra tela
            }
        });
        
        // Inicializando o controlador e a lista de usuários
        FuncionarioController usuarioController = new FuncionarioController();
        listaUsuarios = usuarioController.listarUsuarios(); // Obtendo lista de usuários do banco
        
        // Criando e configurando a tabela
        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));
        table.setGridColor(new Color(0,0,0));
        table.setBackground(new Color(123, 150, 212));
        table.setForeground(new Color(255,255,255));
        
        // Inicializando a tabela com dados
        atualizarTabela();
        
        theader();
        scrollPane.setViewportView(table);
    }
    
    private void theader() {
        JTableHeader thead = table.getTableHeader();
        thead.setForeground(new Color(123, 150, 212));
        thead.setBackground(new Color(255, 255, 255));
        thead.setFont(new Font("Tahoma", Font.PLAIN, 20));
    }
    
    // Método para atualizar a tabela com a lista de usuários
    protected void atualizarTabela() {
        // Modelo de dados da tabela
        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[][] {},
                new String[] {
                    "ID", "Nome", "Telefone", "Login", "Perfil"
                }
        );
        
        // Preenchendo a tabela com os dados de usuários
        for (Usuario usuario : listaUsuarios) {
            tableModel.addRow(new Object[] {
                usuario.getIduser(),
                usuario.getNome(),
                usuario.getFone(),
                usuario.getLogin(),
                usuario.getPerfil()
            });
        }
        
        table.setModel(tableModel);
    }
    
    // Método para cadastrar novo usuário (se necessário)
    public void cadastrar(Usuario usuario) {
        listaUsuarios.add(usuario);
        atualizarTabela();
    }
}

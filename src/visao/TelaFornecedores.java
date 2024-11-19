package visao;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import controle.FornecedorController;
import controle.FornecedorDAO;
import controle.ProdutoDAO;
import modelo.Fornecedor;
import modelo.FornecedorTableModel;
import modelo.ProdutoTableModel;
import net.miginfocom.swing.MigLayout;

public class TelaFornecedores extends JFrame {

    private JPanel contentPane;
    private JTextField txtFiltro;
    private JTable tableFornecedores;
    private FornecedorTableModel ftm;
    private ArrayList<Fornecedor> listaFornecedores;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TelaFornecedores telaFornecedores = new TelaFornecedores();
                telaFornecedores.setVisible(true);
                telaFornecedores.setSize(1215, 850);
                telaFornecedores.setLocationRelativeTo(null);
                telaFornecedores.setResizable(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public TelaFornecedores() {
        listaFornecedores = new ArrayList<>();
		FornecedorDAO f = new FornecedorDAO();
		try {
			listaFornecedores = f.selecionarFornecedores();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        setTitle("Fornecedores");
        setSize(1215, 850);
		setLocationRelativeTo(null);
		setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new ImagePanel("src/img/bgTelaFornecedores.png");
        contentPane.setBackground(new Color(243, 244, 240));
        setContentPane(contentPane);
        contentPane.setLayout(new MigLayout("", "[grow,fill]", "[120px][grow]"));

        JPanel panelVazio = new JPanel();
        panelVazio.setOpaque(false);
        contentPane.add(panelVazio, "cell 0 0,grow");
        panelVazio.setLayout(null);

        JPanel panelComponentes = new JPanel();
        panelComponentes.setOpaque(false);
        contentPane.add(panelComponentes, "cell 0 1,grow");
        panelComponentes.setLayout(new MigLayout("", "[][grow][]", "[][][grow]"));

        txtFiltro = new JTextField();
        txtFiltro.setUI(new HintTextFieldUI("Pesquisa"));
        txtFiltro.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtFiltro.setBorder(new LineBorder(new Color(123, 150, 212), 2, true));
        panelComponentes.add(txtFiltro, "cell 1 0,alignx left");
        txtFiltro.setColumns(90);
        txtFiltro.setPreferredSize(new Dimension(450, 45));

        JButton btnAdd = new JButton("Adicionar");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                TelaCadastroFornecedores tela = new TelaCadastroFornecedores(TelaFornecedores.this);
                tela.setVisible(true);
                tela.setSize(657, 425);
                tela.setLocationRelativeTo(null);
            }
        });
        
        JButton btnUpdate = new JButton("Alterar");
        btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 24));
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = tableFornecedores.getSelectedRow(); 
                Long id = (Long) tableFornecedores.getModel().getValueAt(i, 0);
                
                Fornecedor fornecedor = listaFornecedores.get(i);
               
                TelaEditarFornecedores tela = new TelaEditarFornecedores(fornecedor);
                dispose();
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
        panelComponentes.add(btnAdd, "flowx,cell 1 1,alignx left,growy");
        
        
        btnUpdate.setBackground(new Color(243, 244, 240));
        btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 24));
        btnUpdate.setMinimumSize(new Dimension(150, 30));
        btnUpdate.setMaximumSize(new Dimension(150, 30));
        btnUpdate.setBorder(new LineBorder(new Color(123, 150, 212), 2, true));
        panelComponentes.add(btnUpdate, "cell 1 1,alignx left,growy");

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new LineBorder(new Color(123, 150, 212), 2, true));
        panelComponentes.add(scrollPane, "cell 1 2,grow");

        try {
            carregarFornecedores();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ftm = new FornecedorTableModel(listaFornecedores);
        tableFornecedores = new JTable(ftm);
        tableFornecedores.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tableFornecedores.setBackground(new Color(123, 150, 212));
        scrollPane.setViewportView(tableFornecedores);
        
   
        JButton btnDelete = new JButton("Deletar");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = tableFornecedores.getSelectedRow();
                Long id = (Long) tableFornecedores.getModel().getValueAt(i, 0);
                try {
                	f.excluirFornecedor(id);
					listaFornecedores = f.selecionarFornecedores();
					ftm = new FornecedorTableModel(listaFornecedores);
					tableFornecedores.setModel(ftm);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
        
                btnDelete.setBackground(new Color(243, 244, 240));
                btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 24));
                btnDelete.setMinimumSize(new Dimension(150, 30));
                btnDelete.setMaximumSize(new Dimension(150, 30));
                btnDelete.setBorder(new LineBorder(new Color(123, 150, 212), 2, true));
                panelComponentes.add(btnDelete, "cell 1 1");

        JLabel lblSeta = new JLabel();
        lblSeta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblSeta.setIcon(new ImageIcon(new ImageIcon(TelaCadastroProdutos.class.getResource("/img/de-volta.png"))
                .getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
        lblSeta.setBounds(0, 0, 110, 100);
        panelVazio.add(lblSeta);

        lblSeta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TelaMenu tela = new TelaMenu();
                dispose();
                tela.setVisible(true);
            }
        });

        theader();
    }

    private void theader() {
        JTableHeader thead = tableFornecedores.getTableHeader();
        thead.setForeground(new Color(123, 150, 212));
        thead.setBackground(new Color(255, 255, 255));
        thead.setFont(new Font("Tahoma", Font.PLAIN, 20));
    }

    public void atualizarTabela() {
        ftm.fireTableDataChanged();
    }

    public void adicionarFornecedor(Fornecedor fornecedor) {
        listaFornecedores.add(fornecedor);
        System.out.println("Fornecedor adicionado: " + fornecedor);
        atualizarTabela();
    }

    private void carregarFornecedores() throws SQLException {
        FornecedorController controller = new FornecedorController();
        listaFornecedores = controller.listarFornecedores();
        ftm = new FornecedorTableModel(listaFornecedores);
    }
}

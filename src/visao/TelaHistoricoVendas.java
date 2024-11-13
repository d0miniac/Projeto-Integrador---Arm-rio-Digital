package visao;

<<<<<<< HEAD
import java.awt.Color;
import java.awt.Cursor;
=======
<<<<<<< Updated upstream
>>>>>>> origin/ajustetelahistorico
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
=======
=======
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
>>>>>>> Stashed changes
>>>>>>> origin/ajustetelahistorico
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import net.miginfocom.swing.MigLayout;

public class TelaHistoricoVendas extends JFrame {
<<<<<<< Updated upstream

    private JPanel contentPane;
    private JTable table;
    private JComboBox<String> comboFiltrar;
    private List<Object[]> vendas;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaHistoricoVendas frame = new TelaHistoricoVendas();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TelaHistoricoVendas() {
        // Configuração básica da janela
        setTitle("Histórico de Vendas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1215, 850);
        setLocationRelativeTo(null);
        setResizable(false);

        // Painel de fundo com imagem
        contentPane = new ImagePanel("src/img/bgTelaHistorico.png");
        contentPane.setBackground(new Color(243, 244, 240));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new MigLayout("", "[183px][276px][4px][422px][4px][292px]", "[120px][][][][25px][523px]"));

<<<<<<< HEAD
=======
=======
    private JPanel contentPane;
    private JTable table;
    private JComboBox<String> comboFiltrar;
    private List<Object[]> vendas;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaHistoricoVendas frame = new TelaHistoricoVendas();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TelaHistoricoVendas() {
        setTitle("HistoricoVendas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1215, 850);
        setLocationRelativeTo(null);
        setResizable(false);
        contentPane = new ImagePanel("src/img/bg.TelaHistoricoVendas.png");
        contentPane.setBackground(new Color(243, 244, 240));
        setContentPane(contentPane);
        contentPane.setLayout(new MigLayout("", "[183px][276px][4px][422px][4px][292px]", "[120px][][][][25px][523px]"));

>>>>>>> origin/ajustetelahistorico
        JPanel panelVazio = new JPanel();
        panelVazio.setOpaque(false);
        contentPane.add(panelVazio, "cell 0 0,grow");
        panelVazio.setLayout(null);

        // Configuração do botão de voltar com ícone
        JLabel lblSeta = new JLabel();
        lblSeta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblSeta.setIcon(new ImageIcon(new ImageIcon(TelaCadastroProdutos.class.getResource("/img/de-volta.png"))
                .getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
        lblSeta.setBounds(0, 0, 110, 100);
        panelVazio.add(lblSeta);

        // Ação de clique para voltar ao menu principal
        lblSeta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TelaMenu tela = new TelaMenu();
                dispose();
                tela.setVisible(true);
            }
        });
<<<<<<< HEAD

        // Adicionando o filtro de categoria
        JLabel lblNewLabel = new JLabel("Filtrar");
        lblNewLabel.setForeground(new Color(30, 62, 115));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        contentPane.add(lblNewLabel, "cell 0 3 1 2,alignx center,aligny center");

        comboFiltrar = new JComboBox<>();
        comboFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        comboFiltrar.setBackground(new Color(209, 209, 233));
        contentPane.add(comboFiltrar, "cell 1 3 1 2,growx,aligny center");
        comboFiltrar.addItem("Todos");
        comboFiltrar.addItem("Camisa");
        comboFiltrar.addItem("Calça");
        comboFiltrar.addItem("Blusa");
        comboFiltrar.addItem("Jaqueta");
        comboFiltrar.addItem("Saia/Vestido");
        comboFiltrar.addItem("Bermudas/Shorts");
        comboFiltrar.addItem("Roupa Íntima");

        // Botão de busca com evento de filtro
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setBackground(new Color(32, 60, 115));
        btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPane.add(btnBuscar, "cell 3 4,alignx left,aligny top");

        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarVendas();
            }
        });

        // Configuração da tabela
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, "cell 0 5 6 1,grow");

        table = new JTable();
        table.setBackground(new Color(243, 244, 240));
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));
        scrollPane.setViewportView(table);

        // Inicialização de dados fictícios
        vendas = new ArrayList<>();
        vendas.add(new Object[]{"1", "Camisa", "Nike", "Azul", "M", "100", "R$ 150,00"});
        vendas.add(new Object[]{"2", "Calça", "Adidas", "Preta", "38", "200", "R$ 200,00"});
        vendas.add(new Object[]{"3", "Blusa", "Puma", "Vermelha", "P", "50", "R$ 180,00"});
        vendas.add(new Object[]{"4", "Jaqueta", "Puma", "Preta", "M", "50", "R$ 250,00"});
        vendas.add(new Object[]{"5", "Calça", "Nike", "Azul", "40", "100", "R$ 100,00"});
=======
                
                
                
                
                        JLabel lblNewLabel = new JLabel("Filtrar");
                        lblNewLabel.setForeground(new Color(30, 62, 115));
                        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
                        contentPane.add(lblNewLabel, "cell 0 3 1 2,alignx center,aligny center");
        
                comboFiltrar = new JComboBox<>();
                comboFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
                comboFiltrar.setBackground(new Color(209, 209, 233));
                contentPane.add(comboFiltrar, "cell 1 3 1 2,growx,aligny center");
                comboFiltrar.addItem("Todos");
                comboFiltrar.addItem("Camisa");
                comboFiltrar.addItem("Calça");
                comboFiltrar.addItem("Blusa");
                comboFiltrar.addItem("Jaqueta");
                comboFiltrar.addItem("Saia/Vestido");
                comboFiltrar.addItem("Bermudas/Shorts");
                comboFiltrar.addItem("Roupa Íntima");
                
                        JButton btnBuscar = new JButton("Buscar");
                        btnBuscar.setForeground(new Color(255, 255, 255));
                        btnBuscar.setBackground(new Color(32, 60, 115));
                        btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
                        contentPane.add(btnBuscar, "cell 3 4,alignx left,aligny top");
                        
                                btnBuscar.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        buscarVendas(); 
                                    }
                                });
                                        
                                                JScrollPane scrollPane = new JScrollPane();
                                                contentPane.add(scrollPane, "cell 0 5 6 1,grow");
                                                
                                                        table = new JTable();
                                                        table.setBackground(new Color(123, 150, 212));
                                                        table.setFont(new Font("Tahoma", Font.PLAIN, 16));
                                                        scrollPane.setViewportView(table);

        vendas = new ArrayList<>();
        vendas.add(new Object[] { "1", "Camisa", "Nike", "Azul", "M", "100", "R$ 150,00" });
        vendas.add(new Object[] { "2", "Calça", "Adidas", "Preta", "38", "200", "R$ 200,00" });
        vendas.add(new Object[] { "3", "Blusa", "Puma", "Vermelha", "P", "50", "R$ 180,00" });
        vendas.add(new Object[] { "4", "Jaqueta", "Puma", "Preta", "M", "50", "R$ 250,00" });
        vendas.add(new Object[] { "5", "Calça", "Nike", "Azul", "40", "100", "R$ 100,00" });


>>>>>>> origin/ajustetelahistorico

        atualizarTabela(vendas);
        theader();
    }

    // Método que filtra as vendas com base na categoria selecionada
    protected void buscarVendas() {
        String categoriaSelecionada = (String) comboFiltrar.getSelectedItem();
        List<Object[]> vendasFiltradas = new ArrayList<>();

        for (Object[] venda : vendas) {
            String categoria = (String) venda[1];
            if (categoriaSelecionada.equals("Todos") || categoria.equals(categoriaSelecionada)) {
                vendasFiltradas.add(venda);
            }
        }

        // Atualiza a tabela com as vendas filtradas
        atualizarTabela(vendasFiltradas);
    }

    // Atualiza a tabela com os dados fornecidos
    private void atualizarTabela(List<Object[]> dados) {
        NonEditableTableModel modelo = new NonEditableTableModel(
<<<<<<< HEAD
                dados.toArray(new Object[0][0]),
                new String[]{"ID", "Categoria", "Marca", "Cor", "Tamanho", "Quantidade", "Preço"});
=======
            dados.toArray(new Object[0][0]),
            new String[] { "ID", "Categoria", "Marca", "Cor", "Tamanho", "Quantidade", "Preço" }
        );
>>>>>>> origin/ajustetelahistorico
        table.setModel(modelo);
    }

    // Configuração de estilização do cabeçalho da tabela
    private void theader() {
        JTableHeader thead = table.getTableHeader();
        thead.setForeground(new Color(123, 150, 212));
<<<<<<< HEAD
        thead.setBackground(Color.WHITE);
        thead.setFont(new Font("Tahoma", Font.PLAIN, 20));
    }

=======
        thead.setBackground(new Color(255, 255, 255));
        thead.setFont(new Font("Tahoma", Font.PLAIN, 20));
    }
    
>>>>>>> origin/ajustetelahistorico
    private class NonEditableTableModel extends DefaultTableModel {
        public NonEditableTableModel(Object[][] data, String[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
<<<<<<< HEAD
            return false;
        }
    }
=======
            return false; 
        }
    }
>>>>>>> Stashed changes
>>>>>>> origin/ajustetelahistorico
}

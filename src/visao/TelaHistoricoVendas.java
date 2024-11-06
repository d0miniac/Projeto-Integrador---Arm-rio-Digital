package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaHistoricoVendas extends JFrame {
    private JPanel contentPane;
    private JTable table;
    private JComboBox<String> comboCategoria;
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new MigLayout("", "[][grow][][grow][]", "[][][grow]"));
        
        JButton btnVoltar = new JButton(new ImageIcon("/img/de-volta.png"));
        btnVoltar.setBackground(new Color(0, 0, 0));
        btnVoltar.setToolTipText("Voltar ao Menu");
        btnVoltar.setFocusPainted(false);
        btnVoltar.setContentAreaFilled(false);
        btnVoltar.setBorderPainted(false);
        
        contentPane.add(btnVoltar, "cell 0 0 1 2,alignx left");
        
                btnVoltar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        TelaMenu telaMenu = new TelaMenu();  
                        telaMenu.setVisible(true);
                        dispose();
                    }
                });



        JLabel lblNewLabel = new JLabel("Categoria");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        contentPane.add(lblNewLabel, "flowx,cell 1 1,alignx right");

        comboCategoria = new JComboBox<>();
        comboCategoria.setBackground(new Color(209, 209, 233));
        contentPane.add(comboCategoria, "cell 2 1,growx,wmin 200");
        comboCategoria.addItem("Todos");
        comboCategoria.addItem("Camisa");
        comboCategoria.addItem("Calça");
        comboCategoria.addItem("Blusa");
        comboCategoria.addItem("Jaqueta");
        comboCategoria.addItem("Saia/Vestido");
        comboCategoria.addItem("Bermudas/Shorts");
        comboCategoria.addItem("Roupa Íntima");

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setForeground(new Color(255, 255, 255));
        btnBuscar.setBackground(new Color(32, 60, 115));
        btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 13));
        contentPane.add(btnBuscar, "cell 3 1");

        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarVendas(); 
            }
        });

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, "cell 1 2 3 1,grow");

        table = new JTable();
        scrollPane.setViewportView(table);

        vendas = new ArrayList<>();
        vendas.add(new Object[] { "1", "Camisa", "Nike", "Azul", "M", "100", "R$ 150,00" });
        vendas.add(new Object[] { "2", "Calça", "Adidas", "Preta", "38", "200", "R$ 200,00" });
        vendas.add(new Object[] { "3", "Blusa", "Puma", "Vermelha", "P", "50", "R$ 180,00" });
        vendas.add(new Object[] { "4", "Jaqueta", "Puma", "Preta", "M", "50", "R$ 250,00" });
        vendas.add(new Object[] { "5", "Calça", "Nike", "Azul", "40", "100", "R$ 100,00" });



        atualizarTabela(vendas);
        theader();
    }

    protected void buscarVendas() {
        String categoriaSelecionada = (String) comboCategoria.getSelectedItem();
        List<Object[]> vendasFiltradas = new ArrayList<>();

        for (Object[] venda : vendas) {
            String categoria = (String) venda[1];
            if (categoriaSelecionada.equals("Todos") || categoria.equals(categoriaSelecionada)) {
                vendasFiltradas.add(venda);
            }
        }

        atualizarTabela(vendasFiltradas);
    }

    private void atualizarTabela(List<Object[]> dados) {
        NonEditableTableModel modelo = new NonEditableTableModel(
            dados.toArray(new Object[0][0]),
            new String[] { "ID", "Categoria", "Marca", "Cor", "Tamanho", "Quantidade", "Preço" }
        );
        table.setModel(modelo);
    }

    private void theader() {
        JTableHeader thead = table.getTableHeader();
        thead.setForeground(new Color(123, 150, 212));
        thead.setBackground(new Color(255, 255, 255));
        thead.setFont(new Font("Tahoma", Font.PLAIN, 14));
    }
    
    private class NonEditableTableModel extends DefaultTableModel {
        public NonEditableTableModel(Object[][] data, String[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false; 
        }
    }
}


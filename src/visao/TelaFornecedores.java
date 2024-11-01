package visao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaFornecedores extends JFrame {

    private JTable table;

    public TelaFornecedores() {
        setTitle("Fornecedores");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1215, 850);
        
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {"1", "adidas@gmail.com", "Fornecedor 1", "Juninho", "(47)999999999"},
                // Outros fornecedores serão adicionados aqui
            },
            new String[] {
                "ID", "Email", "Nome_Fornecedor", "Nome p/ contato", "Telefone" // Alterado para "Nome_Fornecedor"
            }
        ));
        
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaFornecedores();
        });
    }
}


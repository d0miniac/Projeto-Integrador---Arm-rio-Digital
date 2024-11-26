package visao;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

import controle.FuncionarioDAO;
import modelo.Funcionario;
import net.miginfocom.swing.MigLayout;

public class TelaEditarFuncionario extends JFrame {

    private JPanel contentPane;
    private JTextField txtID;
    private JTextField txtNome;
    private JTextField txtSenha;
    private JTextField txtEmail;
    private JTextField txtCpf;
    private Funcionario funcionario;
    
    
    

    public TelaEditarFuncionario(Funcionario funcionario, Funcionario func, String mensagem) {
        this.funcionario = funcionario;
        setSize(657, 425);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new ImagePanel("src/img/bgEditarFuncionarios.png");
        setContentPane(contentPane);
        contentPane.setLayout(new MigLayout("", "[grow]", "[70px][][grow][][100px][150px][150px][100px]"));
        JPanel vazio = new JPanel();
        vazio.setOpaque(false);
        contentPane.add(vazio, "cell 0 0,alignx left,growy");

        // ... (Outros componentes da interface)

        JPanel inferior = new JPanel();
        inferior.setOpaque(false);
        contentPane.add(inferior, "cell 0 7,grow");
        inferior.setLayout(new MigLayout("", "[100px][100px][grow][grow][]", "[][][][][][][]"));

        JButton btnAlterar = new JButton("Alterar");
        btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnAlterar.setBackground(new Color(32, 60, 115));
        btnAlterar.setForeground(Color.WHITE);
        btnAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Verificar se algum campo está vazio
                if (txtNome.getText().isEmpty() || txtEmail.getText().isEmpty() ||
                    txtSenha.getText().isEmpty() || txtCpf.getText().isEmpty()) {
                    mostrarMensagemErro("Todos os campos devem ser preenchidos.");
                    return;  // Não prosseguir com a alteração se algum campo estiver vazio
                }

                // Atualiza as informações do funcionário
                funcionario.setNome(txtNome.getText());
                funcionario.setEmail(txtEmail.getText());
                funcionario.setSenha(txtSenha.getText());
                funcionario.setCpf(txtCpf.getText());
                FuncionarioDAO dao = new FuncionarioDAO();
                try {
                    dao.alterarFuncionario(funcionario);
                    JOptionPane.showMessageDialog(null, "Funcionario alterado com sucesso!");
                    TelaFuncionarios tela = new TelaFuncionarios(func, mensagem);
                    dispose();
                    tela.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao alterar funcionario: " + ex.getMessage(), "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        inferior.add(btnAlterar, "cell 0 4,growx");

        // Botão de cancelar
        JButton btnCancelar = new JButton("CANCELAR");
        btnCancelar.setBackground(new Color(255, 0, 0));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaFuncionarios tela;
                try {
                    tela = new TelaFuncionarios(func,mensagem);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                dispose();
                setVisible(true);
            }
        });
        inferior.add(btnCancelar, "cell 1 4,grow");

        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Função para exibir a tela de erro
    private void mostrarMensagemErro(String mensagem) {
        TelaErro telaErro = new TelaErro(mensagem);
        telaErro.setVisible(true);
    }
}

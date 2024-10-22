package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.Funcionario;
import visao.TelaMenu;

public class FuncionarioDAO {
    private TelaMenu menu;

    // Método para cadastrar um funcionário
    public int cadastrarFuncionario(Funcionario c) {
        PreparedStatement stmt1 = null;
        int res1 = 0;
        Connection conn = ConexaoBD.getConexaoMySQL();

        try {
            stmt1 = conn.prepareStatement(
                    "INSERT INTO funcionarios (CPF, NomeFuncionario, Email, Senha) VALUES (?, ?, ?, ?);");
            stmt1.setString(1, c.getCpf());
            stmt1.setString(2, c.getNome());
            stmt1.setString(3, c.getEmail());
            stmt1.setString(4, c.getSenha());

            res1 = stmt1.executeUpdate();
            stmt1.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res1;
    }

    // Método para logar um funcionário
    public Funcionario logarFuncionario(Funcionario f) {
        ResultSet res1 = null;
        PreparedStatement stmt1 = null;
        Connection conn = ConexaoBD.getConexaoMySQL();

        try {
            stmt1 = conn.prepareStatement(
                    "SELECT * FROM armariodigital.funcionarios WHERE Email LIKE ? AND Senha LIKE ?;");
            stmt1.setString(1, f.getEmail());
            stmt1.setString(2, f.getSenha());
            res1 = stmt1.executeQuery();

            if (res1.next()) {
                int id = res1.getInt("idFuncionario");
                String cpf = res1.getString("CPF");
                String nome = res1.getString("NomeFuncionario");

                f.setId(id);
                f.setCpf(cpf);
                f.setNome(nome);

                return f;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Logado");
        }
        return null;
    }

    // Novo método para buscar um funcionário pelo e-mail
    public Funcionario buscarPorEmail(String email) {
        ResultSet res1 = null;
        PreparedStatement stmt1 = null;
        Connection conn = ConexaoBD.getConexaoMySQL();
        Funcionario funcionario = null;

        try {
            stmt1 = conn.prepareStatement("SELECT * FROM funcionarios WHERE Email = ?;");
            stmt1.setString(1, email);
            res1 = stmt1.executeQuery();

            if (res1.next()) {
                funcionario = new Funcionario();
                funcionario.setId(res1.getInt("idFuncionario"));
                funcionario.setCpf(res1.getString("CPF"));
                funcionario.setNome(res1.getString("NomeFuncionario"));
                funcionario.setEmail(res1.getString("Email"));
                funcionario.setSenha(res1.getString("Senha"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (res1 != null) res1.close();
                if (stmt1 != null) stmt1.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return funcionario;
    }
}

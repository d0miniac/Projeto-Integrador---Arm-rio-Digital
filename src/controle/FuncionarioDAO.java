package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Funcionario;
import javax.swing.JOptionPane;

public class FuncionarioDAO {


    public int cadastrarFuncionario(Funcionario f) {
        String sql = "INSERT INTO funcionarios (CPF, NomeFuncionario, Email, Senha) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.getConexaoMySQL();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, f.getCpf());
            stmt.setString(2, f.getNome());
            stmt.setString(3, f.getEmail());
            stmt.setString(4, f.getSenha());

            return stmt.executeUpdate(); 
        } catch (SQLException e) {
            e.printStackTrace();
            return 0; 
        }
    }


    public Funcionario logarFuncionario(Funcionario f) {
        String sql = "SELECT * FROM funcionarios WHERE Email = ? AND Senha = ?";
        try (Connection conn = ConexaoBD.getConexaoMySQL();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, f.getEmail());
            stmt.setString(2, f.getSenha());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    f.setId(rs.getInt("idFuncionario"));
                    f.setCpf(rs.getString("CPF"));
                    f.setNome(rs.getString("NomeFuncionario"));
                    return f;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar fazer login.");
            e.printStackTrace();
        }
        return null; 
    }


    public Funcionario buscarPorEmail(String email) {
        String sql = "SELECT * FROM funcionarios WHERE Email = ?";
        try (Connection conn = ConexaoBD.getConexaoMySQL();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Funcionario funcionario = new Funcionario();
                    funcionario.setId(rs.getInt("idFuncionario"));
                    funcionario.setCpf(rs.getString("CPF"));
                    funcionario.setNome(rs.getString("NomeFuncionario"));
                    funcionario.setEmail(rs.getString("Email"));
                    funcionario.setSenha(rs.getString("Senha"));
                    return funcionario;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }

    public ArrayList<Funcionario> selecionarFuncionarios() throws SQLException {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionarios";
        try (Connection conn = ConexaoBD.getConexaoMySQL();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("idFuncionario"));
                funcionario.setCpf(rs.getString("CPF"));
                funcionario.setNome(rs.getString("NomeFuncionario"));
                funcionario.setEmail(rs.getString("Email"));
                funcionario.setSenha(rs.getString("Senha"));
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionarios;
    }
}

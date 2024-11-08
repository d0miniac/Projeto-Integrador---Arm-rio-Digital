package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Fornecedor;

public class FornecedorDAO {

    public int cadastrarFornecedor(Fornecedor fornecedor) {
        String sql = "INSERT INTO fornecedores (Email, Nome_Fornecedor, Nome_Ctt, Telefone) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.getConexaoMySQL();
             PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, fornecedor.getEmail());
            stmt.setString(2, fornecedor.getNomeFornecedor());
            stmt.setString(3, fornecedor.getNomeCtt());
            stmt.setString(4, fornecedor.getTelefone());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        fornecedor.setIdFornecedor(generatedKeys.getLong(1));
                    }
                }
            }
            return affectedRows;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void excluirFornecedor(Long idFornecedor) throws SQLException {
        ProdutoDAO produtoDAO = new ProdutoDAO();

        produtoDAO.excluirProdutosPorFornecedor(idFornecedor);

        String sql = "DELETE FROM fornecedores WHERE idFornecedor = ?";
        try (Connection conn = ConexaoBD.getConexaoMySQL();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, idFornecedor);
            stmt.executeUpdate();
        }
    }

    public void alterarFornecedor(Fornecedor fornecedor) throws SQLException {
        String sql = "UPDATE fornecedores SET Email = ?, Nome_Fornecedor = ?, Nome_Ctt = ?, Telefone = ? WHERE idFornecedor = ?";
        try (Connection conn = ConexaoBD.getConexaoMySQL();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, fornecedor.getEmail());
            stmt.setString(2, fornecedor.getNomeFornecedor());
            stmt.setString(3, fornecedor.getNomeCtt());
            stmt.setString(4, fornecedor.getTelefone());
            stmt.setLong(5, fornecedor.getIdFornecedor());

            System.out.println("Alterando fornecedor com ID: " + fornecedor.getIdFornecedor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Fornecedor> selecionarFornecedores() throws SQLException {
        ArrayList<Fornecedor> fornecedores = new ArrayList<>();
        String sql = "SELECT * FROM Fornecedores";
        try (Connection conn = ConexaoBD.getConexaoMySQL();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setIdFornecedor(rs.getLong("idFornecedor"));
                fornecedor.setNomeCtt(rs.getString("Nome_Ctt"));
                fornecedor.setNomeFornecedor(rs.getString("Nome_Fornecedor"));
                fornecedor.setEmail(rs.getString("Email"));
                fornecedor.setTelefone(rs.getString("Telefone"));
                fornecedores.add(fornecedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fornecedores;
    }
}

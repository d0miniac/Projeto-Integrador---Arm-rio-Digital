package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Fornecedor;

public class FornecedorDAO {

    // Método para cadastrar um fornecedor no banco de dados
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
                        fornecedor.setIdFornecedor(generatedKeys.getInt(1)); // Atribui o ID gerado ao fornecedor
                    }
                }
            }

            return affectedRows; // Retorna o número de linhas afetadas, indicando se o insert foi bem-sucedido.
        } catch (SQLException e) {
            e.printStackTrace(); // Imprime o erro para o console
            return 0; // Retorna 0 se a operação falhar
        }
    }

    // Método para selecionar todos os fornecedores do banco de dados
    public ArrayList<Fornecedor> selecionarFornecedores() throws SQLException {
        ArrayList<Fornecedor> fornecedores = new ArrayList<>();
        String sql = "SELECT * FROM fornecedores"; // Ajuste o nome da tabela conforme necessário

        try (Connection conn = ConexaoBD.getConexaoMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {
            
            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setIdFornecedor(rs.getInt("idfornecedor"));
                fornecedor.setEmail(rs.getString("Email"));
                fornecedor.setNomeFornecedor(rs.getString("Nome_Fornecedor"));
                fornecedor.setNomeCtt(rs.getString("Nome_Ctt"));
                fornecedor.setTelefone(rs.getString("Telefone"));
                fornecedores.add(fornecedor); // Adiciona cada fornecedor à lista
            }
        }

        return fornecedores; // Retorna a lista de fornecedores recuperada do banco
    }
}

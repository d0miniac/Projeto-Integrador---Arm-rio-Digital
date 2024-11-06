package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Fornecedor;
import modelo.Fornecedor;

public class FornecedorDAO {

	public int cadastrarFornecedor(Fornecedor fornecedor) {
	    String sql = "INSERT INTO fornecedores (Email, Nome_Fornecedor, Nome_Ctt, Telefone) VALUES (?, ?, ?, ?)";
	    try (Connection conn = ConexaoBD.getConexaoMySQL();
	         PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
	        
	        stmt.setString(1, fornecedor.getEmail());
	        stmt.setString(2, fornecedor.getNomeFornecedor());
	        stmt.setString(3, fornecedor.getNomeCtt()); // Use Nome_Ctt
	        stmt.setString(4, fornecedor.getTelefone());

	        int affectedRows = stmt.executeUpdate();

	        if (affectedRows > 0) {
	            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    fornecedor.setIdFornecedor(generatedKeys.getInt(1)); // Defina o ID do fornecedor
	                }
	            }
	        }

	        return affectedRows; // Retorna o número de linhas afetadas
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return 0; // Erro ao cadastrar
	    }
	}
	public int excluirFornecedor(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	 public ArrayList<Fornecedor> selecionarFornecedores() throws SQLException {
	        ArrayList<Fornecedor> Fornecedores = new ArrayList<>();
	        String sql = "SELECT * FROM Fornecedores";
	        try (Connection conn = ConexaoBD.getConexaoMySQL();
	             PreparedStatement stmt = conn.prepareStatement(sql);
	             ResultSet rs = stmt.executeQuery()) {

	            while (rs.next()) {
	                Fornecedor Fornecedor = new Fornecedor();
	                Fornecedor.setIdFornecedor(rs.getInt("idFornecedor"));
	                Fornecedor.setNomeCtt(rs.getString("Nome_Ctt"));
	                Fornecedor.setNomeFornecedor(rs.getString("Nome_Fornecedor"));
	                Fornecedor.setEmail(rs.getString("Email"));
	                Fornecedor.setTelefone(rs.getString("Telefone"));
	                Fornecedores.add(Fornecedor);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return Fornecedores;
	    }
}
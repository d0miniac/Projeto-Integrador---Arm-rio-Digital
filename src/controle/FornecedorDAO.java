package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

<<<<<<< Updated upstream
            return affectedRows; // Retorna o número de linhas afetadas, indicando se o insert foi bem-sucedido.
        } catch (SQLException e) {
            e.printStackTrace(); // Imprime o erro para o console
            return 0; // Retorna 0 se a operação falhar
        }
    }
=======
			int affectedRows = stmt.executeUpdate();
>>>>>>> Stashed changes

			if (affectedRows > 0) {
				try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						fornecedor.setIdFornecedor(generatedKeys.getInt(1));
					}
				}
			}

			return affectedRows;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

<<<<<<< Updated upstream
        return fornecedores; // Retorna a lista de fornecedores recuperada do banco
    }
=======
	public ArrayList<Fornecedor> selecionarFornecedores() throws SQLException {
		ArrayList<Fornecedor> fornecedores = new ArrayList<>();
		String sql = "SELECT * FROM fornecedores";

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
				fornecedores.add(fornecedor);
			}
		}

		return fornecedores;
	}

	public int excluirFornecedor(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
>>>>>>> Stashed changes
}

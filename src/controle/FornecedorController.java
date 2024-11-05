package controle;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Fornecedor;
import controle.FornecedorDAO;

public class FornecedorController {
    
    public FornecedorController() {
    }

    // Método para listar os fornecedores
    public ArrayList<Fornecedor> listarFornecedores() throws SQLException {
        FornecedorDAO dao = new FornecedorDAO();
        return dao.selecionarFornecedores();
    }

    // Método para salvar fornecedor no banco de dados
    public void salvar(Fornecedor fornecedor) throws SQLException {
        FornecedorDAO dao = new FornecedorDAO();
        dao.cadastrarFornecedor(fornecedor);
    }
}

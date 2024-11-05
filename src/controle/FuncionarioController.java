package controle;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Funcionario;

public class FuncionarioController {
	
	public FuncionarioController() {
		// Construtor pode ser utilizado para inicializações, se necessário
	}
	
	// Método que alimenta o JTable com a lista de funcionários
	public ArrayList<Funcionario> listarFuncionarios() throws SQLException {
		FuncionarioDAO dao = new FuncionarioDAO();
		return dao.selecionarFuncionarios();
	}
	
	// Método para salvar um novo funcionário no banco de dados
	public void salvar(String nome, String cpf, String email, String senha) throws SQLException {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(nome);
		funcionario.setCpf(cpf);
		funcionario.setEmail(email);
		funcionario.setSenha(senha);
		
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.cadastrarFuncionario(funcionario);
	}
}

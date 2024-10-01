package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//public static ContaDAO instancia;

import modelo.Funcionario;

public class FuncionarioDAO {


	public int cadastrarFuncionario(Funcionario c){
		
		PreparedStatement stmt1 = null;
		int res1=0;
		Connection conn = ConexaoBD.getConexaoMySQL();

		try {
			stmt1 = conn.prepareStatement( "insert into funcionarios(CPF,NomeFuncionario,Login,Senha) values (?, ?, ?, ?);");
			stmt1.setString(1, c.getCpf());
			stmt1.setString(2, c.getNome());
			stmt1.setString(3, c.getEmail());
			stmt1.setString(4,c.getSenha());
			//String sql = "INSERT INTO funcionarios ( CPF,NomeFuncionario,Login,Senha) VALUES ("+c.getCpf()+", "+c.getNome()+", "+c.getEmail()+", "+c.getSenha()+");";

			
			//"insert into funcionarios (CPF,NomeFuncionario,Login,Senha) values ("cpf+","+nome+","+email+","+c.getSenha()+")";
			//String sql = "insert into funcionarios (CPF,NomeFuncionario,Login,Senha) values ("+c.getCpf()+","+c.getNome()+","+c.getEmail()+","+c.getSenha()+");";
			res1 = stmt1.executeUpdate();

		

			stmt1.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res1;
	}
}

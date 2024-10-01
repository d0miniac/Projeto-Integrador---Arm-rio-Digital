package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import visao.TelaMenu;
//public static ContaDAO instancia;

import javax.swing.JOptionPane;

import modelo.Funcionario;
import visao.TelaMenu;

public class FuncionarioDAO {
	private TelaMenu menu;


	public int cadastrarFuncionario(Funcionario c){
		
		PreparedStatement stmt1 = null;
		int res1=0;
		Connection conn = ConexaoBD.getConexaoMySQL();

		try {
			stmt1 = conn.prepareStatement( "insert into funcionarios(CPF,NomeFuncionario,Email,Senha) values (?, ?, ?, ?);");
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
	public Funcionario logarFuncionario(Funcionario f) {
		ResultSet res1 = null;
		PreparedStatement stmt1 = null;
		Connection conn = ConexaoBD.getConexaoMySQL();
		try {
			stmt1 = conn.prepareStatement("select * from armariodigital.funcionarios where Email like ? and Senha like ?;");
			stmt1.setString(1,f.getEmail());
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
			// TODO: handle exception
		}
					return null;

	}
	/*public Connection conexao = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	public String autenticar(Funcionario f) {
		String sql = "SELECT * FROM usuarios WHERE Email=? AND Senha=?";
		

		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, f.getEmail());
			pst.setString(2, f.getSenha());

			rs = pst.executeQuery();

			if (rs.next()) {
				String perfil = rs.getString("perfil");
				return perfil;
			} else {
				return null;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}*/
}

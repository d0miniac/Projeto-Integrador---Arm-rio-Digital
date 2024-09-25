package modelo;

import java.sql.*;

public class ModuloConexao {
	// método para estabelecer conexão com o BD
	public static Connection conector() {
		Connection conexao = null;
		// chamar o driver
		String driver = "com.mysql.cj.jdbc.Driver";
		// Armazenando infos do banco
		String url = "jdbc:mysql://localhost:3306/lojabd";
		String user = "root";
		String password = "aluno";
		// Estabelecer a conexao com o DB
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, user, password);
			return conexao;
		} catch (Exception e) {
			return null;
		}
	}
}

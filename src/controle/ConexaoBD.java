package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
	public static Connection getConexaoMySQL() {
		Connection connection = null;
		String driverName = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("driver não encontrado");
		}
		String serverName = "localhost:3306";
		String bancoDados = "armariodigital";
		String url = "jdbc:mysql://"+ serverName +"/"+bancoDados;
		String username = "root";
		String password = "aluno";
		try {
			connection = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("BD não conectado");
		}
		return connection;
	}

}

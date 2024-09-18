package controle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ContaDAO {
    
    public static void main(String[] args) { // Corrigido para 'main'

        Statement stmt1 = null;
        Connection conn = ConexaoBD.getConexaoMySQL();

        try {
            stmt1 = conn.createStatement();
            ResultSet res1 = stmt1.executeQuery("SELECT cpf, senha FROM funcionarios");

            System.out.println("CPF          SENHA");
            // Conta o número de registros do ResultSet no BD
            int count = 0;
            while (res1.next()) {
                System.out.println(
                        res1.getString("cpf") + "   " + res1.getString("senha"));
                count++;
            }
            System.out.println("Número de registros: " + count);

            res1.close();
            stmt1.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

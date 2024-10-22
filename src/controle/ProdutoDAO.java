package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;

import modelo.Produto;


public class ProdutoDAO {
	public int cadastrarProduto(Produto p){
		PreparedStatement stmt1 = null;
		int res1=0;
		Connection conn = ConexaoBD.getConexaoMySQL();
		try {
			int forn = 1;
			stmt1 = conn.prepareStatement( "insert into armariodigital.produtos(idProduto,Tamanho,Categoria,Preco,QT_Estoque,Cor,Marca,Fornecedor_idFornecedor,Imagem) values (?,?, ?, ?,?,?,?,?,?);");
			stmt1.setLong(1, p.getId());
			stmt1.setString(2, p.getTamanho());
			stmt1.setString(3, p.getCategoria());
			stmt1.setFloat(4, p.getPreco());
			stmt1.setInt(5, p.getQuantidade());
			stmt1.setString(6, p.getCor());
			stmt1.setString(7, p.getMarca());
			stmt1.setLong(8, p.getFornecedor());
			stmt1.setString(9,p.getFoto());
			res1 = stmt1.executeUpdate();
			
			stmt1.close();
			conn.close();
			System.out.println("Produto Cadastrado");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return res1;
	}
}

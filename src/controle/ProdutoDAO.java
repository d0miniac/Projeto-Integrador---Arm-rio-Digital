package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;

import modelo.Produto;


public class ProdutoDAO {
	public void cadastrarProduto(Produto p){
		PreparedStatement stmt1 = null;
		int res1=0;
		Connection conn = ConexaoBD.getConexaoMySQL();
		try {
			stmt1 = conn.prepareStatement( "insert into armariodigital.produtos(Tamanho,Categoria,Preco,QT_Estoque,Cor,Marca,idFornecedor,) values (?, ?, ?,?,?,?,1);");
			stmt1.setString(1, p.getTamanho());
			stmt1.setString(2, p.getCategoria());
			stmt1.setFloat(3, p.getPreco());
			stmt1.setInt(4, p.getQuantidade());
			stmt1.setString(5, p.getCor());
			stmt1.setString(6, p.getMarca());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

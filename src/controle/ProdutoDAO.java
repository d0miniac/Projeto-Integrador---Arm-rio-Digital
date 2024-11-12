package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Categoria;
import modelo.Cor;
import modelo.Marca;
import modelo.Produto;
import modelo.Tamanho;


public class ProdutoDAO {

	public int cadastrarProduto(Produto p){
		PreparedStatement stmt1 = null;
		int res1=0;
		Connection conn = ConexaoBD.getConexaoMySQL();
		try {
			stmt1 = conn.prepareStatement( "insert into armariodigital.produtos(Tamanho,Categoria,Preco,QT_Estoque,Cor,Marca,Fornecedor_idFornecedor,Imagem) values (?, ?, ?,?,?,?,?,?);");
			
			stmt1.setString(1, p.getTamanho().getDescricao());
			stmt1.setString(2, p.getCategoria().getDescricao());
			stmt1.setFloat(3, p.getPreco());
			stmt1.setInt(4, p.getQuantidade());
			stmt1.setString(5, p.getCor().getDescricao());
			stmt1.setString(6, p.getMarca().getDescricao());
			stmt1.setLong(7, p.getFornecedor());
			stmt1.setString(8,p.getFoto());
			res1 = stmt1.executeUpdate();
			
			stmt1.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return res1;
	}
	
	public ArrayList<Produto> selecionarProdutos() {
		ArrayList<Produto> listaProdutos = new ArrayList<>();
		String sql = "SELECT * FROM Produtos;";
		PreparedStatement stmt1 = null;
		ResultSet rs = null;
		Connection conn = ConexaoBD.getConexaoMySQL();
		try {
			stmt1= conn.prepareStatement("SELECT * FROM armariodigital.Produtos;");
			rs = stmt1.executeQuery();
		while(rs.next()) {
			Produto p = new Produto();
			p.setId(rs.getLong("idProduto"));
			p.setCategoria(Categoria.getCategoriaPorDescricao(rs.getString("Categoria")));
			p.setCor(Cor.getCorPorDescicao(rs.getString("Cor")));
			p.setTamanho(Tamanho.getTamanhoPorDescricao(rs.getString("Tamanho")));
			p.setPreco(rs.getFloat("Preco"));
			p.setQuantidade(rs.getInt("QT_Estoque"));
			p.setMarca(Marca.getMarcaPorDescricao(rs.getString("Marca")));
			p.setFornecedor(rs.getInt("Fornecedor_idFornecedor"));
			p.setFoto(rs.getString("Imagem"));
			listaProdutos.add(p);
			
			
		}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaProdutos;
		
	}
	
	public void excluirProdutos(Long id) throws SQLException {
		PreparedStatement stmt1 = null;
		ResultSet rs = null;
		Connection conn = ConexaoBD.getConexaoMySQL();
		try {
			stmt1 = conn.prepareStatement("delete from armariodigital.produtos where idProduto = ?;");
			stmt1.setLong(1, id);
			System.out.println(stmt1);
			stmt1.executeUpdate();
			stmt1.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void alterarProdutos(Produto p) throws SQLException {
		PreparedStatement stmt1 = null;
		ResultSet rs = null;
		Connection conn = ConexaoBD.getConexaoMySQL();
		try {
			stmt1 = conn.prepareStatement("update armariodigital.produtos set Tamanho =?, Categoria = ?, Preco = ?, QT_Estoque = ?, Cor=?, Marca = ?, Fornecedor_idFornecedor=?,Imagem=? where idProduto = ?;");
			System.out.println(p.getTamanho());
			stmt1.setString(1, p.getTamanho().getDescricao());
			stmt1.setString(2, p.getCategoria().getDescricao());
			stmt1.setFloat(3, p.getPreco());
			stmt1.setInt(4, p.getQuantidade());
			stmt1.setString(5, p.getCor().getDescricao());
			stmt1.setString(6, p.getMarca().getDescricao());
			stmt1.setLong(7, p.getFornecedor());
			stmt1.setString(8,p.getFoto());
			stmt1.setLong(9, p.getId());
			stmt1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public ArrayList<Produto> pesquisarProdutos(String filtro) {
		ArrayList<Produto> listaProdutos = new ArrayList<>();
		String sql = "SELECT * FROM Produtos;";
		PreparedStatement stmt1 = null;
		ResultSet rs = null;
		Connection conn = ConexaoBD.getConexaoMySQL();
		try {
			stmt1= conn.prepareStatement("SELECT * FROM armariodigital.Produtos WHERE Categoria like ? OR Cor like ? OR Tamanho like? OR Marca like ?;");
			stmt1.setString(1,filtro);
			stmt1.setString(2,filtro);
			stmt1.setString(3,filtro);
			stmt1.setString(4,filtro);
			rs = stmt1.executeQuery();
		while(rs.next()) {
			Produto p = new Produto();
			p.setId(rs.getLong("idProduto"));
			p.setCategoria(Categoria.getCategoriaPorDescricao(rs.getString("Categoria")));
			p.setCor(Cor.getCorPorDescicao(rs.getString("Cor")));
			p.setTamanho(Tamanho.getTamanhoPorDescricao(rs.getString("Tamanho")));
			p.setPreco(rs.getFloat("Preco"));
			p.setQuantidade(rs.getInt("QT_Estoque"));
			p.setMarca(Marca.getMarcaPorDescricao(rs.getString("Marca")));
			p.setFornecedor(rs.getInt("Fornecedor_idFornecedor"));
			p.setFoto(rs.getString("Imagem"));
			listaProdutos.add(p);
			
			
		}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaProdutos;
		
	}
}

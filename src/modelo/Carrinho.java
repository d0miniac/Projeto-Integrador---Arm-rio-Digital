package modelo;

import java.util.ArrayList;

import controle.CarrinhoDAO;

public class Carrinho {
	public ArrayList<ItemVenda> itens;
	
	
//	public ArrayList<ItemVenda> adicionar(ItemVenda item){
//		itens.add(item);
//		return itens;
//	}
//	public static Carrinho getInstancia() {
//        if (instanciaUnica == null) {
//            instanciaUnica = new Carrinho();
//        }
//        return instanciaUnica;
//    }
	
//	public void listarItens() {
//        if (itens.isEmpty()) {
//            System.out.println("Carrinho vazio!");
//        } else {
//            for (ItemVenda item : itens) {
//                
//            }
//        }
//    }
	public void adicionar(ItemVenda iv) {
		
		ArrayList<ItemVenda> lista = new ArrayList<>();
		
		lista.add(iv);		
		this.itens=lista;
	}
	public ArrayList<ItemVenda> getItens() {
		return itens;
	}

	public void setItens(ArrayList<ItemVenda> itens) {
		this.itens = itens;
	}
	
}

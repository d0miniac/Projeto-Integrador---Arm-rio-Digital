package modelo;

import java.util.ArrayList;

public class Carrinho {
	public ArrayList<Item> itens;
	
	public ArrayList<Item> adicionar(Item item){
		itens.add(item);
		return itens;
	}

	public ArrayList<Item> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}
	
}

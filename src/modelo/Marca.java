package modelo;

public enum Marca {
	
	NIKE("Nike"),ADIDAS("Adidas"),PUMA("Puma");

	
	private String descricao;
	
	private Marca(String desc) {
		this.descricao = desc;
		// TODO Auto-generated constructor stub
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}

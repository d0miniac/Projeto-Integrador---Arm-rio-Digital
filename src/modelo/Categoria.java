package modelo;

public enum Categoria {
	CAMISA("Camisa"),CALÇA("Calça"),BLUSA("Blusa"),JAQUETA("Jaqueta"),SAIA("Saia/Vestido"),SHORTS("Bermuda/Shorts"),INTIMA("Roupa Intíma");
	
	private String descricao;

	
	private Categoria(String desc) {
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

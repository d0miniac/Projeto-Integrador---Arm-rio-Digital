package modelo;

public enum Cor {
	VERMELHO("Vermelho"),LARANJA("Laranja"),AZUL("Azul"),ROXO("Roxo"),VERDE("Verde"),AMARELO("Amarelo"),ROSA("Rosa"),BRANCO("Branco"),PRETO("Preto"),CINZA("Cinza"),MARROM("Marrom");
	private String descricao;
	private Cor(String desc) {
		this.descricao = desc;
		
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}

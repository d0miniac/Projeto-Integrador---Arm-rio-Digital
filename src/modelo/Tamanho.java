package modelo;

public enum Tamanho {
	PP("pp"),P("p"),M("m"),G("g"),GG("gg"),XG("xg"),XGG("xgg"),EG("eg"),EGG("egg") ;
	private String descricao;
	private Tamanho(String desc) {
		this.descricao=desc;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao() {
		// TODO Auto-generated method stub
		return null;
	}
}

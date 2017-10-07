package br.com.fluig.hackathon.domain.model;

public class Produto {

	private String id;
	private String codigoBarras;
	private String descricao;
	private int qtde;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", codigoBarras=" + codigoBarras + ", descricao=" + descricao + ", qtde=" + qtde + "]";
	}
	
}

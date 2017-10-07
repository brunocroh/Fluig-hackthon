package br.com.fluig.hackathon.domain.model;

import java.util.List;

public class Pedido {
	private long codigo;
	private Usuario usuario;
	private List<Produto> produtos;
	private String dataPedido;
	private String dataPickUp;
	private boolean ehEntrega;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public String getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
	}

	public boolean isEhEntrega() {
		return ehEntrega;
	}

	public void setEhEntrega(boolean ehEntrega) {
		this.ehEntrega = ehEntrega;
	}

	public String getDataPickUp() {
		return dataPickUp;
	}

	public void setDataPickUp(String dataPickUp) {
		this.dataPickUp = dataPickUp;
	}

}

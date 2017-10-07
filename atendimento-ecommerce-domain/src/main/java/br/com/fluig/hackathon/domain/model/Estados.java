package br.com.fluig.hackathon.domain.model;

import java.util.Arrays;

public enum Estados {
	SEPARANDO(5, "Pedido está sendo separado para entrega."),

	ENTREGANDO(13, "Pedido saiu para entrega."),

	PREPARANDO_PICKUP(15, "Pedido está sendo preparado para retirada."),
	
	FINALIZADO(0, "Atendimento do pedido foi finalizado.");

	private int codigo;
	private String mensagem;

	private Estados(int codigo, String mensagem) {
		this.codigo = codigo;
		this.mensagem = mensagem;
	}

	public static Estados getByCodigo(int codigo) {
		return Arrays.stream(Estados.values()).filter(example -> example.getCodigo() == codigo).findAny().get();
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}

package br.com.fluig.hackathon.domain.model;

import javax.xml.bind.annotation.XmlElement;

public class ResultadoAtendimento {
	
	private int codigo;
	private boolean status;
	private String mensagem;


	public ResultadoAtendimento(int codigo, boolean status, String mensagem) {
		this.codigo = codigo;
		this.status = status;
		this.mensagem = mensagem;
	}

	public int getCodigo() {
		return codigo;
	}
	
	@XmlElement(name = "codigo")
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public boolean isStatus() {
		return status;
	}

	@XmlElement(name = "status", required = true)
	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	@XmlElement(name = "mensagem", required = true)
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public String toString() {
		return "ResultadoCompromisso [codigo=" + codigo + ", status=" + status + ", mensagem=" + mensagem
				+ "]";
	}

}

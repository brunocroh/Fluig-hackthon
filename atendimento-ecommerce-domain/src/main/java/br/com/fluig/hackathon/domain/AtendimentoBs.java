package br.com.fluig.hackathon.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fluig.hackathon.domain.model.EstadoAtendimento;
import br.com.fluig.hackathon.domain.model.Estados;
import br.com.fluig.hackathon.domain.model.Pedido;
import br.com.fluig.hackathon.domain.model.ResultadoAtendimento;

@Component
public class AtendimentoBs {

	@Autowired
	private AtendimentoDao dao;

	public ResultadoAtendimento iniciar(Pedido pedido){
		int codigoProcesso = dao.startProcess(pedido);
		return new ResultadoAtendimento(codigoProcesso, true, "Foi iniciado o atendimento do seu pedido!");
	}
	
	public EstadoAtendimento status(int codigoPedido){
		int statusProcesso = dao.getStatusProcesso(codigoPedido);
		Estados estado = Estados.getByCodigo(statusProcesso);
		return new EstadoAtendimento(estado.getCodigo(), estado.getMensagem());
	}
	


}

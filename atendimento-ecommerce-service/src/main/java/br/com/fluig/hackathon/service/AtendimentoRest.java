package br.com.fluig.hackathon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.fluig.hackathon.domain.AtendimentoBs;
import br.com.fluig.hackathon.domain.model.EstadoAtendimento;
import br.com.fluig.hackathon.domain.model.Pedido;
import br.com.fluig.hackathon.domain.model.ResultadoAtendimento;

@Service
@RequestMapping("/atendimento")
public class AtendimentoRest {

	@Autowired
	private AtendimentoBs atendimentoBs;
	
	@RequestMapping(value = "/iniciar", method = RequestMethod.POST)
	public @ResponseBody ResultadoAtendimento iniciar(@RequestBody Pedido pedidoMap) {
		return atendimentoBs.iniciar(pedidoMap);
	}	
	
	@RequestMapping(value = "/status/{codigo}", method = RequestMethod.POST)
	public @ResponseBody EstadoAtendimento status(@PathVariable int codigo) {
		return atendimentoBs.status(codigo);
	}	
	
}

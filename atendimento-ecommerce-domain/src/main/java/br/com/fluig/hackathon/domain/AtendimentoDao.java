package br.com.fluig.hackathon.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.conector.fluig.framework.parametrizacao.WebServiceUserProperties;
import br.com.fluig.hackathon.domain.model.Estados;
import br.com.fluig.hackathon.domain.model.Pedido;
import pcsist.fluig.ws.workflowengine.getallactivestates.GetAllActiveStatesMessage;
import pcsist.fluig.ws.workflowengine.getallactivestates.GetAllActiveStatesResponse;
import pcsist.fluig.ws.workflowengine.getallactivestates.GetAllActiveStatesWsClient;
import pcsist.fluig.ws.workflowengine.startProcess.CardDataArray;
import pcsist.fluig.ws.workflowengine.startProcess.CardDataItem;
import pcsist.fluig.ws.workflowengine.startProcess.StartProcessMessage;
import pcsist.fluig.ws.workflowengine.startProcess.StartProcessResponse;
import pcsist.fluig.ws.workflowengine.startProcess.StartProcessWsClient;

@Repository
public class AtendimentoDao {

	protected int getStatusProcesso(int codigoPedido) {
		GetAllActiveStatesWsClient getAllActiveStatesWsClient = new GetAllActiveStatesWsClient(
				WebServiceUserProperties.url);
		GetAllActiveStatesMessage getAllActiveStatesMessage = new GetAllActiveStatesMessage();
		getAllActiveStatesMessage.setUsername(WebServiceUserProperties.user);
		getAllActiveStatesMessage.setUserId(WebServiceUserProperties.user);
		getAllActiveStatesMessage.setPassword(WebServiceUserProperties.password);
		getAllActiveStatesMessage.setCompanyId(WebServiceUserProperties.company);
		getAllActiveStatesMessage.setProcessInstanceId(codigoPedido);
		GetAllActiveStatesResponse resposta = getAllActiveStatesWsClient.send(getAllActiveStatesMessage);

		if (resposta != null && resposta.getStates().length > 0) {
			return resposta.getStates()[0];
		}
		return Estados.FINALIZADO.getCodigo();
	}

	protected int startProcess(Pedido pedido) {
		String idProcesso = "0";

		StartProcessWsClient startProcessClient = new StartProcessWsClient(WebServiceUserProperties.url);
		StartProcessMessage novoProcesso = new StartProcessMessage();
		novoProcesso.setCompanyId(WebServiceUserProperties.company);
		novoProcesso.setUsername(WebServiceUserProperties.user);
		novoProcesso.setUserId(WebServiceUserProperties.user);
		novoProcesso.setPassword(WebServiceUserProperties.password);
		novoProcesso.setChoosedState(5);
		novoProcesso.getColleagueIds().getItem().add(WebServiceUserProperties.user);
		novoProcesso.setProcessId("atendimento_ecommerce");
		novoProcesso.setCompleteTask(true);

		try {
			CardDataArray createCardData = createCardData(pedido);
			novoProcesso.setCardData(createCardData);

			StartProcessResponse resposta = startProcessClient.send(novoProcesso);

			if (resposta.getResult().length > 4) {
				String[] task = resposta.getResult()[4];
				idProcesso = task[1];
			}
		} catch (Exception e) {
			return 0;
		}
		return Integer.valueOf(idProcesso);
	}

	private CardDataArray createCardData(Pedido pedido) {
		CardDataArray cardDataArr = new CardDataArray();

		CardDataItem email = new CardDataItem();
		email.setField("email");
		email.setValue(String.valueOf(pedido.getUsuario().getEmail()));
		cardDataArr.getItem().add(email);
		
		CardDataItem nome = new CardDataItem();
		nome.setField("nome");
		nome.setValue(String.valueOf(pedido.getUsuario().getNome()));
		cardDataArr.getItem().add(nome);
		
		CardDataItem entrega = new CardDataItem();
		entrega.setField("entrega");
		entrega.setValue(pedido.isEhEntrega()? "Sim" : "Não");
		cardDataArr.getItem().add(entrega);
		
		CardDataItem dataPedido = new CardDataItem();
		dataPedido.setField("dataPedido");
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
		dataPedido.setValue(date.format(formatter));
		cardDataArr.getItem().add(dataPedido);
		
		CardDataItem listaProdutos = new CardDataItem();
		listaProdutos.setField("listaProdutos");
		try {
			listaProdutos.setValue(new ObjectMapper().writeValueAsString(pedido.getProdutos()));
		} catch (JsonProcessingException e) {
		}
		cardDataArr.getItem().add(listaProdutos);
		
		return cardDataArr;
	}

}

var formWorkflow = (
	function () {
		'use strict';

		
		function init() {
			$("#lbEmailCliente").text($("#email").val());
			$("#lbNomeCliente").text($("#nome").val());
			$("#lbEntregar").text($("#entrega").val());
			$("#lbDataPedido").text($("#dataPedido").val());
			
			produtos.criarTabela();
			
		};
		return {
			init: init
		}

	})();


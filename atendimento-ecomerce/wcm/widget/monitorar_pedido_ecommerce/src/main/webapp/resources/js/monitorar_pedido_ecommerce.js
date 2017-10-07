var monitoria = (function(SuperWidget, window, $) {

	function init() {
		var dados = getDados();
//		var chart = FLUIGC.chart('#monitoria', {
//			id : 'set_an_id_for_my_chart',
//			width : '700',
//			height : '200'
//		});
//		var barChart = chart.bar(dados, {});
	}

	function consultarEstadoPedidos() {
		var dataset = DatasetFactory.getDataset("atendimento_ecommerce", null,
				null, null);

		var separacao = 0;
		var pickup = 0;
		var transportadora = 0;
		var entrega = 0;
		
		for (var i = 0; i < dataset.values.length; i++) {
			if (dataset.values[i].WKNumState == 5) {
				separacao = separacao + 1;
			} else if (dataset.values[i].WKNumState == 15) {
				pickup = pickup + 1;
			} else if (dataset.values[i].WKNumState == 13) {
				entrega = entrega + 1;
			} else if (dataset.values[i].WKNumState == 25) {
				transportadora = transportadora + 1;
			}
		}
		
		$("#pickup").text(pickup + " Pedidos");
		$("#transportadora").text(transportadora + " Pedidos");
		$("#entrega").text(entrega + " Pedidos");
		$("#separacao").text(separacao + " Pedidos");
		return dataset ? dataset.values[0] : [];
	}

	function getDados() {
		var teste = consultarEstadoPedidos();
		return {
			labels : [ "Separando Pedido", "Disponibilizando Pick up",
					"Enviando por Transportadora", "Finalizando entrega" ],
			datasets : [ {
				label : "Pedidos",
				fillColor : "rgba(220,220,220,0.5)",
				strokeColor : "rgba(220,220,220,0.8)",
				highlightFill : "rgba(220,220,220,0.75)",
				highlightStroke : "rgba(220,220,220,1)",
				data : [ 65, 59, 80, 81, 56, 55, 40 ]
			} ]
		};
	}

	return SuperWidget.extend({
		init : function() {
			instanceId = this.instanceId;
			root = $("#monitoria_" + instanceId);
			init();
		},
		getFormData : function() {
			var args = {}
			return args;
		},
		saveSettings : function() {
			var that = this;
			var args = that.getFormData();
			var settingsData = btoa(JSON.stringify(args));

			var ret = WCMSpaceAPI.PageService.UPDATEPREFERENCES({
				async : false
			}, that.instanceId, {
				widgetSettings : settingsData
			});

			if (ret) {
				FLUIGC.toast({
					title : 'Monitoria: ',
					message : ret.message,
					type : 'success'
				});
			} else {
				FLUIGC.toast({
					title : 'Monitoria: ',
					message : 'Erro ao salvar',
					type : 'danger'
				});
			}
		}
	});
})(SuperWidget, window, $)

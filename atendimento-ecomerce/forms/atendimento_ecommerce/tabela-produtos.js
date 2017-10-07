
var produtos = (
function  () {
	
	'use strict';
	
	var tabelaProdutos;
	function criarTabela(){
		let header =[
	        { 'title': '' },
	        { 'title': 'Descrição' },
	        { 'title': 'Qtde'}
        ] ;
       let template = '.template_produtos';
       
		tabelaProdutos = FLUIGC.datatable('#produtos', {
		    search: {
		        enabled: false
		    },
		    dataRequest: getProdutos(),
		    renderContent: template,
		    header: header,
		    scroll: {
		        enabled: false
		    },
            navButtons: {
                enabled: false,
            },
		    emptyMessage: '<div class="text-center">Nenhum registro encontrado.</div>'
		});
		
		
		$('#produtos').on('click', '[data-select]', function(ev) {
			  var target = $( event.target );
			  var estaClicado = $(target.parent().find("[data-checkbox]").get(0)).children().is(':checked');
			  $(target.parent().find("[data-checkbox]").get(0)).children().attr( 'checked', !estaClicado );
			  $(target.parent().find("[data-checkbox]").get(0)).children().prop( 'checked', !estaClicado );
			  if(estaClicado){
				  if($("#qtdeProdutosSelecionados").val()=="0"){
					  
				  }
				  
			  }
			  
		});
			
	}

	function sortResults(data, prop, asc) {
		data = data.sort(function(a, b) {
	        if (asc) {
	            return (a[prop] > b[prop]) ? 1 : ((a[prop] < b[prop]) ? -1 : 0);
	        } else {
	            return (b[prop] > a[prop]) ? 1 : ((b[prop] < a[prop]) ? -1 : 0);
	        }
	    });
	    return data;
	}
	
	function getProdutos(){
		var produtosInput = $("#listaProdutos").val();
		var result;
		if(produtosInput != ""){
			result = produtosInput;
		}else{
			result = historicoSpan
		}
		var parse=JSON.parse(result);
		
		return (result)  ? sortResults(parse, "data", false) : [];
	}

	 return {
		 criarTabela: criarTabela
	    }
})();

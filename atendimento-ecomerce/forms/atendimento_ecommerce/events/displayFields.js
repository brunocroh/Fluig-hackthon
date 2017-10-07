function displayFields(form,customHTML){
	var estado = getValue("WKNumState");
	log.info("***** Atendimento Ecommerce ::: " + estado);
	form.setValue("WKNumState",estado);

	if(estado ==5){
		habilitarPasso5();
	} else if(estado ==15){
		habilitarPasso15();
	} else if(estado ==25){
		habilitarPasso25();
	} else if(estado ==13){
		habilitarPasso13();
	}	

	function habilitarPasso5(){
		form.setVisibleById("divPickup",false);
		form.setVisibleById("divTrasnpostadora",false);
		form.setVisibleById("divEntregaConcluida",false);
	}
	
	function habilitarPasso15(){
		form.setVisibleById("divPickup",true);
		form.setVisibleById("divTrasnpostadora",false);
		form.setVisibleById("divEntregaConcluida",false);
	}
	
	function habilitarPasso25(){
		form.setVisibleById("divPickup",true);
		form.setVisibleById("divTrasnpostadora",true);
		form.setVisibleById("divEntregaConcluida",false);
	}
	
	function habilitarPasso13(){
		addLog("Ajustando campos para o passo 13 - Entregar Pedido");
		form.setVisibleById("divPickup",true);
		form.setVisibleById("divTrasnpostadora",true);
		form.setVisibleById("divEntregaConcluida",true);
	}
			
}
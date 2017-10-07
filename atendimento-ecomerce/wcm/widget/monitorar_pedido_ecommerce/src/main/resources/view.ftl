<script src="/webdesk/vcXMLRPC.js"></script>
<div id="monitoria_${instanceId}" class="super-widget wcm-widget-class fluig-style-guide"
	data-params="monitoria.instance({message: 'Monitoria'})">

	<h1>${i18n.getTranslation('hello.example.hello')}</h1>
	<div id='monitoria_${instanceId}'>
		<div class="panel panel-default">
			<div class="panel-heading">Acompanhar Pedido E-commerce</div>
			<div class="panel-body">
				<div id="monitoria">
					<div class="col-md-6">
						<div class="panel"
							style="background-color: #f5f5f5;padding-bottom: -4px;text-align: center;">
							Aguardando <label>  Separação</label>
						</div>
						<div class="panel"
							style="background-color:#ff5454;height: 100px;text-align: center;">
							<label style="color:white;margin-top: 40px;" id="separacao"></label>
						</div>
					</div>
					<div class="col-md-6">
						<div class="panel"
							style="background-color:#f5f5f5 ;padding-bottom: -4px;text-align: center;">
							Aguardando <label>  Disponibilização Pick Up</label>
						</div>
						<div class="panel"
							style="background-color:#79c447 ;height: 100px;text-align: center;">
							<label style="color:white;margin-top: 40px;" id="pickup"></label>
						</div>
					</div>
					<div class="col-md-6">
						<div class="panel"
							style="background-color: #f5f5f5;padding-bottom: -4px;text-align: center;">
							Aguardando <label>  Envio de transportadora</label>
						</div>
						<div class="panel"
							style="background-color:#67c2ef;height: 100px;text-align: center;">
							<label style="color:white;margin-top: 40px;" id="transportadora"></label>
						</div>
					</div>
					<div class="col-md-6">
						<div class="panel"
							style="background-color: #f5f5f5;padding-bottom: -4px;text-align: center;">
							Aguardando <label>  Conclusão de Entrega</label>
						</div>
						<div class="panel"
							style="background-color:#fabb3d;height: 100px;text-align: center;">
							<label style="color:white;margin-top: 40px;" id="entrega"></label>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


</div>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.1.1.min.js">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous">
</script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
	integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
	crossorigin="anonymous"></script>

<!-- DataPicker style, then DataPicker js -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- jsGrid dependencies -->
<link type="text/css" rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid.min.css" />
<link type="text/css" rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid-theme.min.css" />
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid.min.js"></script>

<script src="resources/js/home.js"></script>
<link rel="stylesheet" href="resources/css/home.css">

</head>
<body>
	<div class="col-md-12">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<br>
					<div class="card">
						<h5 class="card-header">Crud Tabela Fornecimento</h5>
						<div class="card-body">
							<p class="card-text"></p>
							<div id="jsGrid"></div>
						</div>
						<div class="card-footer"></div>
					</div>

					<br>
					<div class="card">
						<h5 class="card-header">Função que retorne o valor total a
							receber pelas vendas realizadas entre duas datas</h5>
						<div class="card-body">
							<p class="card-text"></p>
							<form>
								<div class="form-row">
									<div class="col-2">
										<input type="text" class="form-control data getdata"
											placeholder="Data Inicial">
									</div>
									<div class="col-2">
										<input type="text" class="form-control data getdata"
											placeholder="Data Final">
									</div>
									<div class="col-3">
										<input type="text" class="form-control getdata"
											placeholder="Resultado" disabled>
									</div>
								</div>
							</form>
						</div>
						<div class="card-footer"></div>
					</div>
					<br>
					<div class="card">
						<h5 class="card-header">Dados de vendas ordenados pela data
							da venda index</h5>
						<div class="card-body">
							<p class="card-text"></p>
							<div id="datavenda"></div>
						</div>
						<div class="card-footer"></div>
					</div>
					<br>
					
					<div class="card">
						<h5 class="card-header">Procedimento para atualizar todos os
							produtos com base em um parametro</h5>
						<div class="card-body">
							<p class="card-text">
								<form class="form-inline" id="porcentagem">
								  <label class="sr-only" for="inlineFormInputName2">Name</label>
								 	 <input type="number" class="form-control mb-2 mr-sm-2" id="inlineFormInputName2" placeholder="Porcentagem" name="porcentagem">
								  <button type="button" class="btn btn-primary mb-2" id="porcentagemButton">Enviar</button>
								</form>
							</p>
							
							<div id="procedimentoProduto"></div>
						</div>
						<div class="card-footer"></div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="insertDataModal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Adicionar novo
						Fornecimento</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<form id="fornecimento33" class="needs-validation" novalidate>
					<div class="modal-body">
						<div class="form-group">
							<label for="valorFornecimento">Valor do Fornecimento</label> <input
								type="number" class="form-control" id="valorFornecimento"
								placeholder="Valor" name="valorFornecimento" required>
						</div>
						<div class="form-group">
							<label for="qtdFornecimento">Quantidade Fornecida</label> <input
								type="number" class="form-control" id="qtdFornecimento"
								aria-describedby="qtdFornecimentoHelp" placeholder="Quantidade"
								name="qtdFornecimento" required>
						</div>
						<div class="form-group">
							<label for="dataFornecimento">Data de Fornecimento</label> <input
								type="date" class="form-control" id="dataFornecimento"
								aria-describedby="dataFornecimentoHelp" placeholder="Data"
								name="dataFornecimento" required>
						</div>
						<div class="form-group">
							<select class="custom-select" name="codFornecedor">
								<option selected>Código do Fornecedor</option>
								<c:forEach var="item" items="${fornecedor}">
									<option value="${item.codFornecedor}">${item.codFornecedor}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<select class="custom-select" name="codProduto">
								<option selected>Código do Produto</option>
								<c:forEach var="item" items="${produto}">
									<option value="${item.codProduto}">${item.codProduto}</option>
								</c:forEach>
							</select>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary"
								id="saveFornecimento">Salvar</button>
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal" id="closeModal">Fechar</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
<script>
	$(function() {
		$(".data").datepicker();
	});
</script>
</html>

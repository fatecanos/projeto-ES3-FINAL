<%@page import="br.com.fatec.model.domain.Usuario"%>
<%@page import="br.com.fatec.controller.command.ConsultaPorId"%>
<%@page import="br.com.fatec.model.dao.CargoDao"%>
<%@page import="br.com.fatec.model.domain.Cargo"%>
<%@page import="br.com.fatec.model.dao.SetorDao"%>
<%@page import="br.com.fatec.model.domain.Setor"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page import="br.com.fatec.config.aplicacao.EntidadeDominio"%>
<%@page import="br.com.fatec.config.aplicacao.Resultado"%>
<%@page import="br.com.fatec.model.domain.Regional"%>
<%@page import="br.com.fatec.controller.command.ConsultarTodos"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Cadastro de Funcionário</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="author" content="Guilherme Puras & Lucas Nogueira" />

<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" />
<script type="text/javascript" src="js/script.js"></script>
</head>
<body>
	<div class="container-fluid h-100 bg-secondary">
		<div class="col-6 offset-3 h-100">
			<div class="card card-cad-funcionario">
				<div class="card-header">
					<h3 class="text-center">Cadastro de Funcionário</h3>
				</div>

				<div class="card-body">
					<form class="form" action="Servico" method="POST">

						<div class="row">
							<div class="form-group col">
								<label class="font-weight-bold" for="nome">Nome</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"><i class="fas fa-user"></i></span>
									</div>
									<input class="form-control" id="nome" type="text" name="nome"
										placeholder="Insira o Nome" required />
								</div>
							</div>

							<div class="form-group col">
								<label class="font-weight-bold" for="cpf">CPF</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"><i
											class="far fa-id-card"></i></span>
									</div>
									<input class="form-control" id="cpf" type="text" name="cpf"
										placeholder="Insira o CPF" required />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group col">
								<label class="font-weight-bold" for="email">E-mail</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"><i class="fas fa-at"></i></span>
									</div>
									<input class="form-control" id="email" type="email"
										name="email" placeholder="Insira o E-mail" required />
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group col">
								<label class="font-weight-bold" for="dt-contratacao">Data
									de Contratação</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"><i
											class="far fa-calendar"></i></span>
									</div>
									<input class="form-control" id="dt-contratacao" type="date"
										name="dt-contratacao" placeholder="Data de Contratação"
										required />
								</div>
							</div>

							<div class="form-group col">
								<label class="mr-3 font-weight-bold" for="matricula">Matrícula</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"><i
											class="far fa-id-badge"></i></span>
									</div>
									<input class="form-control" id="matricula" type="text"
										name="matricula" placeholder="Insira a Matrícula" required />
								</div>
							</div>
						</div>

						<!-- GRUPO DO CARGO -->
						<div class="row">
							<div class="form-group col">
								<label class="font-weight-bold" for="regional">Regional</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"><i
											class="fas fa-globe-americas"></i></span>
									</div>
									<% Resultado resultado = new ConsultarTodos().executa(new Regional());%>
									<% 
										List<Regional> regionais = new LinkedList<>();
										for(EntidadeDominio e: resultado.getLista()){
											regionais.add((Regional)e);
										}
										request.setAttribute("listaRegionais", regionais);
									%>
									<select class="form-control" id="regional" name="regional" required>  
										<option>Escolha uma Regional:<option>
										<c:forEach var="regional" items="${listaRegionais}">
											<option value="${regional.getId()}">
											<c:out value="${regional.getNome()}"></c:out>
											</option>
										</c:forEach>
									</select>
								</div>
							</div>

							<div class="form-group col">
								<label class="font-weight-bold" for="setor">Setor</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"><i
											class="fas fa-code-branch"></i></span>
									</div>
									<%
										List<Setor> setores =
										new SetorDao().listarTodosCom(1);
										request.setAttribute("listaSetores", setores);
									%>
									<select class="form-control" id="setor" name="setor" required>
										<option>Escolha um Setor:<option>
										<c:forEach var="setor" items="${listaSetores}">
											<option value="${setor.getId()}">
											<c:out value="${setor.getNome()}"></c:out>
											</option>
										</c:forEach>		
									</select>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group col">
								<label class="font-weight-bold" for="cargo">Cargo</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"><i
											class="fas fa-briefcase"></i></span>
									</div>
									
									<%
										List<Cargo> cargos =
										new CargoDao().listarTodosCom(1);
										request.setAttribute("listaCargos", cargos);
									%>
									<select class="form-control" id="cargo" name="cargo" required>
										<option>Escolha um Cargo:<option>
										<c:forEach var="cargo" items="${listaCargos}">
											<option value="${cargo.getId()}">
												<c:out value="${cargo.getNome()}"></c:out>
											</option>
										</c:forEach>
									</select>
								</div>
							</div>

							<div class="form-group col">
								<label class="font-weight-bold" for="responsavel">Responsável</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"><i
											class="fas fa-user-check"></i></span>
									</div>
									<%
										resultado = new ConsultarTodos().executa(new Usuario());
										List<Usuario> users = new LinkedList<>();
										for(EntidadeDominio e: resultado.getLista()){
											users.add((Usuario)e);
										}
										request.setAttribute("listaUsuarios", users);
									%>
									<select class="form-control" id="cargo" name="usuario" required>
										<option>Escolha um Usuário:<option>
											<c:forEach var="usuario" items="${listaUsuarios}">
												<option value="${usuario.getId()}">
													<c:out value="${usuario.getNome()}"></c:out>
												</option>
											</c:forEach>
									</select>
								</div>
							</div>
						</div>
						
						
						<!-- OPERACAO E METODO -->
						<input type="hidden" name="operacao" value="salvar" id="impOperacao"> 
						<input type="hidden" name="metodo" value="/CadastrarFuncionario" id="impMetodo">
						
						
						<!-- SUBMIT -->
						<input class="d-none" type="submit" id="botaoCadastrar" />
					</form>
				</div>

				<div class="card-footer">
					<div class="row justify-content-between">
						<a href="funcionarios.jsp"><label
							class="btn btn-outline-primary">Voltar</label></a> <label
							class="btn btn-success" for="botaoCadastrar">Cadastrar</label>
					</div>
				</div>
			</div>
		</div>

	</div>
	<script src="js/jquery/jquery.slim.min.js"></script>
	<script src="js/popper/popper.min.js"></script>
	<script src="js/bootstrap/bootstrap.min.js"></script>
</body>
</html>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Cadastro de Usuário</title>
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
			<div class="card card-cad-usuario">
				<div class="card-header">
					<h3 class="text-center">Cadastro de Usuário</h3>
				</div>
				<div class="card-body">
					<form action="Servico" method="POST">
						<div class="form-group">
							<label class="font-weight-bold" for="usuario">Usuário</label>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fas fa-user"></i></span>
								</div>
								<input class="form-control" id="usuario" type="text" name="nome"
									placeholder="Insira Seu Nome de Usuário" required />
							</div>
						</div>

						<div class="form-group">
							<label class="font-weight-bold" for="senha">Senha:</label>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fas fa-key"></i></span>
								</div>
								<input class="form-control" id="pass" type="password"
									name="senha" placeholder="Insira Sua Senha" required />
							</div>
						</div>

						<div class="form-group">
							<label class="font-weight-bold" for="confirmaSenha">Confirme
								a senha:</label>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fas fa-key"></i></span>
								</div>
								<input class="form-control" id="validatePass" type="password"
									name="confirmaSenha" placeholder="Confirme Sua Senha" required 
								onBlur="validatePassword()"/>
							</div>
						</div>

						<!--GRUPO DE perfis -->
						<div><h4>Perfis:</h4>
							<label>Atendente</label>
							<input type="checkbox" name="perfil" value="ATENTENDE"><br>
							<label>Administrador</label>
							<input type="checkbox" name="perfil" value="ADMINISTRADOR"><br>
							<label>Administrador do Sistema</label>
							<input type="checkbox" name="perfil" value="ADMINISTRADOR_SISTEMA"><br>
							<label>Triagem Inicial</label>
							<input type="checkbox" name="perfil" value="TRIAGEM_INICIAL"><br>
							<label>Triagem Grupo</label>
							<input type="checkbox" name="perfil" value="TRIAGEM_GRUPO"><br>
						</div>

						<input type="hidden" name="operacao" value="salvar"> 
						<input type="hidden" name="metodo" value="/CadastrarUsuario">
						<input class="d-none" type="submit" id="botaoCadastrar" />
					</form>
				</div>

				<div class="card-footer">
					<div class="row justify-content-between">
						<a href="index.jsp"><label class="btn btn-outline-primary">Voltar</label></a>
						<label class="btn btn-success" for="botaoCadastrar" id="btnCadastrar">Cadastrar</label>
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
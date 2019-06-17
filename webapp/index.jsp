<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="author" content="Guilherme Puras & Lucas Nogueira" />

<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" />
</head>
<body>

	<div>
		<h4><%=request.getParameter("resultado")%></h4>
	</div>
	<div class="container-fluid h-100 bg-secondary">
		<div class="col-4 offset-4 h-100">
			<div class="card card-login">
				<div class="card-header bg-primary text-white text-center">
					<h4>Login</h4>
				</div>

				<div class="card-body">
					<form action="dashboard.jsp" method="POST">
						<div class="form-group">
							<label class="label" for="usuario">Usuário</label>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fas fa-user"></i></span>
								</div>
								<input class="form-control" type="text" name="usuario"
									placeholder="Usuário" required />
							</div>
						</div>

						<div class="form-group">
							<label class="label" for="senha">Senha</label>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fas fa-key"></i></span>
								</div>
								<input class="form-control" type="password" name="senha"
									placeholder="Senha" required />
							</div>
						</div>

						<div class="form-check">
							<input class="form-check-input" type="checkbox" name="lembrarMe" />
							<label class="form-check-label" for="lembrarSenha">Lembrar-Me</label>
						</div>

						<input class="btn btn-success btn-block mt-4" type="submit"
							value="Entrar" />
					</form>
				</div>

				<div class="card-footer">
					<a class="mt-4" href="cadastro-usuario.jsp">Ainda não tem
						conta?</a>
				</div>
			</div>
		</div>
	</div>

	<script src="js/jquery/jquery.slim.min.js"></script>
	<script src="js/popper/popper.min.js"></script>
	<script src="js/bootstrap/bootstrap.min.js"></script>
</body>
</html>
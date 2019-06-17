<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8" />
<title>Dashboard</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="author" content="Guilherme Puras & Lucas Nogueira" />

<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" />
</head>
<body>
	<div class="container-fluid h-100">
		<div class="row h-100">
			<aside class="col-3 menu-lateral bg-primary">
				<img src="" />

				<nav>
					<ul class="list-group">
						<li class="list-group-item list-group-item-action"><a
							class="font-size-20" href="dashboard.jsp"><i
								class="fas fa-home mr-2"></i>Principal</a></li>
						<li class="list-group-item list-group-item-action"><a
							class="font-size-20" href="funcionarios.jsp"><i
								class="fas fa-user-friends mr-2"></i>Funcionários</a></li>
						<li class="list-group-item list-group-item-action"><a
							class="font-size-20" href="categorias.jsp"><i
								class="fas fa-chart-pie mr-2"></i>Categorias</a></li>
						<li class="list-group-item list-group-item-action"><a
							class="font-size-20" href="chamados.jsp"><i
								class="fas fa-bullhorn mr-2"></i>Chamados</a></li>
						<li class="list-group-item list-group-item-action"><a
							class="font-size-20" href="conhecimentos.jsp"><i
								class="fas fa-clipboard mr-2"></i>Conhecimentos</a></li>
						<li class="list-group-item list-group-item-action"><a
							class="font-size-20" href="grupos-atendimento.jsp"><i
								class="fas fa-comments mr-2"></i>Grupos de Atendimento</a></li>
						<li class="list-group-item list-group-item-action"><a
							class="font-size-20" href="atendimentos.jsp"><i
								class="fas fa-headset mr-2"></i>Atendimentos</a></li>
					</ul>
				</nav>
			</aside>

			<section class="col h-100 principal">
				<nav class="navbar justify-content-end bg-secondary bg-light">
					<a><i class="fas fa-bell fa-lg"></i></a> <a><i
						class="fas fa-cog fa-lg ml-4"></i></a>
				</nav>
				<div><%=request.getParameter("resultado")%></div>
				<div class="bg-secondary conteudo"></div>
			</section>
		</div>
	</div>
	<script src="js/jquery/jquery.slim.min.js"></script>
	<script src="js/popper/popper.min.js"></script>
	<script src="js/bootstrap/bootstrap.min.js"></script>
</body>
</html>
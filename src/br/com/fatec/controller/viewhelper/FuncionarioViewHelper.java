package br.com.fatec.controller.viewhelper;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.config.aplicacao.EntidadeDominio;
import br.com.fatec.config.aplicacao.Resultado;
import br.com.fatec.config.patterns.IHelper;
import br.com.fatec.controller.command.ConsultaPorId;
import br.com.fatec.model.domain.Cargo;
import br.com.fatec.model.domain.Funcionario;
import br.com.fatec.model.domain.Usuario;

public class FuncionarioViewHelper implements IHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		String nome 				= request.getParameter("nome");
		String dataContratacao 		= request.getParameter("dt-contratacao");
		String numMatricula			= request.getParameter("matricula");
		String email 				= request.getParameter("email");
		String cpf 					= request.getParameter("cpf");
		String idCargo					= request.getParameter("cargo");
		String idUsuarioResponsavel 	= request.getParameter("usuario");
		
		String[] dataFormatada = dataContratacao.split("-");
		
		Funcionario funcionario = new Funcionario();
		funcionario.setIsAtivo(true);
		funcionario.setNome(nome);
		funcionario.setDataCadastro(LocalDate.now());
		funcionario.setDataContratacao(
				LocalDate.of(Integer.parseInt(dataFormatada[0]),
							 Integer.parseInt(dataFormatada[1]),
							 Integer.parseInt(dataFormatada[2])
			    )
		);
		
		funcionario.setEmail(email);
		funcionario.setCpf(cpf);
		funcionario.setNumeroMatricula(numMatricula);
		
		Resultado resultado = new ConsultaPorId(Integer.parseInt(idCargo)).executa(new Cargo());
		funcionario.setCargo((Cargo)resultado.getEntidade());
		
		resultado = new ConsultaPorId(Integer.parseInt(idUsuarioResponsavel)).executa(new Usuario());
		funcionario.setUsuario((Usuario)resultado.getEntidade());
		
		return funcionario;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setAttribute("resultado", resultado.getMensagem() + ": "+ resultado.getMotivo());
		response.sendRedirect("dashboard.jsp?resultado="+resultado.getMensagem()+": "+resultado.getMotivo());
	}



}

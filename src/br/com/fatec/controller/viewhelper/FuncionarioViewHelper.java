package br.com.fatec.controller.viewhelper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.config.aplicacao.EntidadeDominio;
import br.com.fatec.config.aplicacao.Resultado;
import br.com.fatec.config.patterns.IHelper;

public class FuncionarioViewHelper implements IHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		/*String nome 				= request.getParameter("nome");
		String dataContratacao 		= request.getParameter("dataContratacao");
		String dataCadastro			= request.getParameter("dataCadastro");
		String numMatricula			= request.getParameter("numMatricula");
		String email 				= request.getParameter("email");
		String cpf 					= request.getParameter("cpf");
		int idCargo					= Integer.parseInt(request.getParameter("idCargo"));
		int idUsuarioResponsavel 	= Integer.parseInt(request.getParameter("idUsuarioResponsavel"));
		*/
		return null;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
	}



}

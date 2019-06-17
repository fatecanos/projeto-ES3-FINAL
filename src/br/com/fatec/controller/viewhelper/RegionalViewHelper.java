package br.com.fatec.controller.viewhelper;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.config.aplicacao.EntidadeDominio;
import br.com.fatec.config.aplicacao.Resultado;
import br.com.fatec.config.patterns.IHelper;
import br.com.fatec.model.domain.Regional;

public class RegionalViewHelper implements IHelper{

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		String nome = request.getParameter("nomeRegional");
		
		return new Regional(true, nome);
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		List<Regional> listaRegionais = new LinkedList<>();
		for(EntidadeDominio e : resultado.getLista()) {
			Regional r = (Regional)e;
			listaRegionais.add(r);
		}
		
		request.setAttribute("listaRegionais", listaRegionais);
		response.sendRedirect("cadastro-funcionario.jsp");
	}

}

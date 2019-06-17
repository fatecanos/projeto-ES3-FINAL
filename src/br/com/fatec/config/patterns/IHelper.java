package br.com.fatec.config.patterns;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.config.aplicacao.EntidadeDominio;
import br.com.fatec.config.aplicacao.Resultado;

public interface IHelper {

	public EntidadeDominio getEntidade(HttpServletRequest request);
	public void setView(Resultado resultado,
					    HttpServletRequest request,
					    HttpServletResponse response) throws IOException, ServletException;
}

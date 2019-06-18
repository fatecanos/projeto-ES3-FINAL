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
import br.com.fatec.model.domain.Perfil;
import br.com.fatec.model.domain.Usuario;

public class UsuarioViewHelper implements IHelper{

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String[] perfisSelecao = request.getParameterValues("perfil");
		
		List<Perfil> perfis = new LinkedList<>();
		
		for(int i=0; i < perfisSelecao.length; i++) {
			System.out.println("on loop:"+ perfisSelecao[i]);
			
			if(perfisSelecao[i].equals("ATENDENTE")) {
				perfis.add(Perfil.ATENDENTE);
			}
			
			if(perfisSelecao[i].equals("TRIAGEM_GRUPO")) {
				perfis.add(Perfil.TRIAGEM_GRUPO);
			}
			
			if(perfisSelecao[i].equals("ADMINISTRADOR")) {
				perfis.add(Perfil.ADMINISTRADOR);
			}
			
			if(perfisSelecao[i].equals("ADMINISTRADOR_SISTEMA")) {
				perfis.add(Perfil.ADMINISTRADOR_SISTEMA);
			}
			
			if(perfisSelecao[i].equals("TRIAGEM_INICIAL")) {
				perfis.add(Perfil.TRIAGEM_INICIAL);
			}
		}
		
		System.out.println("Lista Perfis: "+(perfis.equals(null)?"sim":"nao"));
		
		Usuario usuario = new Usuario(nome, senha, perfis);
		usuario.setIsAtivo(true);
		
		return usuario;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.sendRedirect("index.jsp?resultado="+resultado.getMensagem()+": "+resultado.getMotivo());
	}
	
}	

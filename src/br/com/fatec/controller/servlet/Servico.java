package br.com.fatec.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.config.aplicacao.EntidadeDominio;
import br.com.fatec.config.patterns.Command;
import br.com.fatec.config.patterns.IHelper;
import br.com.fatec.controller.command.Ativar;
import br.com.fatec.controller.command.Atualizar;
import br.com.fatec.controller.command.Cadastrar;
import br.com.fatec.controller.command.ConsultaPorId;
import br.com.fatec.controller.command.ConsultarTodos;
import br.com.fatec.controller.command.Excluir;
import br.com.fatec.controller.command.Inativar;
import br.com.fatec.controller.viewhelper.FuncionarioViewHelper;
import br.com.fatec.controller.viewhelper.RegionalViewHelper;
import br.com.fatec.controller.viewhelper.UsuarioViewHelper;


@WebServlet("/Servico")
public class Servico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static HashMap<String, Command> comandos;
	private static HashMap<String, IHelper> viewHelpers;
	
    public Servico() {
        comandos = new HashMap<>();
        comandos.put("salvar", new Cadastrar());
        comandos.put("atualizar", new Atualizar());
        comandos.put("excluir", new Excluir());
        comandos.put("consultarPorId", new ConsultaPorId());
        comandos.put("consultaTodos", new ConsultarTodos());
        comandos.put("inativar", new Inativar());
        comandos.put("ativar", new Ativar());
        
        viewHelpers = new HashMap<>();
        viewHelpers.put("/projeto-ES3/Servico/CadastrarUsuario", new UsuarioViewHelper());
        viewHelpers.put("/projeto-ES3/Servico/CadastrarFuncionario", new FuncionarioViewHelper());
        viewHelpers.put("/projeto-ES3/Servico/ConsultarRegional", new RegionalViewHelper());
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		doProcessRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		doProcessRequest(request, response);
	}

	protected void doProcessRequest(HttpServletRequest request, HttpServletResponse response)
														throws ServletException, IOException {
		String uri = request.getRequestURI();
		String metodo = request.getParameter("metodo");
		String operacao = request.getParameter("operacao");

		PrintWriter out = response.getWriter();
		out.println("URI:"+uri);
		out.println("Metodo:"+metodo);
		out.println("Operacao:"+operacao);
		
		IHelper vh = viewHelpers.get(uri+metodo);
		EntidadeDominio entidade = vh.getEntidade(request);
		Command command = comandos.get(operacao);
		
		vh.setView(command.executa(entidade), request, response);
	}
	
}

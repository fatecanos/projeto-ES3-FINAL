package br.com.fatec.principal;

import br.com.fatec.config.aplicacao.Resultado;
import br.com.fatec.controller.command.ConsultaPorId;
import br.com.fatec.model.domain.Usuario;

public class App {

	public static void main(String[] args){
		Resultado resultado = new ConsultaPorId((Integer.parseInt("3"))).executa(new Usuario());
		Usuario user = (Usuario) resultado.getEntidade();
		System.out.println(resultado.getMensagem()+" | "+ user.getNome());
	}

}

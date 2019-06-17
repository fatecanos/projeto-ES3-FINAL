package br.com.fatec.controller.command;

import br.com.fatec.config.aplicacao.EntidadeDominio;
import br.com.fatec.config.aplicacao.Resultado;
import br.com.fatec.config.patterns.Command;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Cadastrar extends Command{
	
	@Override
	public Resultado executa(EntidadeDominio e) {
		return fachada.cadastrar(e);
	}
	
}

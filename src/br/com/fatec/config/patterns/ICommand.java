package br.com.fatec.config.patterns;

import br.com.fatec.config.aplicacao.EntidadeDominio;
import br.com.fatec.config.aplicacao.Resultado;

public interface ICommand {
	public Resultado executa(EntidadeDominio e);
}

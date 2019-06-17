package br.com.fatec.controller.command;

import br.com.fatec.config.aplicacao.EntidadeDominio;
import br.com.fatec.config.aplicacao.Resultado;
import br.com.fatec.config.patterns.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class ConsultaPorId extends Command{

	private int id;
	
	public <T> Resultado getEntidade(int id, Class<T> classeEntidade) {
		return fachada.consultaPorId(id, classeEntidade);
	}

	@Override
	public Resultado executa(EntidadeDominio e) {
		return getEntidade(this.id, e.getClass());
	}

	
}

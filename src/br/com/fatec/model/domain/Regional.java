package br.com.fatec.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.fatec.config.aplicacao.EntidadeDominio;
import br.com.fatec.config.aplicacao.Resultado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Regional extends EntidadeDominio{
	
	@Column(name="is_ativo", nullable=false)
	private boolean isAtivo;
	
	@Column(nullable=false)
	private String nome;

	@Override
	public Resultado processa() {
		return new Resultado("Pode salvar", "ok", true, null, null);
	}
	
	
	
}

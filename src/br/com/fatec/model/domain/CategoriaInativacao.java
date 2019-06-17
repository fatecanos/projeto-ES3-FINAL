package br.com.fatec.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import br.com.fatec.config.aplicacao.EntidadeDominio;
import br.com.fatec.config.aplicacao.Resultado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CategoriaInativacao extends EntidadeDominio{
	
	@Column(name="descricao", nullable=false)
	private String 	descricao;
	
	@OneToOne
	private EntidadeDominio entidade;

	@Override
	public Resultado processa() {
		// TODO Auto-generated method stub
		return null;
	}
	

}

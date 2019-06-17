package br.com.fatec.config.aplicacao;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import br.com.fatec.config.patterns.IValidacaoStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public abstract class EntidadeDominio implements IValidacaoStrategy{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="is_ativo", nullable=false)
	private Boolean isAtivo;
	
	
}

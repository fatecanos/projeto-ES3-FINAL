package br.com.fatec.model.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.fatec.config.aplicacao.EntidadeDominio;
import br.com.fatec.config.aplicacao.Resultado;
import br.com.fatec.config.patterns.IValidacaoStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter 
public class Usuario extends EntidadeDominio implements IValidacaoStrategy{
	
	@Column(name="nome", nullable=false, unique=true)
	private String nome;
	
	@Column(name="senha", nullable=false)
	private String senha;
	
	@ElementCollection
	@Enumerated(EnumType.STRING)
	private List<Perfil> perfis;
	
	@Override
	public Resultado processa() {
		Resultado resultado = new Resultado();
		resultado.setMensagem("nada aconteceu");
		resultado.setMotivo("erro na hora de validar");
		resultado.setStatus(false);
		if(this.nome.equals("") || this.nome.equals(null)||
				this.senha.equals("") || this.senha.equals(null)) {
			resultado.setMensagem("Formulario invalido");
			resultado.setMotivo("Campo vazio");
			resultado.setStatus(false);
		}else if(this.senha.length() < 8){
			resultado.setMensagem("Formulario invalido");
			resultado.setMotivo("Senha muito curta");
			resultado.setStatus(false);
		}else {
			resultado.setMensagem("Usuario é válido");
			resultado.setMotivo("campos preenchidos corretamente");
			resultado.setStatus(true);
		}
		return resultado;
	}
	
}

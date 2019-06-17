package br.com.fatec.model.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.fatec.config.aplicacao.EntidadeDominio;
import br.com.fatec.config.aplicacao.Resultado;
import br.com.fatec.controller.command.ValidaCPF;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario extends EntidadeDominio {

	@Column(name = "nome_funcionario", nullable = false)
	private String nome;

	@Column(name = "data_contratacao", nullable = false)
	private LocalDate dataContratacao;

	@Column(name = "numeroMatricula", nullable = false)
	private String numeroMatricula;

	@Column(name = "cpf", nullable = false)
	private String cpf;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "data_cadastro", nullable = false)
	private LocalDate dataCadastro;

	@OneToOne
	private Cargo cargo;

	@OneToOne
	@JoinColumn(name = "usuario_responsavel_cadastro")
	private Usuario usuario;

	@Override
	public Resultado processa() {
		Resultado resultado = new Resultado();
		resultado.setMensagem("nada aconteceu");
		resultado.setMotivo("Funcionario invalido");
		resultado.setStatus(false);

		if (this.nome.equals(null) || this.nome.equals("") || this.cargo.equals(null) || this.cpf.equals(null)
				|| this.cpf.equals("") || this.dataCadastro.equals(null) || this.dataContratacao.equals(null)
				|| this.email.equals(null) 
				|| this.numeroMatricula.equals("") || this.numeroMatricula.equals(null)
				|| this.usuario.equals(null)) {
			resultado.setMensagem("Formulário preenchido incorretamente.");
			resultado.setMotivo("campos vazios");
			resultado.setStatus(false);
			return resultado;
		} else if(!ValidaCPF.executa(this.cpf)){
			resultado.setMensagem("Cpf invalido");
			resultado.setMotivo("preeencha com cpf valido");
			resultado.setStatus(false);
			return resultado;
		}else {
			resultado.setMensagem("Atributos verificados");
			resultado.setMotivo("campos preenchidos corretamente");
			resultado.setStatus(true);
			return resultado;
		}

	}

}

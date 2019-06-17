package br.com.fatec.config.patterns;

import br.com.fatec.config.aplicacao.EntidadeDominio;
import br.com.fatec.config.aplicacao.Resultado;
import br.com.fatec.model.domain.CategoriaInativacao;

public interface IFachada {
	public Resultado cadastrar(EntidadeDominio e);
	public Resultado editar(EntidadeDominio e);
	public Resultado excluir(EntidadeDominio e);
	public Resultado inativar(EntidadeDominio e, CategoriaInativacao catInativacao);
	public Resultado ativar(EntidadeDominio e, CategoriaInativacao catInativacao);
	public <T> Resultado consultaPorId(int id, Class<T> classeEntidade);
	public <T> Resultado consultarTodos(Class<T> entidade);
}

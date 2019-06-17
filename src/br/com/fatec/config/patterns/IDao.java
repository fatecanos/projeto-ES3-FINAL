package br.com.fatec.config.patterns;

import java.util.List;

import br.com.fatec.config.aplicacao.EntidadeDominio;
import br.com.fatec.config.aplicacao.Resultado;

public interface IDao {
	public <T> Resultado salva(EntidadeDominio entidade);
	public <T> Resultado atualiza(T entidade);
	public <T> Resultado exclui(T entidade);
	public <T> List<EntidadeDominio> listarTodos(Class<T> entidade);
	public <T> Resultado buscarPorId(int id, Class<T> classeEntidade);
}

package br.com.fatec.controller.facade;

import br.com.fatec.config.aplicacao.EntidadeDominio;
import br.com.fatec.config.aplicacao.Resultado;
import br.com.fatec.config.patterns.IFachada;
import br.com.fatec.controller.strategy.Validate;
import br.com.fatec.model.dao.DaoGenerico;
import br.com.fatec.model.domain.CategoriaInativacao;

public class Fachada implements IFachada{
	
	@Override
	public Resultado cadastrar(EntidadeDominio e) {
		Resultado resultadoValidacao = Validate.valida(e);
		
		if(resultadoValidacao.getStatus().equals(true)) 
			return new DaoGenerico().salva(e);
		
		return resultadoValidacao;
	}

	@Override
	public Resultado editar(EntidadeDominio e) {
		try {
			new DaoGenerico().atualiza(e);
			return new Resultado("Atualização efetuada com sucesso", "ok", true, null, null);
		}catch(Exception ex) {
			ex.printStackTrace();
			return new Resultado("Erro ao atualizar", "erro no banco de dados", false, null, null);
		}
	}

	@Override
	public Resultado excluir(EntidadeDominio e) {
		try {
			new DaoGenerico().exclui(e);
			return new Resultado("Exclusão efetuada com sucesso", "ok", true, null, null);
		}catch(Exception ex) {
			ex.printStackTrace();
			return new Resultado("Erro ao excluir", "erro no banco de dados", false, null, null);
		}
	}

	@Override
	public Resultado inativar(EntidadeDominio e, CategoriaInativacao categoriaInativacao) {
		e.setIsAtivo(false);
		return cadastrar(categoriaInativacao);
	}

	@Override
	public Resultado ativar(EntidadeDominio e, CategoriaInativacao catInativacao) {
		e.setIsAtivo(true);
		return excluir(catInativacao);
	}

	@Override
	public <T> Resultado consultaPorId(int id, Class<T> classeEntidade) {
		return new DaoGenerico().buscarPorId(id, classeEntidade);
	}

	@Override
	public <T> Resultado consultarTodos(Class<T> entidade) {
		Resultado resultado = new Resultado();
		resultado.setLista(new DaoGenerico().listarTodos(entidade));
		
		if(resultado.getLista().equals(null)) {
			resultado.setMensagem("Nenhum "+entidade.getSimpleName()+" foi encontrado");
			resultado.setMotivo("Não existe");
		}else {
			resultado.setMensagem("Consulta efetuada com sucesso!");
			resultado.setMotivo("ok");
		}
		return resultado;
	}

	

	
	

}

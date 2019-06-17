package br.com.fatec.principal;

import java.util.List;

import br.com.fatec.config.aplicacao.EntidadeDominio;
import br.com.fatec.config.aplicacao.Resultado;
import br.com.fatec.controller.command.ConsultarTodos;
import br.com.fatec.model.dao.CargoDao;
import br.com.fatec.model.dao.SetorDao;
import br.com.fatec.model.domain.Cargo;
import br.com.fatec.model.domain.Setor;

public class App {

	public static void main(String[] args){
		
		
		ConsultarTodos consulta = new ConsultarTodos();
		Resultado res = consulta.executa(new Setor());
		for(EntidadeDominio e: res.getLista()) {
			Setor setor = (Setor)e;
			System.out.println(setor.getNome());
		}
		
		List<Setor> setores = new SetorDao().listarTodosCom(2);
		
		for(Setor s : setores) {
			System.out.println(s.getNome() + " "+ s.getRegional().getNome());
		}
		
		List<Cargo> cargos = new CargoDao().listarTodosCom(4);
		
		for(Cargo c: cargos) {
			System.out.println(c.getNome() +" "+c.getSetor().getNome());
		}
	}

}

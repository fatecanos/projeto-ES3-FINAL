package br.com.fatec.config.patterns;

import br.com.fatec.controller.facade.Fachada;


public abstract class Command implements ICommand{
	protected IFachada fachada = new Fachada();
}

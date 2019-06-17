package br.com.fatec.model.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import br.com.fatec.config.aplicacao.EntidadeDominio;
import br.com.fatec.config.aplicacao.Resultado;
import br.com.fatec.config.hibernate.HibernateConfig;
import br.com.fatec.config.patterns.IDao;

public class DaoGenerico implements IDao{
	
	private Transaction transaction;

	@Override
	public <T> Resultado salva(EntidadeDominio entidade){
		Transaction transaction = null;
		
		try(Session session = HibernateConfig.getSessionFactory().openSession()){
			transaction = session.getTransaction();
			transaction.begin();
			
			session.persist(entidade);
			
			transaction.commit();
			session.close();
			return new Resultado(entidade.getClass().getSimpleName()+" foi salvo com sucesso",
								"ok",
								true, null, null);
		}catch(ConstraintViolationException ex) {
			ex.printStackTrace();
			return new Resultado("Falha ao salvar", entidade.getClass().getSimpleName()+" ja existe", false, null, null);
		}catch (PersistenceException ex) {
			ex.printStackTrace();
			return new Resultado("Falha ao salvar", entidade.getClass().getSimpleName()+" ja existe", false, null, null);
		}catch (Exception ex) {
			ex.printStackTrace();
			return new Resultado("Falha ao salvar", "erro de conexao", false, null, null);
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T> List<EntidadeDominio> listarTodos(Class<T> entidade) {
		transaction = null;
		try (Session session = HibernateConfig.getSessionFactory().openSession()){
			List<EntidadeDominio> entidades;
			transaction = session.getTransaction();
			transaction.begin();
			
			entidades = session.createQuery("FROM "+entidade.getSimpleName()).getResultList();
			
			transaction.commit();
			session.close();
			
			return entidades;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public <T> Resultado atualiza(T entidade) {
		Transaction transaction = null;
		
		try(Session session = HibernateConfig.getSessionFactory().openSession()){
			transaction = session.getTransaction();
			transaction.begin();
			
			session.update(entidade);
			
			transaction.commit();
			session.close();
			
			return new Resultado(entidade.getClass().getSimpleName()+" atualizado com sucesso", "ok", true, null, null);
		}catch(Exception e) {
			e.printStackTrace();
			return new Resultado("Erro ao atualizar", "erro no banco de dados", false, null, null);
		}
		
	}

	@Override
	public <T> Resultado exclui(T entidade) {
		Transaction transaction = null;
		
		try(Session session = HibernateConfig.getSessionFactory().openSession()){
			transaction = session.getTransaction();
			transaction.begin();
			
			session.remove(entidade);
			
			transaction.commit();
			session.close();
			return new Resultado(entidade.getClass().getSimpleName()+" atualizado com sucesso", "ok", true, null, null);
		}catch(Exception e) {
			e.printStackTrace();
			return new Resultado("Erro ao atualizar", "erro no banco de dados", false, null, null);
		}
	}

	@Override
	public <T> Resultado buscarPorId(int id, Class<T> classeEntidade){
		Transaction transaction = null;
		try (Session session = HibernateConfig.getSessionFactory().openSession()){
			EntidadeDominio objeto = null;
			
			transaction = session.getTransaction();
			transaction.begin();
			
			objeto = (EntidadeDominio)session.find(classeEntidade, id);			
			
			transaction.commit();
			session.close();

			return new Resultado(classeEntidade.getSimpleName()+" encontrado.", "ok", true, objeto, null);
		}catch (Exception e) {
			e.printStackTrace();
			return new Resultado(classeEntidade.getSimpleName()+" não encontrado.", "inexistente", false, null, null);
		}
	}


}

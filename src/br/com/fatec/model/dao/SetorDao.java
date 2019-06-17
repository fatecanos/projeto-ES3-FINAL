package br.com.fatec.model.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.fatec.config.hibernate.HibernateConfig;
import br.com.fatec.model.domain.Setor;

public class SetorDao{
	
	@SuppressWarnings(value = { "unchecked" })
	public List<Setor> listarTodosCom(int idRegional){
		Transaction transaction = null;
		try (Session session = HibernateConfig.getSessionFactory().openSession()){
			List<Setor> listaSetor = null;
			transaction = session.getTransaction();
			transaction.begin();
			
			Query query = session.createQuery("from Setor where(regional_id="+idRegional+")");
			listaSetor = query.getResultList();
			
			transaction.commit();
			session.close();
			
			return listaSetor;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}

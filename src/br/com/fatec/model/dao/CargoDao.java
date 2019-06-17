package br.com.fatec.model.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.fatec.config.hibernate.HibernateConfig;
import br.com.fatec.model.domain.Cargo;

public class CargoDao {
	
	@SuppressWarnings(value = { "unchecked" })
	public List<Cargo> listarTodosCom(int idSetor){
		Transaction transaction = null;
		try (Session session = HibernateConfig.getSessionFactory().openSession()){
			List<Cargo> listaCargo = null;
			transaction = session.getTransaction();
			transaction.begin();
			
			Query query = session.createQuery("from Cargo where(setor_id="+idSetor+")");
			listaCargo = query.getResultList();
			
			transaction.commit();
			session.close();
			
			return listaCargo;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

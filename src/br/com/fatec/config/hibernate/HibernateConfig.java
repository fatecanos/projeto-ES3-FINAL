package br.com.fatec.config.hibernate;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import br.com.fatec.model.domain.Cargo;
import br.com.fatec.model.domain.Funcionario;
import br.com.fatec.model.domain.Regional;
import br.com.fatec.model.domain.Setor;
import br.com.fatec.model.domain.Usuario;

public class HibernateConfig {
	private static SessionFactory sessionFactory;
	protected static final String BANCO = "bdfuncionario";
	protected static final String SENHA = "1234";
	
    public static SessionFactory getSessionFactory() {
    	
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, 	 "jdbc:mysql://localhost:3306/"+ BANCO +"?useTimezone=true&serverTimezone=UTC");
                settings.put(Environment.USER, 	 "root");
                settings.put(Environment.PASS, 	 SENHA);      
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");//what is it?
                settings.put(Environment.SHOW_SQL, "false");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread"); 
                settings.put(Environment.HBM2DDL_AUTO, "create-drop"); //which are actions that it avaliable?

                configuration.setProperties(settings);

                //CLASSES ENTIDADE
                configuration.addAnnotatedClass(Usuario.class);
                configuration.addAnnotatedClass(Regional.class);
                configuration.addAnnotatedClass(Setor.class);
                configuration.addAnnotatedClass(Cargo.class);
                configuration.addAnnotatedClass(Funcionario.class);
              
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}

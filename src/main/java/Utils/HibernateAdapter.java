package Utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by vsantucc on 16/05/2017.
 */
public class HibernateAdapter {



    public HibernateAdapter() {
    }

    public SessionFactory getAdapter() {

        SessionFactory sessionFactory;
        Configuration configuration = new Configuration().configure(HibernateAdapter.class.getResource("/hibernate.cfg.xml"));
        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
        serviceRegistryBuilder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }
}

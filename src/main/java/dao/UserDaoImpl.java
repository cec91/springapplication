package dao;

import Utils.HibernateAdapter;
import entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by vsantucc on 16/05/2017.
 */
public class UserDaoImpl implements UserDao {


    HibernateAdapter adapter;

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
    private EntityManager em = emf.createEntityManager();

    @Override
    public String getUserByName(String name) {
        return ((User) em.createQuery("SELECT u FROM User u WHERE u.name =:name").setParameter("name", name).getSingleResult()).getName();
    }

    /*@Override
    public String getUserByName(String name) {
        adapter = new HibernateAdapter();
        SessionFactory sf = adapter.getAdapter();
        Session s = sf.openSession();
        s.beginTransaction();



        List result = s.createQuery("from user").list();
        for (User event : (List<User>) result) {
            System.out.println(event.getName());
            return event.getName();
        }
        s.getTransaction().commit();
        s.close();
        return "";
    }*/

    @Override
    public void insertUser() {
        adapter = new HibernateAdapter();
        SessionFactory sf = adapter.getAdapter();
        Session s = sf.openSession();
        s.beginTransaction();

        User user = new User();
        user.setName("Vincenzo");
        user.setEmail("vincenzo.santucci1@gmail.com");
        user.setPassword("vincenzo");

        s.save(user);
        s.getTransaction().commit();
        s.close();
    }


}

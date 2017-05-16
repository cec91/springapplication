package dao;

import Utils.HibernateAdapter;
import entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by vsantucc on 16/05/2017.
 */
public class UserDaoImpl implements UserDao {


    HibernateAdapter adapter;


    @Override
    public User getUserByName(String name) {
        adapter = new HibernateAdapter();
        SessionFactory sf = adapter.getAdapter();
        Session s = sf.openSession();
        s.beginTransaction();
       return (User) s.createQuery("SELECT u FROM User u WHERE u.name =:name").setParameter("name",name);

    }

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

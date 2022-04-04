package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private Session session;
    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {

       session = Util.getConnection().openSession();
       session.beginTransaction();
       session.createSQLQuery( "CREATE TABLE IF NOT EXISTS mybase.users" +
               " (id mediumint not null auto_increment, name VARCHAR(50), " +
                       "lastname VARCHAR(50), " +
                       "age tinyint, " +
                       "PRIMARY KEY (id));").executeUpdate();
       session.getTransaction().commit();
       session.close();
    }

    @Override
    public void dropUsersTable() {
        session = Util.getConnection().openSession();
        session.beginTransaction();
        session.createSQLQuery("DROP TABLE IF EXISTS mybase.users").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        session = Util.getConnection().openSession();
        session.beginTransaction();
        session.save(new User(name, lastName, age));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        session = Util.getConnection().openSession();
        session.beginTransaction();
        session.delete(session.get(User.class, id));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        session = Util.getConnection().openSession();
        session.beginTransaction();
        List <User> listUser = session.createQuery("from User").list();
        session.close();
        return listUser;
    }

    @Override
    public void cleanUsersTable() {
        session = Util.getConnection().openSession();
        session.beginTransaction();
        session.createQuery("delete from User").executeUpdate();
        session.getTransaction().commit();
        session.close();

    }
}

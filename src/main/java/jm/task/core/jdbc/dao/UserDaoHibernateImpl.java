package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {


    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {

        try(Session session = Util.getConnectionHibernate().getCurrentSession()) {
            session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF not exists user (" +
                " id INTEGER not null AUTO_INCREMENT, " +
                " name VARCHAR(255), " +
                " lastName VARCHAR(255), " +
                " age INTEGER, " +
                "PRIMARY KEY(id))").executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {

        try(Session session = Util.getConnectionHibernate().getCurrentSession()) {
            session.beginTransaction();
            session.createSQLQuery("DROP TABLE if EXISTS user").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name, lastName, age);
        try (Session session = Util.getConnectionHibernate().getCurrentSession()){
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeUserById(long id) {

        try(Session session = Util.getConnectionHibernate().getCurrentSession()) {
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM User WHERE id= :i");
            query.setParameter("i", id);
            query.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public List<User> getAllUsers() {
        List <User> users = null;
        try(Session session = Util.getConnectionHibernate().getCurrentSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from User");
            users = query.getResultList();
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {

        try(Session session = Util.getConnectionHibernate().getCurrentSession()) {
            session.beginTransaction();
            session.createSQLQuery("truncate table user").executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}

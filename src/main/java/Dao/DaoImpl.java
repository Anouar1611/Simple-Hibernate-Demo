package Dao;

import Models.App;
import Models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class DaoImpl {
    @Autowired
    private SessionFactory sessionFactory;
    public void saveUser(User user, String name){
        user.setName(name);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    public void saveUserListApp(User user,App app1, App app2, String nameUser,String nameApp1,String nameApp2){
        app1.setAppName(nameApp1);
        app2.setAppName(nameApp2);
        user.getApp().add(app1);
        user.getApp().add(app2);
        user.setName(nameUser);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.save(app1);
        session.save(app2);
        session.getTransaction().commit();
    }

    /*public void saveUserAndApp(User user1,User user2,App app1, App app2, String nameUser1,String nameUser2,String nameApp1,String nameApp2){
        app1.setAppName(nameApp1);
        app2.setAppName(nameApp2);
        app1.getUser().add(user1);
        app2.getUser().add(user1);
        user1.getApp().add(app1);
        user1.getApp().add(app2);
        user1.setName(nameUser1);
        user2.setName(nameUser2);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user1);
        session.save(user2);
        session.save(app1);
        session.save(app2);
        session.getTransaction().commit();

    }*/

    public void saveUserWithCascade(User user1,App app1, App app2, String nameUser1,String nameApp1,String nameApp2){
        user1.getApp().add(app1);
        user1.getApp().add(app2);
        app1.setAppName(nameApp1);
        app2.setAppName(nameApp2);
        user1.setName(nameUser1);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(user1);
        session.getTransaction().commit();

    }

    /*public void saveUserApp(User user,String nameUser,String nameApp){
        App app = new App();
        app = user.getApp();
        app.setAppName(nameApp);
        user.setName(nameUser);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.save(app);
        session.getTransaction().commit();
    }*/

    public User getUserById(int Id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class,Id);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    public void deleteUserById(User user,int Id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        user = session.get(User.class,Id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
        System.out.println("Succesfully deleted");
    }


}

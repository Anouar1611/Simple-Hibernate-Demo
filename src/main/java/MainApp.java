import Dao.DaoImpl;
import Models.App;
import Models.User;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainApp {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(HibernateConfig.class);
        SessionFactory sessionFactory =  ctx.getBean("sessionFactory",SessionFactory.class);
        User user = ctx.getBean("user",User.class);
        DaoImpl daoImpl = ctx.getBean("daoImpl",DaoImpl.class);
        App app = ctx.getBean("app",App.class);
        App app1 = new App();
        /*daoImpl.saveUser(user,"Anouar");
        daoImpl.saveUser(user1,"Simo");*/
        //app.setAppName("Telegram");
        //user.setApp(app);
        app1.setUser(user);
        daoImpl.saveUserListApp(user,app,app1,"Anouar","Instagram","Telegram");
        //daoImpl.saveUserWithCascade(user,app,app1,"Anouar","Whatsapp","Faccebook");
        //user = daoImpl.getUserById(1);
        //System.out.println(user.getName());
        //daoImpl.deleteUserById(user,2);

    }
}

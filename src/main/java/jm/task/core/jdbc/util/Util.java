package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;


import javax.imageio.spi.ServiceRegistry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Util {

    private static SessionFactory sessionFactory = null;

    private final static String HOST = "jdbc:mysql://localhost:3306/user";
    private final static String USERNAME = "root";

    private final static String PASSWORD = "466539";

    private static Connection connection;

    public static Connection getConnection() {

        try {
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void getConnectionHib(){

    }

    public static SessionFactory getConnectionHibernate(){

        if(sessionFactory == null) {

            try {

                Configuration configuration = new Configuration()
                        .addAnnotatedClass(User.class);
                Properties settings = new Properties();
                settings.put(Environment.DRIVER,  "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/user?useSSL=false");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "466539");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "create-drop");
                configuration.setProperties(settings);

                sessionFactory = configuration.buildSessionFactory();

            } catch (Exception e) {
                e.printStackTrace();

            }
        }

        return sessionFactory;
    }
}

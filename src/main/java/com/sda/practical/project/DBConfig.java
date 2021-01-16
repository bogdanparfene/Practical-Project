package com.sda.practical.project;



import com.sda.practical.project.model.AccountModel;
import com.sda.practical.project.model.AccountModel;
import com.sda.practical.project.model.TransactionModel;
import com.sda.practical.project.model.UserModel;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class DBConfig {
    private SessionFactory sessionFactory; //variabila pe care o folosim ca sa deschidem sesiunea

    public DBConfig() {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/aplicatiebancara");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "12345");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        properties.put(Environment.SHOW_SQL, "true");

        properties.put(Environment.HBM2DDL_AUTO, "update");
        configuration.addAnnotatedClass(UserModel.class);
        configuration.addAnnotatedClass(AccountModel.class);
        configuration.addAnnotatedClass(TransactionModel.class);

        configuration.setProperties(properties);

        ServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

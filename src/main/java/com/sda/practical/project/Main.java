package com.sda.practical.project;

import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        DBConfig dbConfig = new DBConfig();
        SessionFactory sessionFactory = dbConfig.getSessionFactory();
    }
}
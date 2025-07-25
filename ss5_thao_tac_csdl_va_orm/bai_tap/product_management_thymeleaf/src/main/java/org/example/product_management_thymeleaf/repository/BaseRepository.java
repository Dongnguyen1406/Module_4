package org.example.product_management_thymeleaf.repository;



import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class BaseRepository {
    public static SessionFactory sessionFactory;
    public static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();  // DI CHUYỂN lên đây
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}

package iot.lviv.ua.utils;

import iot.lviv.ua.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(AddressEntity.class);
                configuration.addAnnotatedClass(ArtistEntity.class);
                configuration.addAnnotatedClass(CredentialEntity.class);
                configuration.addAnnotatedClass(EventEntity.class);
                configuration.addAnnotatedClass(OrderEventEntity.class);
                configuration.addAnnotatedClass(OrderPassageEntity.class);
                configuration.addAnnotatedClass(PassageEntity.class);
                configuration.addAnnotatedClass(TicketEventEntity.class);
                configuration.addAnnotatedClass(TicketPassageEntity.class);
                configuration.addAnnotatedClass(UserEntity.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Exception" + e);
            }
        }
        return sessionFactory;
    }
}

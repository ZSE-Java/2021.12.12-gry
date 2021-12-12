package pl.edu.zse.gry.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.zse.gry.dao.IUserDAO;
import pl.edu.zse.gry.model.User;

import javax.persistence.NoResultException;
import java.util.Optional;

@Repository
public class UserDAO implements IUserDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Optional<User> getUserByLogin(String login) {
        Session session = this.sessionFactory.openSession();
        Query<User> query = session
                .createQuery("FROM pl.edu.zse.gry.model.User WHERE login = :login");
        query.setParameter("login", login);
        try {
            User user = query.getSingleResult();
            session.close();
            return Optional.of(user);
        } catch (NoResultException e) {
            session.close();
            return Optional.empty();
        }

    }
}

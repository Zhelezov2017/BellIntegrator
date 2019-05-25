package ru.mithril.demo.dao.implementation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mithril.demo.dao.daoInterface.UserDao;
import ru.mithril.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;



/**
 * {@inheritDoc}
 */
@Repository
@Data
public class UsersDaoJdbcTemplateImpl implements UserDao {




    private final EntityManager em;
    @Autowired
    public UsersDaoJdbcTemplateImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> users(User user){
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User find(Long id) {
        return em.find(User.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(User user) {
        em.persist(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(User user) {
        em.persist(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Long id) {
        em.remove(id);
    }




}

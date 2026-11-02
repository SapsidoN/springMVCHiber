package org.example.dao;

import org.example.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u",User.class).getResultList();
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);

    }

    @Override
    public void deleteUser(Long id) {
        User user = getUser(id);

        if (user != null) {
            entityManager.remove(user);
        }

    }
}

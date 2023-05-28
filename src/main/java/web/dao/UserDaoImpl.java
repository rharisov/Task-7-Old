package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoImpl() {
    }

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public User getUserById(long id) {
        try {
            return entityManager.createQuery("FROM User where id=:id", User.class).setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
}

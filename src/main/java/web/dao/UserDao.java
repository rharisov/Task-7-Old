package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    User getUserById(long id);

    void addUser(User user);

    void deleteUser(long id);

    void updateUser(User user);
}

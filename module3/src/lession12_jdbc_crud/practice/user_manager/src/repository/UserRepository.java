package repository;

import model.User;

import java.util.List;

public interface UserRepository {
    void create(User user); // Crud

    User findById(int id); // cRud

    List<User> findAll(); // cRud

    void update(int id, User user); // crUd

    void remove(int id); // cruD
}

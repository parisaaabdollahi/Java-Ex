package service;

import entity.User;
import repository.UserDA;

import java.util.List;

public class UserService {
    private UserService() {
    }

    ;
    private static final UserService USER_SERVICE = new UserService();

    public static UserService getInstance() {
        return USER_SERVICE;
    }

    public User login(User user) throws Exception {
        try (UserDA userDA = new UserDA()) {
            return userDA.selectByEmployeeCodeAndPassword(user);
        }
    }

    public void save(User user) throws Exception {
        try (UserDA userDA = new UserDA()) {
            userDA.insert(user);
            userDA.commit();
        }
    }

    public void update(User user) throws Exception {
        try (UserDA userDA = new UserDA()) {
            userDA.update(user);
            userDA.commit();
        }
    }
    public void remove(User user) throws Exception {
        try (UserDA userDA = new UserDA()) {
            userDA.delete(user);
            userDA.commit();
        }
    }

    public List<User> findAll() throws Exception {
        try (UserDA userDA = new UserDA()) {
            return userDA.selectAll();
        }
    }
}

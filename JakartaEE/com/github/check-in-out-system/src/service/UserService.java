package service;

import entity.User;
import repository.UserDA;

public class UserService {
    private UserService(){};
    private static final UserService USER_SERVICE=new UserService();
    public static UserService getInstance(){return  USER_SERVICE;}

    public void login(User user) throws Exception {
        try(UserDA userDA =new UserDA()){
            userDA.selectByEmployeeCodeAndPassword(user);
        }
    }
}

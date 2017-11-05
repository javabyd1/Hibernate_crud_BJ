package com.mojafirma;


import com.mojafirma.implement.UserDaoImp;
import com.mojafirma.interfaces.UserDao;
import com.mojafirma.model.User;

public class Main {
    public static void main(String[] args) {

        UserDaoImp userDaoImp = new UserDaoImp();
        User user = new User();
        user.setName("jan");
        user.setSurname("kowalski");

        User user1 = new User();
        user1.setName("andrzej");
        user1.setSurname("kowalski");

        userDaoImp.insertUser(user);
        userDaoImp.insertUser(user1);
    }
}

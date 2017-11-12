package com.mojafirma;

import com.mojafirma.implement.UserDAOImpl;
import com.mojafirma.model.User;
import com.mojafirma.utility.HibernateUtility;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {

        UserDAOImpl userDaoImpl = new UserDAOImpl();
        User user = new User();
        user.setName("jan");
        user.setSurname("kowalski");

        User user1 = new User();
        user1.setName("andrzej");
        user1.setSurname("kowalski");

        userDaoImpl.insertUser(user);
        userDaoImpl.insertUser(user1);

        HibernateUtility.getHibernateSession().getSessionFactory().close();
    }
}

package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {
//        Util.getConnectionHib();
        UserService user = new UserServiceImpl();
        user.createUsersTable();
        user.saveUser("Name1", "LastName1", (byte) 20);
        System.out.println(user.getAllUsers().get(0).getName());
        user.saveUser("Name2", "LastName2", (byte) 25);
        System.out.println(user.getAllUsers().get(1).getName());
        user.saveUser("Name3", "LastName3", (byte) 31);
        System.out.println(user.getAllUsers().get(2).getName());
        System.out.println(user.getAllUsers());

        user.removeUserById(1);
        user.cleanUsersTable();
        user.dropUsersTable();


//        ====== UserDaoJDBCImpl ======
//        UserDao userDao = new UserDaoJDBCImpl();
//
//        userDao.createUsersTable();
//
//        userDao.saveUser("Name1", "LastName1", (byte) 20);
//        System.out.println(userDao.getAllUsers().get(1).getName());
//        userDao.saveUser("Name2", "LastName2", (byte) 25);
//        System.out.println(userDao.getAllUsers().get(2).getName());
//        userDao.saveUser("Name3", "LastName3", (byte) 31);
//        System.out.println(userDao.getAllUsers().get(3).getName());
//        userDao.saveUser("Name4", "LastName4", (byte) 38);
//        System.out.println(userDao.getAllUsers().get(4).getName());
//
//
//        System.out.println(userDao.getAllUsers());
//        userDao.cleanUsersTable();
//        userDao.dropUsersTable();

    }
}

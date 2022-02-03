package Advances.Generic;

// https://www.youtube.com/watch?v=SqqPjmtseSs&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=575

/** test for dao2.DAO */

import Advances.Generic.dao2.*;

import java.util.List;

public class demo9 {
    public static void main(String[] args) {
        Advances.Generic.dao2.DAO<User> dao = new Advances.Generic.dao2.DAO<User>();

        // save
        dao.save("1001", new User(1001,20,"iori"));
        dao.save("1002", new User(1002,17,"kyo"));
        dao.save("1003", new User(1003,88,"mary"));

        List<User> user = dao.list();
        // method 1
        System.out.println(user);

        System.out.println("==========");

        // method 2 : forEach (new since java 8)
        user.forEach(System.out::println);

        System.out.println("==========");

        // update
        dao.update("1003", new User(1003, 30, "kk"));
        List<User> user2 = dao.list();
        System.out.println(user2);

        System.out.println("==========");

        // delete
        dao.delete("1002");
        List<User> user3 = dao.list();
        System.out.println(user3);
    }
}

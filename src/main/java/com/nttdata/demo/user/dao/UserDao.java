package com.nttdata.demo.user.dao;

import com.nttdata.demo.user.entity.TypeDoc;
import com.nttdata.demo.user.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public static User findByCc(String cc){
        List<User> users = new ArrayList<>();
        User user1 = new User(
                1,
                TypeDoc.CC,
                "1013623647",
                "Reinel",
                "Steven",
                "Bolaños",
                "Martinez",
                "3184090989",
                "Calle 13 sur 24g 38",
                "Bogota"
        );
        User user2 = new User(
                2,
                TypeDoc.CC,
                "23445322",
                "Jose",
                "Maria",
                "Mendez",
                "Morales",
                "3103101122",
                "Calle 123 22 33",
                "Bogota"
        );
        users.add(user1);
        users.add(user2);
        User result = null;
        for (User user : users){
            if(cc.equalsIgnoreCase(user.getDoc())){
                result = user;
                break;
            }
        }
        return result;
    }
}

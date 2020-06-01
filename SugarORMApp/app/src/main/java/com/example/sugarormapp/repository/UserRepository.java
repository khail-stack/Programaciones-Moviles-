package com.example.sugarormapp.repository;

import com.example.sugarormapp.models.User;
import com.orm.SugarRecord;

import java.util.List;

public class UserRepository {

    public static List<User> list(){
        List<User> users = SugarRecord.listAll(User.class);
        return users;
    }

    public static User read(Long id){
        User user = SugarRecord.findById(User.class, id);
        return user;
    }

    public static void create(String fullname, String email, String password, String image){
        User user = new User(fullname, email, password, image);
        SugarRecord.save(user);
    }

    public static void update(String fullname, String email, String password, String image, Long id){
        User user = SugarRecord.findById(User.class, id);
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPassword(password);
        user.setImage(image);
        SugarRecord.save(user);
    }

    public static void delete(Long id){
        User user = SugarRecord.findById(User.class, id);
        SugarRecord.delete(user);
    }

}

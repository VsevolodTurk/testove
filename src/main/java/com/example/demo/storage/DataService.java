package com.example.demo.storage;

import com.example.demo.entity.User;

import java.util.List;

public interface DataService {

    List<User> findByUserId(int userId);

    List<User> findByLevelId(int levelId);

    void saveUser(User user);
}

package com.example.demo.storage;

import com.example.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface DataService {

    Optional<List<User>> findByUserId(int userId);

    Optional<List<User>> findByLevelId(int levelId);

    void saveUser(User user);
}

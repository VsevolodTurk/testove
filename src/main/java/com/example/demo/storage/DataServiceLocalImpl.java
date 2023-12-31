package com.example.demo.storage;

import com.example.demo.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DataServiceLocalImpl implements DataService {

    private static Set<User> storage = Collections.synchronizedSet(new HashSet<>());

    @Override
    public List<User> findByUserId(int userId) {
        return storage.stream().filter(user -> user.getUserId() == userId).collect(Collectors.toList());
    }

    @Override
    public List<User> findByLevelId(int levelId) {
        return storage.stream().filter(user -> user.getLevelId() == levelId).collect(Collectors.toList());
    }

    @Override
    public void saveUser(User user) {
        storage.add(user);
    }
}

package com.example.demo.service;

import com.example.demo.dto.UserRestDto;
import com.example.demo.entity.User;
import com.example.demo.storage.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final DataService dataService;

    @Autowired
    public UserService(DataService dataService) {
        this.dataService = dataService;
    }

    public synchronized void saveUserInfo(UserRestDto userDto) {
        dataService.saveUser(convertUSerDtoToUser(userDto));
    }

    private User convertUSerDtoToUser(UserRestDto userDto) {
        return new User(userDto.getResult(), userDto.getUserId(), userDto.getLevelId());
    }

    public synchronized List<UserRestDto> getTop20UserInfoByUserId(Integer userId) {
        return dataService.findByUserId(userId)
                .stream()
                .sorted(Comparator.comparing(User::getResult).thenComparing(User::getLevelId).reversed())
                .map(convertUserToUserRestDtoFunction())
                .limit(20)
                .collect(Collectors.toList());
    }

    public synchronized List<UserRestDto> getTop20UserInfoByLevelId(Integer levelId) {
        return dataService.findByLevelId(levelId)
                .stream()
                .sorted(Comparator.comparing(User::getResult).thenComparing(User::getUserId).reversed())
                .map(convertUserToUserRestDtoFunction())
                .limit(20)
                .collect(Collectors.toList());
    }

    private Function<User, UserRestDto> convertUserToUserRestDtoFunction() {
        return user -> new UserRestDto(user.getResult(), user.getUserId(), user.getLevelId());
    }
}

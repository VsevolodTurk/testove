package com.example.demo.web.api.rest;

import com.example.demo.dto.UserRestDto;
import com.example.demo.service.UserService;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/user")
@Slf4j
@RequiredArgsConstructor
public class UserRestControllers {

    private UserService userService;

    @Autowired
    public UserRestControllers(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userinfo/{user_id}")
    public List<UserRestDto> getUserInfo(@PathVariable @NonNull @Positive Integer user_id) {
        return userService.getTop20UserInfoByUserId(user_id);
    }

    @GetMapping("/levelinfo/{level_id}")
    public List<UserRestDto> getLevelInfo(@PathVariable @NonNull @Positive Integer level_id) {
        return userService.getTop20UserInfoByLevelId(level_id);
    }

    @PutMapping("/setinfo")
    public void setUserInfo(@RequestBody UserRestDto userDto) {
        userService.saveUserInfo(userDto);
    }
}

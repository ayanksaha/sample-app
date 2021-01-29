package com.example.springboot.service;

import com.example.springboot.dao.UserEntity;
import com.example.springboot.dto.User;
import com.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String authorize(User user) {
        UserEntity userEntity =
                userRepository.findByUsernameAndPassword(user.getUserName(), user.getPassword());
        return (userEntity == null) ? "FAILURE" : "SUCCESS";
    }

    public UserEntity getUser(long id) {
        UserEntity userEntity = userRepository.findByUserId(id);
        return (userEntity == null) ?
                new UserEntity(0L, "NA", "NA") : userEntity;
    }

    public List<User> getAllUsers() {
        Iterable<UserEntity> users = userRepository.findAll();
        List<User> userList = new ArrayList<>();
        users.forEach(
                user -> {
                    User u = new User();
                    u.setUserId(user.getUserId());
                    u.setUserName(user.getUsername());
                    userList.add(u);
                }
        );
        return userList;
    }
}

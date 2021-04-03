package com.hsframework.core;

import com.hsframework.core.user.NConnectionMaker;
import com.hsframework.core.user.User;
import com.hsframework.core.user.UserRepository;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        User user = User.builder()
                .username("kent beck")
                .password("1234")
                .build();

        UserRepository userRepository = new UserRepository(new NConnectionMaker());
        userRepository.save(user);

        System.out.println("사용자 등록 성공 : " + user);

        User fetchedUser = userRepository.findByUsername(user.getUsername());

        System.out.println("사용자 조회 성공 : " + fetchedUser);
    }
}

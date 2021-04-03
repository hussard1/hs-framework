package com.hsframework.core;

import com.hsframework.core.user.*;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String username = "kent beck";
        String password = "1234";
        User user = User.builder()
                .username(username)
                .password(password)
                .build();

        UserRepository userRepository = new ConnectionFactory().userRepository();
        userRepository.save(user);

        System.out.println("사용자 등록 성공 : " + user);

        User savedUser = userRepository.findByUsername(user.getUsername());

        System.out.println("사용자 조회 성공 : " + savedUser);


        UserUpdateRepository userUpdateRepository = new ConnectionFactory().userUpdateRepository();

        String newPassword = "4321";
        userUpdateRepository.updatePassword(username, newPassword);

        User updatedUser = userRepository.findByUsername(user.getUsername());
        System.out.println("사용자 업데이트 성공 : " + updatedUser);


        UserDeleteRepository userDeleteRepository = new ConnectionFactory().userDeleteRepository();
        userDeleteRepository.deleteByUsername(user.getUsername());
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new IllegalStateException("삭제 테스트 실패");
        }
        System.out.println("사용자 삭제 성공");
    }
}

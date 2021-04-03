package com.hsframework.core.user;

public class ConnectionFactory {

    public UserRepository userRepository() {
        return new UserRepository(new NConnectionMaker());
    }

    public UserRepository userRepository2() {
        return new UserRepository(new DConnectionMaker());
    }

    public UserUpdateRepository userUpdateRepository() {
        return new UserUpdateRepository(new DConnectionMaker());
    }

    public UserDeleteRepository userDeleteRepository() {
        return new UserDeleteRepository(new DConnectionMaker());
    }
}

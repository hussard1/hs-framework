package com.hsframework.core.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class User {
    private long id;
    private String username;
    private String password;
}

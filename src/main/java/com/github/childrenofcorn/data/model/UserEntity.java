package com.github.childrenofcorn.data.model;

import lombok.Getter;

/**
 * Created by grishberg on 15.04.17.
 */
@Getter
public class UserEntity {
    private final long id;
    private final String name;
    private final String accessToken;

    public UserEntity(long id, String name, String accessToken) {
        this.id = id;
        this.name = name;
        this.accessToken = accessToken;
    }
}
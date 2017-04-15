package com.github.childrenofcorn.data.model;

import lombok.Getter;

/**
 * Created by grishberg on 15.04.17.
 */
@Getter
public class UserInfo {
    private final long id;
    private final String name;

    public UserInfo(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfo userInfo = (UserInfo) o;

        if (id != userInfo.id) return false;
        return name != null ? name.equals(userInfo.name) : userInfo.name == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
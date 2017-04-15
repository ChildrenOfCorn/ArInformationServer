package com.github.childrenofcorn.services.accounts;

import com.github.childrenofcorn.data.model.UserInfo;
import lombok.NonNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by grishberg on 15.04.17.
 */
public class AccountServiceInMemoryImpl implements AccountService {
    private final AtomicLong userId = new AtomicLong();
    private final Map<Long, UserInfo> userAccessTokens = new ConcurrentHashMap<>();

    @Override
    public UserInfo registerUser(@NonNull String userName) {

        for (Map.Entry<Long, UserInfo> entry : userAccessTokens.entrySet()) {
            UserInfo userEntity = entry.getValue();
            if (userEntity.getName().equals(userName)) {
                return userEntity;
            }
        }

        long id = userId.incrementAndGet();
        UserInfo user = new UserInfo(id, userName);
        userAccessTokens.put(id, user);
        return user;
    }

    @Override
    public UserInfo getUserById(long userId) {
        return userAccessTokens.get(userId);
    }
}

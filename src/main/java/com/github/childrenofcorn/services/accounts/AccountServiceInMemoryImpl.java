package com.github.childrenofcorn.services.accounts;

import com.github.childrenofcorn.data.model.UserEntity;
import lombok.NonNull;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by grishberg on 15.04.17.
 */
public class AccountServiceInMemoryImpl implements AccountService {
    private final AtomicLong userId = new AtomicLong();
    private final Map<String, UserEntity> userAccessTokens = new ConcurrentHashMap<>();

    @Override
    public UserEntity registerUser(@NonNull String userName) {
        String accessToken = UUID.randomUUID().toString();
        UserEntity user = new UserEntity(userId.incrementAndGet(), userName, accessToken);
        userAccessTokens.put(accessToken, user);
        return user;
    }

    @Override
    public UserEntity getUserByAccessToken(@NonNull String accessToken) {
        return userAccessTokens.get(accessToken);
    }
}

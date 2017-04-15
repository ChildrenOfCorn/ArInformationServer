package com.github.childrenofcorn.services.accounts;

import com.github.childrenofcorn.data.model.UserEntity;

/**
 * Created by grishberg on 15.04.17.
 */
public interface AccountService {
    UserEntity registerUser(String userName);

    UserEntity getUserByAccessToken(String accessToken);
}

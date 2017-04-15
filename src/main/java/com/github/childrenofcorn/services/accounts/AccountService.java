package com.github.childrenofcorn.services.accounts;

import com.github.childrenofcorn.data.model.UserInfo;

/**
 * Created by grishberg on 15.04.17.
 */
public interface AccountService {
    UserInfo registerUser(String userName);

    UserInfo getUserById(long userId);
}

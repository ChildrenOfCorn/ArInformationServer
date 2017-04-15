package com.github.childrenofcorn.services.link;

import com.github.childrenofcorn.data.model.UserInfo;

import java.util.List;

/**
 * Created by grishberg on 15.04.17.
 */
public interface LinkService {
    void linkUserToProduct(long productId, UserInfo user);

    List<UserInfo> getVisitedUsers(long productId);
}

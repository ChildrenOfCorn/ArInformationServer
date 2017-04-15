package com.github.childrenofcorn.services.link;

import com.github.childrenofcorn.data.model.UserInfo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * Created by grishberg on 15.04.17.
 */
@SuppressWarnings("unused")
public class LinkServiceImpl implements LinkService {
    private final Map<Long, Set<UserHolder>> visitedUsers = new ConcurrentHashMap<>();

    @Override
    public void linkUserToProduct(long productInfo, UserInfo user) {
        Set<UserHolder> userHolders = visitedUsers.computeIfAbsent(productInfo, new Function<Long, Set<UserHolder>>() {
            @Override
            public Set<UserHolder> apply(Long productId) {
                return new HashSet<>();
            }
        });
        userHolders.add(new UserHolder(user, new Date().getTime()));
    }

    @Override
    public List<UserInfo> getVisitedUsers(long productId) {
        ArrayList<UserInfo> usersArray = new ArrayList<>();
        Set<UserHolder> userHolders = visitedUsers.get(productId);
        if (userHolders != null) {
            for (UserHolder userHolder : userHolders) {
                usersArray.add(userHolder.user);
            }
        }
        return usersArray;
    }

    private static class UserHolder {
        UserInfo user;
        long visitedDate;

        UserHolder(UserInfo user, long visitedDate) {
            this.user = user;
            this.visitedDate = visitedDate;
        }
    }
}

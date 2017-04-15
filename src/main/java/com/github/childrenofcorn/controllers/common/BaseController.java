package com.github.childrenofcorn.controllers.common;

import com.github.childrenofcorn.data.model.ProductInfo;
import com.github.childrenofcorn.data.model.UserInfo;
import com.github.childrenofcorn.exception.AppException;
import com.github.childrenofcorn.services.accounts.AccountService;
import com.github.childrenofcorn.services.comment.CommentService;
import com.github.childrenofcorn.services.info.InfoService;
import com.github.childrenofcorn.services.link.LinkService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by grishberg on 15.04.17.
 */
@SuppressWarnings("unused")
public class BaseController {
    @Autowired
    protected AccountService accountService;

    @Autowired
    protected InfoService infoService;

    @Autowired
    protected CommentService commentService;

    @Autowired
    protected LinkService linkService;

    protected ProductInfo getProductInfoById(long productId) throws AppException.WrongProductIdException {
        ProductInfo productInfo = infoService.getProductInfoByProductId(productId);
        if (productInfo == null) {
            throw new AppException.WrongProductIdException();
        }
        return productInfo;
    }

    protected UserInfo getUserById(@NonNull long userId) throws AppException.WrongAccessTokenException {
        UserInfo user = accountService.getUserById(userId);
        if (user == null) {
            throw new AppException.WrongAccessTokenException();
        }
        return user;
    }
}


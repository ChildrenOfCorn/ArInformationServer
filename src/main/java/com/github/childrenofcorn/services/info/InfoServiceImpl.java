package com.github.childrenofcorn.services.info;

import com.github.childrenofcorn.data.model.ProductInfo;
import com.github.childrenofcorn.services.comment.CommentService;
import com.github.childrenofcorn.services.link.LinkService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by grishberg on 15.04.17.
 */
public class InfoServiceImpl implements InfoService {
    private static final int INITIAL_CAPACITY = 20;
    @Autowired
    private CommentService commentService;
    @Autowired
    private LinkService linkService;
    private final Map<Long, ProductInfo> productInfoMap = new ConcurrentHashMap<>(INITIAL_CAPACITY);

    @Override
    public ProductInfo getProductInfoByProductId(long productId) {
        ProductInfo productInfo = productInfoMap.get(productId);
        if (productInfo != null) {
            productInfo.setComments(commentService.getCommentsByProductId(productId));
            productInfo.setUsers(linkService.getVisitedUsers(productId));
        }
        return productInfo;
    }

    @Override
    public void addProductInfo(long productId, ProductInfo productInfo) {
        productInfoMap.put(productId, productInfo);
    }
}

package com.github.childrenofcorn.services.info;

import com.github.childrenofcorn.data.model.ProductInfo;

/**
 * Created by grishberg on 15.04.17.
 */
public interface InfoService {
    ProductInfo getProductInfoByProductId(long productId);

    void addProductInfo(long productId, ProductInfo productInfo);
}

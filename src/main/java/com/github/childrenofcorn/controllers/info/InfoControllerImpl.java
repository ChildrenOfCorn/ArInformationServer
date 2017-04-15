package com.github.childrenofcorn.controllers.info;

import com.github.childrenofcorn.common.RUtils;
import com.github.childrenofcorn.controllers.common.BaseController;
import com.github.childrenofcorn.data.model.ProductInfo;
import com.github.childrenofcorn.exception.AppException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by grishberg on 15.04.17.
 */
@RestController
@SuppressWarnings("unused")
public class InfoControllerImpl extends BaseController implements InfoController {
    @Override
    public Map getProductInfo(HttpServletRequest request,
                              @RequestParam long userId,
                              @RequestParam long productId) throws AppException.WrongProductIdException {
        ProductInfo productInfo = infoService.getProductInfoByProductId(productId);
        return RUtils.success(productInfo);
    }
}

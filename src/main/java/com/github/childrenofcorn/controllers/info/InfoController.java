package com.github.childrenofcorn.controllers.info;

import com.github.childrenofcorn.common.Const;
import com.github.childrenofcorn.exception.AppException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by grishberg on 15.04.17.
 */
@RestController
@RequestMapping(value = Const.VER)
public interface InfoController {
    @RequestMapping(value = "/getProductInfo")
    Map getProductInfo(HttpServletRequest request,
                       @RequestParam long userId,
                       @RequestParam long productId) throws AppException.WrongProductIdException;
}

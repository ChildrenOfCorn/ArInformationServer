package com.github.childrenofcorn.controllers.auth;

import com.github.childrenofcorn.common.Const;
import com.github.childrenofcorn.exception.AppException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by grishberg on 15.04.17.
 */
@RestController
@RequestMapping(value = Const.VER)
public interface AuthController {

    @RequestMapping(value = "/registerUser", method = POST)
    Map registerUser(HttpServletRequest request,
                       @RequestParam String name) throws AppException.WrongProductIdException;

}

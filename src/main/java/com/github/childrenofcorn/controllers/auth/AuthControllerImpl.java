package com.github.childrenofcorn.controllers.auth;

import com.github.childrenofcorn.common.RUtils;
import com.github.childrenofcorn.controllers.common.BaseController;
import com.github.childrenofcorn.data.model.UserInfo;
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
public class AuthControllerImpl extends BaseController implements AuthController {
    @Override
    public Map registerUser(HttpServletRequest request,
                            @RequestParam String name) throws AppException.WrongProductIdException {
        UserInfo newUser = accountService.registerUser(name);
        return RUtils.success(newUser);
    }
}

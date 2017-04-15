package com.github.childrenofcorn.controllers.comments;

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
public interface CommentController {
    @RequestMapping(value = "/postComment", method = POST)
    Map getComments(HttpServletRequest request,
                    @RequestParam long productId) throws AppException.WrongMeetingTokenException;

    Map postComment(HttpServletRequest request,
                    @RequestParam long userId,
                    @RequestParam long productId) throws AppException.WrongAccessTokenException;
}

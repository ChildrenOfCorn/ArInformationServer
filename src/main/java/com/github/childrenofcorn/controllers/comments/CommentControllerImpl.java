package com.github.childrenofcorn.controllers.comments;

import com.github.childrenofcorn.common.RUtils;
import com.github.childrenofcorn.controllers.common.BaseController;
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
public class CommentControllerImpl extends BaseController implements CommentController {
    @Override
    public Map getComments(HttpServletRequest request, @RequestParam long productId) throws AppException.WrongProductIdException {
        return RUtils.success(commentService.getCommentsByProductId(productId));
    }

    @Override
    public Map postComment(HttpServletRequest request,
                           @RequestParam long userId,
                           @RequestParam long productId,
                           @RequestParam String commentText,
                           @RequestParam float rating) throws AppException.WrongAccessTokenException {
        float newRating = commentService.addCommentToProduct(productId, userId, commentText, rating);
        return RUtils.success(newRating);
    }
}

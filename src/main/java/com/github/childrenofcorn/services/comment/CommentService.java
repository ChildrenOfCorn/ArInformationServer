package com.github.childrenofcorn.services.comment;

import com.github.childrenofcorn.data.model.Comment;

import java.util.List;

/**
 * Created by grishberg on 15.04.17.
 */
public interface CommentService {
    float getRatingForProduct(long productId);

    float addCommentToProduct(long productId, long userId, String commentText, float rating);

    List<Comment> getCommentsByProductId(long productId);
}

package com.github.childrenofcorn.services.comment;

import com.github.childrenofcorn.data.model.Comment;

import java.util.List;

/**
 * Created by grishberg on 15.04.17.
 */
public interface CommentService {
    void addCommentToProduct(long productId, long userId, String commentText);

    List<Comment> getCommentsByProductId(long productId);
}

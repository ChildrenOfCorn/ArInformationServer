package com.github.childrenofcorn.services.comment;

import com.github.childrenofcorn.data.model.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * Created by grishberg on 15.04.17.
 */
public class CommentServiceImpl implements CommentService {
    private final Map<Long, List<Comment>> commentsMap = new ConcurrentHashMap<>();

    @Override
    public void addCommentToProduct(long productId, long userId, String commentText) {
        List<Comment> commentsForProduct = commentsMap.computeIfAbsent(productId, new Function<Long, List<Comment>>() {
            @Override
            public List<Comment> apply(Long aLong) {
                return new ArrayList<>();
            }
        });
        Comment comment = new Comment(commentText);
        commentsForProduct.add(comment);
    }

    @Override
    public List<Comment> getCommentsByProductId(long productId) {
        return commentsMap.get(productId);
    }
}

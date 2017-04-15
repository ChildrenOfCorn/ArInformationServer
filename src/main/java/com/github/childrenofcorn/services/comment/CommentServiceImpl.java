package com.github.childrenofcorn.services.comment;

import com.github.childrenofcorn.data.model.Comment;
import com.github.childrenofcorn.data.model.UserInfo;
import com.github.childrenofcorn.services.accounts.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * Created by grishberg on 15.04.17.
 */
public class CommentServiceImpl implements CommentService {
    @Autowired
    private AccountService accountService;
    private final Map<Long, List<Comment>> commentsMap = new ConcurrentHashMap<>();

    @Override
    public float addCommentToProduct(long productId, long userId, String commentText, float rating) {
        List<Comment> commentsForProduct = commentsMap.computeIfAbsent(productId, new Function<Long, List<Comment>>() {
            @Override
            public List<Comment> apply(Long aLong) {
                return new ArrayList<>();
            }
        });
        UserInfo currentUser = accountService.getUserById(userId);
        Comment comment = new Comment(commentText, currentUser, rating);
        commentsForProduct.add(comment);
        return calculateNewRating(commentsForProduct);
    }

    @Override
    public float getRatingForProduct(long productId) {
        List<Comment> commentsForProduct = commentsMap.get(productId);
        if (commentsForProduct == null) {
            return 0;
        }
        return calculateNewRating(commentsForProduct);
    }

    private float calculateNewRating(List<Comment> commentsForProduct) {
        float rating = 0;
        for (Comment comment : commentsForProduct) {
            rating += comment.getRating();
        }
        if (commentsForProduct.size() > 0) {
            return rating / (float) commentsForProduct.size();
        }
        return 0;
    }

    @Override
    public List<Comment> getCommentsByProductId(long productId) {
        List<Comment> comments = commentsMap.get(productId);
        if (comments == null) {
            comments = new ArrayList<>();
        }
        return comments;
    }
}

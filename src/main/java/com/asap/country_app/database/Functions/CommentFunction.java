package com.asap.country_app.database.Functions;

import com.asap.country_app.database.user.Comment;
import com.asap.country_app.dto.CommentDto;

import java.util.function.Function;

public class CommentFunction {

    public static final Function<Comment, CommentDto> commentToCommentDTO = comment -> new CommentDto(
            comment.getCreated(),
            comment.getText(),
            comment.getUser(),
            comment.getLocation()
    );

    public static final Function<CommentDto, Comment> commentDTOToComment = commentDto -> new Comment(
            commentDto.getCreated(),
            commentDto.getText(),
            commentDto.getUser(),
            commentDto.getLocation()
    );
}

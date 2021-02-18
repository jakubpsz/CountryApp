package com.asap.country_app.controller;

import com.asap.country_app.dto.CommentDto;
import com.asap.country_app.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/addcomment")
    public CommentDto addComment(@RequestBody CommentDto commentDto) {

        return commentService.addComment(commentDto);
    }

}

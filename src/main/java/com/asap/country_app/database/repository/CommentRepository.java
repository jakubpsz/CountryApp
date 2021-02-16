package com.asap.country_app.database.repository;

import com.asap.country_app.database.user.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
}

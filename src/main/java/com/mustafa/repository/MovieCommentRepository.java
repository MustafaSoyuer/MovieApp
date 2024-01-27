package com.mustafa.repository;

import com.mustafa.entity.MovieComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieCommentRepository extends JpaRepository<MovieComment,Long> {
}

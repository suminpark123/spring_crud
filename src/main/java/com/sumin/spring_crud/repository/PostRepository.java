package com.sumin.spring_crud.repository;

import com.sumin.spring_crud.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}

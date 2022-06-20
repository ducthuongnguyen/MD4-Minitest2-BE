package com.codegym.service;

import com.codegym.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Optional;

public interface IPostService {
    Iterable<Post> findAll();

    Optional<Post> findById(Long id);

    Post save(Post post);

    void remove(Long id);

    void update(Post post);

    Page<Post> findAll(Pageable pageable);

    Iterable<Post> findAllByTitleContainingOrCreatedAt(String title, LocalDateTime createdAt);

    Iterable<Post> findAllByTitleContainingAndCreatedAtBetween(String title, LocalDateTime from, LocalDateTime to);
}

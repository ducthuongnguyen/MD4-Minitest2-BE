package com.codegym.service;

import com.codegym.model.Post;
import com.codegym.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PostServiceImpl implements IPostService {
    @Autowired
    IPostRepository postRepository;

    @Override
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void update(Post post) {

    }

    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Iterable<Post> findAllByTitleContainingOrCreatedAt(String title, LocalDateTime createdAt) {
        return postRepository.findAllByTitleContainingOrCreatedAt(title,createdAt);
    }

    @Override
    public Iterable<Post> findAllByTitleContainingAndCreatedAtBetween(String title, LocalDateTime from, LocalDateTime to) {
        return postRepository.findAllByTitleContainingAndCreatedAtBetween(title, from, to);
    }


}

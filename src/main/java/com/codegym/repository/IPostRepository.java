package com.codegym.repository;

import com.codegym.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface IPostRepository extends PagingAndSortingRepository<Post, Long> {
    Page<Post> findAll(Pageable pageable);

    Iterable<Post> findAllByTitleContainingOrCreatedAt(String title, LocalDateTime createdAt);

    @Query(value = "select * from posts where title like :title and created_at between :from and :to", nativeQuery = true)
    Iterable<Post> findAllByTitleContainingAndCreatedAtBetween(@Param("title")String title,@Param("from") LocalDateTime from,@Param("to") LocalDateTime to);

    Iterable<Post> findAllByCreatedAtLessThanEqualAndCreatedAtGreaterThanEqual(LocalDateTime from, LocalDateTime to);

}


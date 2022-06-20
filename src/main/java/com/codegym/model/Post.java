package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(pattern = "dd-mm-yyyy")
    private LocalDateTime createdAt;
    private int likes;

    public Post() {
    }

    public Post(Long id, String title, String content, LocalDateTime createdAt, int likes) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.likes = likes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}

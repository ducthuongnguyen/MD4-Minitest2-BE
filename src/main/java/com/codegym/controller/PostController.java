package com.codegym.controller;

import com.codegym.model.Post;
import com.codegym.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@CrossOrigin("*")
@RequestMapping("/posts")
public class PostController {

    @Autowired
    IPostService postService;

    @PostMapping()
    public ResponseEntity<Post> save(@RequestBody Post post) {
        post.setCreatedAt(LocalDateTime.now());
        return new ResponseEntity<>(postService.save(post), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Post>> findAll(@PageableDefault(value = 5) Pageable pageable) {
        return new ResponseEntity<>(postService.findAll(pageable), HttpStatus.OK);
    }

//    @GetMapping
//    public ResponseEntity<Iterable<Post>> findAllByTitleContainingOrCreatedAt() {
//        return new ResponseEntity<>(postService.findAllByTitleContainingOrCreatedAt(), HttpStatus.OK);
//    }

    @GetMapping("/find")
    public ResponseEntity<Iterable<Post>> findAllByCreatedAtBetween(@RequestParam String title, @RequestParam String from, @RequestParam String to) {
        if (from.equals("") && to.equals("")) {
            from = "1900-01-01T00:00:00";
            to = String.valueOf(LocalDateTime.now());
        }
        return new ResponseEntity<>(postService.findAllByTitleContainingAndCreatedAtBetween('%'+title+'%', LocalDateTime.parse(from),LocalDateTime.parse(to)), HttpStatus.OK);
    }
}

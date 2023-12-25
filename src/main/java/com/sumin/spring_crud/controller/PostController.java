package com.sumin.spring_crud.controller;


import com.sumin.spring_crud.model.Post;
import com.sumin.spring_crud.payload.PostDto;
import com.sumin.spring_crud.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")

public class PostController {

    private PostService postService;

    public PostController(PostService postService){

        this.postService = postService;
    }
    //게시물 등록
    @PostMapping("create")
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);

    }
    //게시물 불러오기(전체)
    @GetMapping("all")
    public ResponseEntity<List<Post>> getAllPosts(){

        return new ResponseEntity<>(postService.getAllPosts(),HttpStatus.OK);
    }
    //게시물 불러오기(상세)
    @GetMapping("{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id){
        return new ResponseEntity<>(postService.getPostById(id),HttpStatus.OK);

    }
    //게시물 수정
    @PutMapping("{id}")
    public ResponseEntity<PostDto> updatePostById(
            @PathVariable(name = "id") long id,
            @Valid @RequestBody PostDto postDto
    ){
        return new ResponseEntity<>(postService.updatePostById(id,postDto), HttpStatus.OK);
    }
    //게시물 삭제
    @DeleteMapping("{id}")
    public ResponseEntity<String> delatePostById(@PathVariable(name = "id") long id){
        return new ResponseEntity<>(postService.delatePostById(id),HttpStatus.OK);

    }

}

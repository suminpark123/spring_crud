package com.sumin.spring_crud.controller;


import com.sumin.spring_crud.payload.PostDto;
import com.sumin.spring_crud.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    //게시물 불러오기(상세)
    //게시물 수정
    //게시물 삭제
}

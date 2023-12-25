package com.sumin.spring_crud.service;

import com.sumin.spring_crud.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);
    String getAllPosts();


}

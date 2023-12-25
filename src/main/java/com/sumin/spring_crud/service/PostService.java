package com.sumin.spring_crud.service;

import com.sumin.spring_crud.model.Post;
import com.sumin.spring_crud.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<Post> getAllPosts();

    PostDto getPostById(long id);

    PostDto updatePostById(long id, PostDto postDto);
    String delatePostById(long id);


}

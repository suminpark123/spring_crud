package com.sumin.spring_crud.service.impl;


import com.sumin.spring_crud.model.Post;
import com.sumin.spring_crud.payload.PostDto;
import com.sumin.spring_crud.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.sumin.spring_crud.service.PostService;

@Service
public class PostServiceImpl implements PostService{

    private PostRepository postRepository;

    private ModelMapper mapper;

    public PostServiceImpl(PostRepository postRepository, ModelMapper mapper){

        this.postRepository = postRepository;
        this.mapper = mapper;
    }
    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto);
        Post newPost = postRepository.save(post);

        PostDto postResponse = mapToDTO(newPost);
        return postResponse;
    }


    @Override
    public String getAllPosts() {
        return null;
    }

    // convert Entity into DTO
    private PostDto mapToDTO(Post post){
        PostDto postDto = mapper.map(post, PostDto.class);
        return postDto;
    }

    // convert DTO to entity
    private Post mapToEntity(PostDto postDto){
        Post post = mapper.map(postDto, Post.class);
        return post;
    }

}

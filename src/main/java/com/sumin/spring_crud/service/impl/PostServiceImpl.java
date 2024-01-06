package com.sumin.spring_crud.service.impl;


import com.sumin.spring_crud.exception.ResourceNotFoundException;
import com.sumin.spring_crud.model.Category;
import com.sumin.spring_crud.model.Post;
import com.sumin.spring_crud.payload.PostDto;
import com.sumin.spring_crud.payload.PostResponse;
import com.sumin.spring_crud.repository.CategoryRepository;
import com.sumin.spring_crud.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.sumin.spring_crud.service.PostService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    private PostRepository postRepository;

    private CategoryRepository categoryRepository;

    private ModelMapper mapper;

    public PostServiceImpl(PostRepository postRepository, CategoryRepository categoryRepository, ModelMapper mapper){

        this.categoryRepository = categoryRepository;
        this.postRepository = postRepository;
        this.mapper = mapper;
    }
    @Override
    public PostDto createPost(PostDto postDto) {
        Category category = categoryRepository
                .findById(postDto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", postDto.getCategoryId()));


        Post post = mapToEntity(postDto);
        post.setCategory(category);
        Post newPost = postRepository.save(post);

        PostDto postResponse = mapToDTO(newPost);
        return postResponse;
    }

    @Override
    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> posts = postRepository.findAll(pageable);

        List<Post> listOfPosts = posts.getContent();

        List<PostDto> contents = listOfPosts.stream().map((post) -> mapToDTO(post)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContents(contents);
        postResponse.setPageNo(posts.getNumber());
        postResponse.setPageSize(postResponse.getTotalPages());
        postResponse.setTotalElements(postResponse.getTotalElements());
        postResponse.setTotalPages(postResponse.getTotalPages());
        postResponse.setLast(posts.isLast());

        return postResponse;
    }


//    @Override
//    public List<PostDto> getAllPosts() {
//        List<Post> posts= postRepository.findAll();
//        return posts.stream().map((post) -> mapper.map(post, PostDto.class))
//                .collect(Collectors.toList());
//
//    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("post", "id", id));
        return mapToDTO(post);
    }

    @Override
    public PostDto updatePostById(long id, PostDto postDto) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("post","id", id));

        System.out.println(post);
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post updatedPost = postRepository.save(post);
        return mapToDTO(updatedPost);
    }

    @Override
    public String delatePostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("post","id",id));
        postRepository.delete(post);
        return "Delated";
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

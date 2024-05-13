package com.graphica.restapi.service.impl;

import com.graphica.restapi.dtos.PostDto;
import com.graphica.restapi.entity.Post;
import com.graphica.restapi.exception.ResourceNotFoundException;
import com.graphica.restapi.mapper.PostMapper;
import com.graphica.restapi.repository.PostRepository;
import com.graphica.restapi.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

import static com.graphica.restapi.mapper.PostMapper.mapToPostDto;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;



    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = PostMapper.mapToPost(postDto);
       Post savedPost = postRepository.save(post);
        return mapToPostDto(savedPost);
    }

    @Override
    public List<PostDto> getAllPosts(int pageNo, int pageSize) {

        // create Pageable instance
        Pageable pageable= PageRequest.of(pageNo,pageSize);
        Page<Post> posts = postRepository.findAll(pageable);

        // get content for page object
        List<Post> listOfPosts = posts.getContent();
        return listOfPosts.stream().map(post -> mapToPostDto(post)).collect(Collectors.toList());

    }

    @Override
    public PostDto getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Post", "id", id));
        return mapToPostDto(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Long id) {
        // get post by id from the database
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post","id",id));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        Post updatedPost = postRepository.save(post);
        return mapToPostDto(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post","id",id));
        postRepository.delete(post);
    }
}
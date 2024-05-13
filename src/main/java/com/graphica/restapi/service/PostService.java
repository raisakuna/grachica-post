package com.graphica.restapi.service;

import com.graphica.restapi.dtos.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPosts(int pageNo, int pageSize);

    PostDto getPostById(Long id);

    PostDto updatePost(PostDto postDto,Long id);

    void deletePostById(long id);
}

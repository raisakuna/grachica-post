package com.graphica.restapi.mapper;

import com.graphica.restapi.dtos.PostDto;
import com.graphica.restapi.entity.Post;

/**
 * PostMapper can be called as a Utitlity class. It doesn't have any state(properties). It only
 * has 2 static methods.
 */
public class PostMapper {

    // Convert Entity into DTO
    public static PostDto mapToPostDto(Post post){
        PostDto postDto = new PostDto();
               postDto.setId(post.getId());
               postDto.setTitle( post.getTitle());
               postDto.setDescription( post.getDescription());
               postDto.setContent( post.getContent());
               return postDto;

    }

    // Convert DTO to Entity
    public static Post mapToPost(PostDto postDto) {
       Post post = new Post();
       post.setId(postDto.getId());
       post.setTitle(postDto.getTitle());
       post.setDescription(postDto.getDescription());
       post.setContent(postDto.getContent());
       return post;
    }

    }

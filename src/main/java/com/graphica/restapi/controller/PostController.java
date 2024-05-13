package com.graphica.restapi.controller;

import com.graphica.restapi.dtos.PostDto;
import com.graphica.restapi.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    // Saved Rest API
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto savedPost = postService.createPost(postDto);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }

    // Get all Rest API

    //  Get All Post Rest API
    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts(@RequestParam(value="pageNo",defaultValue = "0",required = false)int pageNo,
                                                     @RequestParam(value="pageSize",defaultValue = "10", required = false) int pageSize){
        List<PostDto> students = postService.getAllPosts(pageNo,pageSize);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name="id")long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }

    // update post by id rest api

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable(name="id")long id){
        PostDto postResponse = postService.updatePost(postDto,id);
        return new ResponseEntity<>(postResponse,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletepost(@PathVariable(name = "id") long id){
        postService.deletePostById(id);
        return new ResponseEntity<>("Post entity deleted succesfully", HttpStatus.OK);
    }

}

package com.example.EmployeeManagement.controller;

import com.example.EmployeeManagement.dto.PostDto;
import com.example.EmployeeManagement.exception.ResourceNotFoundException;
import com.example.EmployeeManagement.model.Post;
import com.example.EmployeeManagement.service.PostService;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/posts")
public class PostsController {
    @Autowired
    private ModelMapper modelMapper;
    private PostService postService;

    public PostsController(PostService postService){
        super();
        this.postService = postService;
    }
    @GetMapping
    public List<PostDto> getAllPosts(){
        return  postService.getAllPosts().stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        Post post = postService.getPostById(id);

        //Here I convert the entity to dto
        PostDto postResponse = modelMapper.map(post, PostDto.class);

        return ResponseEntity.ok().body(postResponse);
    }
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        //firts i convert the dto to entity
        Post postRequest = modelMapper.map(postDto, Post.class);
        Post post = postService.createPost(postRequest);

        //convert the entity to dto
        PostDto postResponse = modelMapper.map(post, PostDto.class);

        return new ResponseEntity<PostDto>(postResponse, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable long id, @RequestBody PostDto postDto) throws ResourceNotFoundException {
        //convert the entity to Dto
        Post postRequest = modelMapper.map(postDto, Post.class);
        Post post = postService.updatePost(id, postRequest);

        //convert the Dto to entity
        PostDto postResponse = modelMapper.map(post, PostDto.class);

        return ResponseEntity.ok().body(postResponse);

//        in put: yoiu change the request for dto then change the response for dto
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        postService.deletePost(id);
        //ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, "Post deleted successfully", HttpStatus.OK);
        return ResponseEntity.ok().body("The psot has been deleted succesfully");
    }

}

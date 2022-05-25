package com.example.EmployeeManagement.controller;

import com.example.EmployeeManagement.dto.PostDto;
import com.example.EmployeeManagement.model.Post;
import com.example.EmployeeManagement.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

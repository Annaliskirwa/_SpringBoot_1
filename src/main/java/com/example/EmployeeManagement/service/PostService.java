package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.exception.ResourceNotFoundException;
import com.example.EmployeeManagement.model.Post;

import java.util.List;

public interface PostService {
   List<Post> getAllPosts();
   Post createPost(Post post);
   Post updatePost(long id, Post post) throws ResourceNotFoundException;
   void deletePost(long id) throws ResourceNotFoundException;
   Post getPostById(long id) throws ResourceNotFoundException;

}

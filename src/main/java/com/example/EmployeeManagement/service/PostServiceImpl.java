package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.model.Post;
import com.example.EmployeeManagement.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository){
        super();
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post createPost(Post post) {
        return null;
    }

    @Override
    public Post updatePost(long id, Post post) {
        return null;
    }

    @Override
    public void deletePost(long id) {

    }

    @Override
    public Post getPostById(long id) {
        return null;
    }
}

package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.exception.ResourceNotFoundException;
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
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(long id, Post postUpdate) throws ResourceNotFoundException {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The post has not been found" + id));
        post.setTitle(postUpdate.getTitle());
        post.setDescription(postUpdate.getDescription());
        post.setContent(postUpdate.getContent());
        return postRepository.save(post);
    }

    @Override
    public void deletePost(long id) throws ResourceNotFoundException {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The post has not been found" + id));
        postRepository.delete(post);
    }

    @Override
    public Post getPostById(long id) {
        return null;
    }
}

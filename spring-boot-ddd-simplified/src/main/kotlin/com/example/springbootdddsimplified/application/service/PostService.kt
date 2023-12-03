package com.example.springbootdddsimplified.application.service

import com.example.springbootdddsimplified.application.repository.PostRepository
import com.example.springbootdddsimplified.domain.post.Post
import com.example.springbootdddsimplified.domain.post.command.PostCreateCommand
import com.example.springbootdddsimplified.domain.post.command.PostUpdateCommand
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostService(
    private val postRepository: PostRepository
) {

    @Transactional(readOnly = true)
    fun findById(id: Long): Post = postRepository.findById(id).orElseThrow {
        throw IllegalArgumentException("Post not found. id=$id")
    }

    @Transactional
    fun createPost(cmd: PostCreateCommand): Post {
        return postRepository.save(Post.createPost(cmd))
    }

    @Transactional
    fun updatePost(cmd: PostUpdateCommand): Post {
        val post = postRepository.findById(cmd.id).get()
        post.updatePost(cmd)
        return postRepository.save(post)
    }
}
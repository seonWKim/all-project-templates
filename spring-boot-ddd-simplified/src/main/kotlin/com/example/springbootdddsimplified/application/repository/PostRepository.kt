package com.example.springbootdddsimplified.application.repository

import com.example.springbootdddsimplified.domain.post.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long> {}
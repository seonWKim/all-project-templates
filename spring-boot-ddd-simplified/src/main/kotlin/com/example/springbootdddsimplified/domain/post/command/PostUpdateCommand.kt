package com.example.springbootdddsimplified.domain.post.command

data class PostUpdateCommand(
    val id: Long,
    val title: String,
    val content: String
)
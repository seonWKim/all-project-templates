package com.example.springbootdddsimplified.domain.post.command

data class PostCreateCommand(
    val accountId: Long,
    val title: String,
    val content: String
)
package com.example.springbootdddsimplified.application.facade

import com.example.springbootdddsimplified.application.dto.PostCreateDto
import com.example.springbootdddsimplified.application.dto.PostUpdateDto
import com.example.springbootdddsimplified.application.service.AccountService
import com.example.springbootdddsimplified.application.service.PostService
import com.example.springbootdddsimplified.domain.post.Post
import com.example.springbootdddsimplified.domain.post.command.PostCreateCommand
import com.example.springbootdddsimplified.domain.post.command.PostUpdateCommand
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AccountPostService(
    val accountService: AccountService,
    val postService: PostService
) {

    @Transactional
    fun createPost(dto: PostCreateDto): Post {
        val accountId = accountService.findCurrentAccountId()
        return postService.createPost(
            PostCreateCommand(
                accountId = accountId,
                title = dto.title,
                content = dto.content
            )
        )
    }

    @Transactional
    fun updatePost(dto: PostUpdateDto): Post {
        val post = postService.findById(dto.id)
        if (post.accountId != accountService.findCurrentAccountId()) {
            throw IllegalArgumentException("You can only update your own post.")
        }

        return postService.updatePost(
            PostUpdateCommand(
                id = dto.id,
                title = dto.title,
                content = dto.content
            )
        )
    }
}
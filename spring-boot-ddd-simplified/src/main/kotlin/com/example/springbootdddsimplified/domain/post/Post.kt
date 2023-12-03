package com.example.springbootdddsimplified.domain.post

import com.example.springbootdddsimplified.domain.post.command.PostCreateCommand
import com.example.springbootdddsimplified.domain.post.command.PostUpdateCommand
import jakarta.persistence.*

@Entity(name = "post")
class Post(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0L,
    @Column(name = "account_id") val accountId: Long,
    @Column(name = "title") var title: String,
    @Column(name = "content") var content: String,
) {
    companion object {
        fun createPost(cmd: PostCreateCommand): Post {
            return Post(
                accountId = cmd.accountId, title = cmd.title, content = cmd.content
            )
        }
    }

    fun updatePost(cmd: PostUpdateCommand) {
        this.title = cmd.title
        this.content = cmd.content
    }
}
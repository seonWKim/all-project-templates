package com.example.projecttemplatekotlin.adapter.controller

import com.example.projecttemplatekotlin.adapter.mapper.AccountRequestResponseMapper
import com.example.projecttemplatekotlin.adapter.request.AccountRequest
import com.example.projecttemplatekotlin.adapter.request.AccountResponse
import com.example.projecttemplatekotlin.application.service.AccountService
import com.example.projecttemplatekotlin.domain.account.Account
import io.r2dbc.spi.ConnectionFactory
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.web.bind.annotation.*
import kotlin.random.Random

@RestController
@RequestMapping("/account")
class AccountController(val accountService: AccountService, val mapper: AccountRequestResponseMapper, val connectionFactory: ConnectionFactory) {
    companion object {
        val random = Random((1e9 + 7).toInt())
    }

    @GetMapping("/{id}")
    suspend fun findById(@PathVariable id: Long): AccountResponse {
        return mapper.toAccountResponse(
            accountService.findById(id)
        )
    }

    @PostMapping
    suspend fun save(@RequestBody accountRequest: AccountRequest): AccountResponse {
        println("accountRequest: ${accountRequest}")
        return mapper.toAccountResponse(
            accountService.save(mapper.fromAccountRequest(accountRequest))
        )
    }
    private val template = R2dbcEntityTemplate(connectionFactory)
    @GetMapping("/all")
    suspend fun getAll(username: String) = template.select(Account::class.java).all().subscribe()
}
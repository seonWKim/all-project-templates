package com.example.springbootkotlinblocking.adapter.controller

import com.example.springbootkotlinblocking.adapter.mapper.AccountDtoMapper
import com.example.springbootkotlinblocking.adapter.response.AccountResponse
import com.example.springbootkotlinblocking.application.account.AccountService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/account")
class AccountController(val accountService: AccountService, val mapper: AccountDtoMapper) {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): AccountResponse? {
        return accountService.findById(id)?.let { mapper.accountDtoToAccountResponse(it) }
    }
}
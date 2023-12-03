package com.example.springbootdddsimplified.adapter.controller

import com.example.springbootdddsimplified.adapter.controller.request.AccountCreateRequest
import com.example.springbootdddsimplified.adapter.controller.request.AccountUpdateRequest
import com.example.springbootdddsimplified.adapter.controller.response.AccountResponse
import com.example.springbootdddsimplified.application.service.AccountService
import com.example.springbootdddsimplified.domain.account.command.AccountCreateCommand
import com.example.springbootdddsimplified.domain.account.command.AccountUpdateCommand
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/accounts")
class AccountController(
    private val accountService: AccountService
) {

    @GetMapping("/{id}")
    fun getAccount(@PathVariable id: Long): AccountResponse {
        return accountService.findById(id).let {
            return AccountResponse(
                name = it.name,
                age = it.age
            )
        }
    }

    @PostMapping
    fun createAccount(@RequestBody request: AccountCreateRequest): AccountResponse {
        val account = accountService.createAccount(
            AccountCreateCommand(
                name = request.name,
                age = request.age
            )
        )
        return AccountResponse(
            name = account.name,
            age = account.age
        )
    }

    @PutMapping
    fun updateAccount(@RequestBody dto: AccountUpdateRequest): AccountResponse {
        val account = accountService.updateAccount(
            AccountUpdateCommand(
                name = dto.name,
                age = dto.age
            )
        )
        return AccountResponse(
            name = account.name,
            age = account.age
        )
    }
}
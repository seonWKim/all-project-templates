package com.example.springbootdddsimplified.application.service

import com.example.springbootdddsimplified.application.repository.AccountRepository
import com.example.springbootdddsimplified.domain.account.Account
import com.example.springbootdddsimplified.domain.account.command.AccountCreateCommand
import com.example.springbootdddsimplified.domain.account.command.AccountUpdateCommand
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AccountService(
    private val accountRepository: AccountRepository,
) {

    fun findCurrentAccountId(): Long {
        // TODO("Implement this method to return current account id.")
        return 1L
    }

    @Transactional(readOnly = true)
    fun findById(id: Long): Account = accountRepository.findById(id).orElseThrow {
        throw IllegalArgumentException("Account not found. id=$id")
    }

    @Transactional
    fun createAccount(cmd: AccountCreateCommand): Account {
        return accountRepository.save(Account.createAccount(cmd))
    }

    @Transactional
    fun updateAccount(cmd: AccountUpdateCommand): Account {
        val account = accountRepository.findById(findCurrentAccountId()).orElseThrow {
            throw IllegalArgumentException("Account not found. id=${findCurrentAccountId()}")
        }
        account.updateAccount(cmd)
        return accountRepository.save(account)
    }
}
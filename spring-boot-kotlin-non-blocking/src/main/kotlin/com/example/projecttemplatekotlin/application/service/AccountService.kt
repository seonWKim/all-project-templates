package com.example.projecttemplatekotlin.application.service

import com.example.projecttemplatekotlin.application.dto.AccountDto
import com.example.projecttemplatekotlin.application.mapper.AccountDtoMapper
import com.example.projecttemplatekotlin.domain.account.AccountRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AccountService(
    private val accountRepository: AccountRepository,
    private val mapper: AccountDtoMapper
) {

    @Transactional
    suspend fun findById(id: Long): AccountDto {
        return accountRepository.findById(id)?.let { mapper.toAccountDto(it) } ?: throw Exception("Account not found")
    }

    @Transactional
    suspend fun save(accountDto: AccountDto): AccountDto {
        return mapper.toAccountDto(accountRepository.save(mapper.fromAccountDto(accountDto)));
    }
}
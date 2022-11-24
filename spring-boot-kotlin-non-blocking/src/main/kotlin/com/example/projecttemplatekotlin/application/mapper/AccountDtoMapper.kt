package com.example.projecttemplatekotlin.application.mapper

import com.example.projecttemplatekotlin.application.dto.AccountDto
import com.example.projecttemplatekotlin.domain.account.Account
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
interface AccountDtoMapper {
    fun fromAccountDto(accountDto: AccountDto): Account
    fun toAccountDto(account: Account): AccountDto
}
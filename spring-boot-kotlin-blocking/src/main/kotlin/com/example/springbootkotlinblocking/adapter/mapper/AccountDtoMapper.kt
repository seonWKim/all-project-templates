package com.example.springbootkotlinblocking.adapter.mapper

import com.example.springbootkotlinblocking.adapter.request.AccountRequest
import com.example.springbootkotlinblocking.adapter.response.AccountResponse
import com.example.springbootkotlinblocking.application.dto.AccountDto
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
abstract class AccountDtoMapper {
    abstract fun accountDtoToAccountResponse(accountDto: AccountDto): AccountResponse
    abstract fun accountRequestToAccountDto(accountRequest: AccountRequest): AccountDto
}
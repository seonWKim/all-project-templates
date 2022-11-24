package com.example.projecttemplatekotlin.adapter.mapper

import com.example.projecttemplatekotlin.adapter.request.AccountRequest
import com.example.projecttemplatekotlin.adapter.request.AccountResponse
import com.example.projecttemplatekotlin.application.dto.AccountDto
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
interface AccountRequestResponseMapper {
    fun fromAccountRequest(accountRequest: AccountRequest): AccountDto
    fun toAccountResponse(accountDto: AccountDto): AccountResponse
}
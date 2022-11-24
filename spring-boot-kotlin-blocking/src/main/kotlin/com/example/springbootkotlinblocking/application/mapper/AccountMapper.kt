package com.example.springbootkotlinblocking.application.mapper

import com.example.springbootkotlinblocking.application.dto.AccountDto
import com.example.springbootkotlinblocking.domain.account.Account
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
abstract class AccountMapper {

    abstract fun accountDtoToAccount(accountDto: AccountDto): Account

    abstract fun accountToAccountDto(account: Account): AccountDto

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun updateAccountFromAccountDto(accountDto: AccountDto, @MappingTarget account: Account): Account
}
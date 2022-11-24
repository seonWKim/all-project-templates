package com.example.springbootkotlinblocking.application.account

import com.example.springbootkotlinblocking.application.dto.AccountDto
import com.example.springbootkotlinblocking.application.mapper.AccountMapper
import com.example.springbootkotlinblocking.domain.account.AccountRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AccountService(val accountRepository: AccountRepository, val mapper: AccountMapper) {

	@Transactional(readOnly = true)
	fun findById(id: Long): AccountDto? {
		return accountRepository.findByIdOrNull(id)
			?.let { mapper.accountToAccountDto(it) }
			?: throw RuntimeException("account not found")
	}

//    @Transactional
//    fun save(accountDto: AccountDto): AccountDto {
//        return mapper.accountToAccountDto(accountRepository.save(mapper.accountDtoToAccount(accountDto)));
//    }
//

}
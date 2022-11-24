package com.example.projecttemplatekotlin.domain.account

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : CoroutineCrudRepository<Account, Long> {
}

package com.example.springbootdddsimplified.application.repository

import com.example.springbootdddsimplified.domain.account.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : JpaRepository<Account, Long> {
}
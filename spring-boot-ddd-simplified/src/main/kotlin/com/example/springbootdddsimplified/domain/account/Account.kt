package com.example.springbootdddsimplified.domain.account

import com.example.springbootdddsimplified.domain.account.command.AccountCreateCommand
import com.example.springbootdddsimplified.domain.account.command.AccountUpdateCommand
import jakarta.persistence.*

@Entity(name = "account")
data class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    @Column(name = "name")
    var name: String,
    @Column(name = "age")
    var age: Int
) {
    companion object {
        fun createAccount(cmd: AccountCreateCommand): Account {
            return Account(
                name = cmd.name,
                age = cmd.age
            )
        }
    }

    fun updateAccount(cmd: AccountUpdateCommand) {
        this.name = cmd.name
        this.age = cmd.age
    }
}
package com.example.springbootddd.domain.payment;

import org.springframework.data.jpa.repository.JpaRepository

interface PaymentRepository : JpaRepository<Payment, Int> {
}
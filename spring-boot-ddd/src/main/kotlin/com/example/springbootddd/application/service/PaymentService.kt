package com.example.springbootddd.application.service

import com.example.springbootddd.application.dto.PaymentDto
import com.example.springbootddd.application.mapper.PaymentMapper
import com.example.springbootddd.domain.payment.PaymentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PaymentService(
    val paymentRepository: PaymentRepository,
    val mapper: PaymentMapper
) {

    @Transactional(readOnly = true)
    fun findById(id: Int): PaymentDto {
        return mapper.paymentToPaymentDto(
            paymentRepository.findByIdFetchJoin(id)
        )
    }

    @Transactional
    fun save(paymentDto: PaymentDto): PaymentDto {
        return mapper.paymentToPaymentDto(
            paymentRepository.save(
                mapper.paymentDtoToPayment(paymentDto)))
    }
}
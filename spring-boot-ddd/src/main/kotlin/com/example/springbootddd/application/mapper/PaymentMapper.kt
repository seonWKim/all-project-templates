package com.example.springbootddd.application.mapper

import com.example.springbootddd.application.dto.PaymentDto
import com.example.springbootddd.domain.payment.Payment
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
abstract class PaymentMapper {
    abstract fun paymentDtoToPayment(paymentDto: PaymentDto): Payment

    abstract fun paymentToPaymentDto(payment: Payment): PaymentDto

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun updatePaymentFromPaymentDto(paymentDto: PaymentDto, @MappingTarget payment: Payment): Payment
}
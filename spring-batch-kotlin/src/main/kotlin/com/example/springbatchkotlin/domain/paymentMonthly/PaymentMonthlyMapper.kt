package com.example.springbatchkotlin.domain.paymentMonthly

import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
abstract class PaymentMonthlyMapper {

    abstract fun paymentMonthlyDtoToPaymentMonthly(paymentMonthlyDto: PaymentMonthlyDto): PaymentMonthly

    abstract fun paymentMonthlyToPaymentMonthlyDto(paymentMonthly: PaymentMonthly): PaymentMonthlyDto

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun updatePaymentMonthlyFromPaymentMonthlyDto(
        paymentMonthlyDto: PaymentMonthlyDto,
        @MappingTarget paymentMonthly: PaymentMonthly
    ): PaymentMonthly
}
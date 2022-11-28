package com.example.springbatchkotlin.batch.parameter

import com.example.springbatchkotlin.domain.payment.PaymentDto
import com.example.springbatchkotlin.domain.paymentMonthly.PaymentMonthlyDto
import com.example.springbatchkotlin.utils.Slf4j.Companion.log
import org.springframework.beans.factory.InitializingBean
import org.springframework.batch.item.ItemProcessor


class MonthlyPaymentSettlementProcessor : ItemProcessor<PaymentDto, PaymentMonthlyDto>, InitializingBean {
    override fun process(item: PaymentDto): PaymentMonthlyDto? {
        log.info("processing...")
        return if (item != null) PaymentMonthlyDto() else null
    }

    override fun afterPropertiesSet() {
        log.info("initialized monthlyPaymentSettlementWriter")
    }
}
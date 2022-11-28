package com.example.springbatchkotlin.batch.parameter

import com.example.springbatchkotlin.domain.paymentMonthly.PaymentMonthlyDto
import com.example.springbatchkotlin.utils.Slf4j.Companion.log
import org.springframework.batch.item.ItemWriter
import org.springframework.beans.factory.InitializingBean

class MonthlyPaymentSettlementWriter: ItemWriter<PaymentMonthlyDto>, InitializingBean {
    override fun write(items: MutableList<out PaymentMonthlyDto>) {
        log.info("writing size: ${items.size}")
    }

    override fun afterPropertiesSet() {
        log.info("monthlyPaymentSettlementWriter written")
    }
}
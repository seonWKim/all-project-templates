package com.example.springbatchkotlin.batch.parameter

import com.example.springbatchkotlin.domain.payment.PaymentDto
import com.example.springbatchkotlin.domain.payment.PaymentService
import com.example.springbatchkotlin.utils.Slf4j.Companion.log
import org.springframework.batch.item.ItemReader
import org.springframework.beans.factory.InitializingBean

class MonthlyPaymentSettlementReader(
    val paymentParameter: PaymentParameter,
    val paymentService: PaymentService
): ItemReader<PaymentDto>, InitializingBean {

    private var pageNo = 0
    private val PAGE_SIZE = 10000

    override fun read(): PaymentDto? {
        while (pageNo < 1000) {
            log.info("reading paymentDto")
            pageNo++
            return PaymentDto()
        }

        return null
    }

        override fun afterPropertiesSet() {
        log.info("monthlyPaymentSettlementReader initiated")
    }
}

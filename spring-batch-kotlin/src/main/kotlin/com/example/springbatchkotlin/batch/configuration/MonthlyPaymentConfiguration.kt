package com.example.springbatchkotlin.batch.configuration

import com.example.springbatchkotlin.batch.parameter.MonthlyPaymentSettlementProcessor
import com.example.springbatchkotlin.batch.parameter.MonthlyPaymentSettlementReader
import com.example.springbatchkotlin.batch.parameter.MonthlyPaymentSettlementWriter
import com.example.springbatchkotlin.batch.parameter.PaymentParameter
import com.example.springbatchkotlin.domain.payment.PaymentDto
import com.example.springbatchkotlin.domain.payment.PaymentService
import com.example.springbatchkotlin.domain.paymentMonthly.PaymentMonthlyDto
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.JobScope
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.job.builder.SimpleJobBuilder
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment

@Configuration
class MonthlyPaymentConfiguration(
    val environment: Environment,
    val jobBuilderFactory: JobBuilderFactory,
    val stepBuilderFactory: StepBuilderFactory,
    val jobParameter: PaymentParameter,
    val paymentService: PaymentService
) {
    companion object {
        private const val JOB_NAME: String = "monthlyPaymentSettlementJob"
    }

    @Bean("${JOB_NAME}-jobParameter")
    @JobScope
    fun jobParameter() = PaymentParameter()

    @Bean
    fun monthlyPaymentSettlementJob(): Job {
        val jobBuilder = jobBuilderFactory.get(JOB_NAME)
        jobBuilder.incrementer(RunIdIncrementer())

        val simpleJobBuilder: SimpleJobBuilder = jobBuilder.start(monthlyPaymentSettlementStep())
        return simpleJobBuilder.build()
    }

    @Bean
    @JobScope
    fun monthlyPaymentSettlementStep(): Step {
        return stepBuilderFactory.get("monthlyPaymentSettlementStep")
            .chunk<PaymentDto, PaymentMonthlyDto>(10)
            .reader(MonthlyPaymentSettlementReader(jobParameter, paymentService))
            .processor(MonthlyPaymentSettlementProcessor())
            .writer(MonthlyPaymentSettlementWriter())
            .allowStartIfComplete(true)
            .build()
    }
}
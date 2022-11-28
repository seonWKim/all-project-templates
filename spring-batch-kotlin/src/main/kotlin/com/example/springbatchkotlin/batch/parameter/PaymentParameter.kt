package com.example.springbatchkotlin.batch.parameter

import JOB_PARAMETER_JOB_END_DATE
import JOB_PARAMETER_JOB_START_DATE
import org.springframework.beans.factory.annotation.Value
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

open class PaymentParameter {
    private val DATETIME_FORMATTER_YYYYMM = DateTimeFormatter.ofPattern("yyyyMM")

    @Value("#{jobParameters[$JOB_PARAMETER_JOB_START_DATE]}")
    private val jobStartDate: String? = null

    @Value("#{jobParameters[$JOB_PARAMETER_JOB_END_DATE]}")
    private val jobEndDate: String? = null

    fun getCloseMonthlyStartDate(): LocalDate {
        val closeStartDate = LocalDate.parse(jobStartDate, DateTimeFormatter.BASIC_ISO_DATE).minusDays(1)
        return closeStartDate.withDayOfMonth(1)
    }

    fun getCloseMonthlyEndDate(): LocalDate? {
        return if (Objects.isNull(jobEndDate)) {
            val closeStartDate = LocalDate.parse(jobStartDate, DateTimeFormatter.BASIC_ISO_DATE).minusDays(1)
            getCloseMonthlyStartDate().withDayOfMonth(closeStartDate.lengthOfMonth())
        } else {
            LocalDate.parse(jobEndDate, DateTimeFormatter.BASIC_ISO_DATE)
        }
    }

    fun getCloseStartYearMonth(): String? {
        val closeStartDate = LocalDate.parse(jobStartDate, DateTimeFormatter.BASIC_ISO_DATE).minusDays(1)
        return closeStartDate.format(DATETIME_FORMATTER_YYYYMM)
    }

    fun getCloseEndYearMonth(): String? {
        return if (Objects.isNull(jobEndDate)) {
            getCloseMonthlyStartDate().format(DATETIME_FORMATTER_YYYYMM)
        } else {
            LocalDate.parse(jobEndDate, DateTimeFormatter.BASIC_ISO_DATE)
                .format(DATETIME_FORMATTER_YYYYMM)
        }
    }

}
package com.example.springbatchkotlin.batch

import org.springframework.batch.core.*
import org.springframework.batch.item.ExecutionContext
import java.text.SimpleDateFormat

class JobExecutionResponse(
    private val id: Long? = null,
    private val jobParameters: JobParameters? = null,
    private val jobInstance: JobInstance? = null,
    private val status: BatchStatus? = null,
    private val startTime: String? = null,
    private val createdTime: String? = null,
    private val endTime: String? = null,
    private val lastUpdated: String? = null,
    private val exitStatus: ExitStatus? = null,
    private val executionContext: ExecutionContext? = null,
    private val failureExceptions: List<Throwable>? = null,
    private val jobConfigurationName: String? = null)
{
    companion object {
        fun fromJobExecution(jobExecution: JobExecution): JobExecutionResponse {
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            return JobExecutionResponse(
                id = jobExecution.id,
                jobParameters = jobExecution.jobParameters,
                status = jobExecution.status,
                startTime = if (jobExecution.startTime != null) sdf.format(jobExecution.startTime) else "" ,
                createdTime = sdf.format(jobExecution.createTime),
                endTime = if (jobExecution.endTime != null) sdf.format(jobExecution.endTime) else "",
                lastUpdated = if (jobExecution.lastUpdated != null) sdf.format(jobExecution.lastUpdated) else "",
                exitStatus = jobExecution.exitStatus,
                executionContext = jobExecution.executionContext,
                failureExceptions = jobExecution.failureExceptions,
                jobConfigurationName = jobExecution.jobConfigurationName
            )
        }
    }
}

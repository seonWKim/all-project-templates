package com.example.springbatchkotlin.batch

import com.example.springbatchkotlin.utils.Slf4j
import com.example.springbatchkotlin.utils.Slf4j.Companion.log
import org.springframework.batch.core.*
import org.springframework.batch.core.explore.JobExplorer
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException
import org.springframework.batch.core.repository.JobRestartException
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Slf4j
@Service
class JobService(
    private val syncJobLauncher: JobLauncher,
    private val applicationContext: ApplicationContext,
    private val jobExplorer: JobExplorer
) {

    fun findAllJobNames(): MutableList<String> = jobExplorer.jobNames

    fun findAllJobs(): Map<String, Set<JobExecutionResponse>> {
        val jobNames: List<String> = findAllJobNames()

        val jobExecutionsMap: MutableMap<String, Set<JobExecutionResponse>> = HashMap()

        for (jobName in jobNames) {
            jobExecutionsMap[jobName] = findJob(jobName)
        }

        return jobExecutionsMap
    }

    fun findJob(jobName: String): Set<JobExecutionResponse> {
        return jobExplorer.findRunningJobExecutions(jobName)
            .stream()
            .map { JobExecutionResponse.fromJobExecution(it) }
            .collect(Collectors.toSet())
    }

    @Throws(
        JobExecutionAlreadyRunningException::class,
        JobRestartException::class,
        JobInstanceAlreadyCompleteException::class,
        JobParametersInvalidException::class
    )
    fun startJob(jobName: String, jobParameters: JobParameters): JobExecutionResponse {
        val job: Job = applicationContext.getBean(jobName, Job::class.java)
        log.debug("jobName:{}, job:{}, jobParameters:{}", jobName, job, jobParameters)

        val jobExecution: JobExecution = syncJobLauncher.run(job, jobParameters)
        if (ExitStatus.COMPLETED.exitCode != jobExecution.exitStatus.exitCode) {
            log.error("job is not completed. jobName:{},ExitStatus:{}", jobName, jobExecution.exitStatus.exitCode)
            throw IllegalStateException("job is not completed. job name is $jobName")
        }
        return JobExecutionResponse.fromJobExecution(jobExecution)
    }

    fun stopJob(jobName: String?): Set<JobExecutionResponse?>? {
        val jobExecutions = jobExplorer.findRunningJobExecutions(jobName)
        for (jobExecution in jobExecutions) {
            log.info("stopping JobExecution:{}", jobExecution)
            jobExecution.stop()
        }
        return findJob(jobName!!)
    }

}
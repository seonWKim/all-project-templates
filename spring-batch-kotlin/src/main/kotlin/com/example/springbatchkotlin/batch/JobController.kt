package com.example.springbatchkotlin.batch

import BUILD_ID
import JOB_PARAMETER_JOB_START_DATE
import com.example.springbatchkotlin.utils.Slf4j.Companion.log
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RestController
@RequestMapping("/jobx")
class JobController(
    private val jobService: JobService
) {

    @GetMapping
    fun findAllJobs() = jobService.findAllJobs()

    @GetMapping("/{jobName}")
    fun findJob(@PathVariable("jobName") jobName: String) = jobService.findJob(jobName)

    @GetMapping("/{jobName}/start")
    fun startJob(@PathVariable("jobName") jobName: String, request: WebRequest): JobExecutionResponse {
        // 동일한 job parameter 구성으로 이미 complete한 job execution이 있으면 동일한 job parameter 구성으로는 중복 실행 못함.
        // 임의 query parameter를 추가해 주면 실행 가능.
        val builder = JobParametersBuilder()
        // default parameters; query parameter로 받은 값이 우선 적용됨
        builder.addString(
            JOB_PARAMETER_JOB_START_DATE,
            LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE) // yyyyMMdd
        )
        builder.addString(BUILD_ID, LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))

        val iterator = request.parameterNames

        while (iterator.hasNext()) {
            val name = iterator.next()
            val value = java.lang.String.join(",", *request.getParameterValues(name)) // join with comma. (eg, ?name=value1&name=value2&name=value3 ...)
            builder.addString(name, value)
        }

        log.info("job call. jobName:{},query:{}", arrayOf<Any>(jobName, builder.toString()))
        return jobService.startJob(jobName, builder.toJobParameters())
    }

    @GetMapping("{jobName}/stop")
    fun stopJob(@PathVariable("jobName") jobName: String) = jobService.stopJob(jobName)
}
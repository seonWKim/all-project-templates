package com.example.springbatchkotlin.batch.configuration

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.batch.core.launch.support.SimpleJobLauncher
import org.springframework.batch.core.repository.JobRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.task.SyncTaskExecutor
import org.springframework.core.task.TaskExecutor

@EnableBatchProcessing
@Configuration
class SyncJobLauncherConfiguration(
    private val jobRepository: JobRepository
) {
    @Bean
    fun syncJobLauncher(): JobLauncher {
        val simpleJobLauncher = SimpleJobLauncher()
        simpleJobLauncher.setJobRepository(jobRepository)
        simpleJobLauncher.setTaskExecutor(syncTaskExecutor())
        return simpleJobLauncher
    }

    @Bean
    fun syncTaskExecutor(): TaskExecutor {
        return SyncTaskExecutor()
    }
}
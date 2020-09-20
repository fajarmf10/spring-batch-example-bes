//package com.fajarmf.besbatch.service;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobParameter;
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.JobParametersInvalidException;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
//import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
//import org.springframework.batch.core.repository.JobRestartException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//@Slf4j
//public class ExcelFileToDbLauncher {
//
//    private final Job job;
//
//    private final JobLauncher jobLauncher;
//
//    @Autowired
//    ExcelFileToDbLauncher(@Qualifier("excelFileToDbLauncher") Job job, JobLauncher jobLauncher) {
//        this.job = job;
//        this.jobLauncher = jobLauncher;
//    }
//
//    @Scheduled
//    void launchXmlFileToDatabaseJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
//        log.info("Starting job schedule");
//        jobLauncher.run(job, newExecution());
//    }
//
//    private JobParameters newExecution() {
//        Map<String, JobParameter> parameters = new HashMap<>();
//
//        JobParameter parameter = new JobParameter(new Date());
//        parameters.put("currentTime", parameter);
//
//        return new JobParameters(parameters);
//    }
//}

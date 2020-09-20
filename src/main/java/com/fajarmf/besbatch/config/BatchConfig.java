package com.fajarmf.besbatch.config;

import com.fajarmf.besbatch.entity.BankwideData;
import com.fajarmf.besbatch.service.BankwideErsServiceImpl;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.excel.RowMapper;
import org.springframework.batch.item.excel.poi.PoiItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class BatchConfig {

    @Bean
    ItemReader<BankwideData> excelStudentReader() {
        PoiItemReader<BankwideData> reader = new PoiItemReader<>();
        reader.setLinesToSkip(1);
        reader.setResource(new ClassPathResource("data/dummycobabaca.xlsx"));
        reader.setRowMapper(excelRowMapper());
        return reader;
    }

    private RowMapper<BankwideData> excelRowMapper() {
        return new BankwideErsServiceImpl();
    }

    @Bean
    ItemProcessor<BankwideData, BankwideData> excelStudentProcessor() {
        return new BankwideProcessor();
    }

    @Bean
    ItemWriter<BankwideData> bankwideDataItemWriter(){
        return new BankwideWriter();
    }

    @Bean
    Step bankwideStep(ItemReader<BankwideData> restStudentReader,
                         ItemProcessor<BankwideData, BankwideData> restStudentProcessor,
                         ItemWriter<BankwideData> bankwideDataItemWriter,
                         StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("bankwideStep")
                .<BankwideData, BankwideData>chunk(1)
                .reader(restStudentReader)
                .processor(restStudentProcessor)
                .writer(bankwideDataItemWriter)
                .build();
    }

    @Bean
    Job bankwideJob(JobBuilderFactory jobBuilderFactory,
                       @Qualifier("bankwideStep") Step restStudentStep) {
        return jobBuilderFactory.get("bankwideJob")
                .incrementer(new RunIdIncrementer())
                .flow(restStudentStep)
                .end()
                .build();
    }
}

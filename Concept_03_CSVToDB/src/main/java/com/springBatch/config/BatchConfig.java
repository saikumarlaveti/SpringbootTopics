package com.springBatch.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.springBatch.Model.Employee;
import com.springBatch.listener.JobMonitoringListener;
import com.springBatch.processor.EmployeeItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private JobMonitoringListener listener;

    @Autowired
    private EmployeeItemProcessor processor;

    @Autowired
    private DataSource ds;

    @Bean(name = "reader")
    public FlatFileItemReader<Employee> createReader() {
        return new FlatFileItemReaderBuilder<Employee>()
                .name("file-reader")
                .resource(new ClassPathResource("employeeDetails.csv"))  // or your CSV name
                .delimited()
                .delimiter(",")
                .names("empno", "ename", "eadd") // add the two new fields
                .linesToSkip(1)                // if your CSV has a header
                .targetType(Employee.class)
                .build();
    }


    @Bean(name = "writer")
    public JdbcBatchItemWriter<Employee> createWriter() {
        JdbcBatchItemWriter<Employee> writer = new JdbcBatchItemWriter<>();
        writer.setDataSource(ds);
        writer.setSql("INSERT INTO Employee (empno, ename, eadd) VALUES (:empno, :ename, :eadd)");
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        return writer;
    }


    @Bean(name = "step1")
    public Step createStep1() {
        return new StepBuilder("step1", jobRepository)
                .<Employee, Employee>chunk(1, transactionManager)
                .reader(createReader())
                .processor(processor)
                .writer(createWriter())
                .build();
    }

    @Bean(name = "job1")
    public Job createJob1() {
        return new JobBuilder("job1", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .start(createStep1())
                .build();
    }
}

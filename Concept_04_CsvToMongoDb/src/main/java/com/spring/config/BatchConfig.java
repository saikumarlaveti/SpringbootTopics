package com.spring.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.PlatformTransactionManager;

import com.spring.listener.JobCompletionNotificationListener;
import com.spring.model.Student;
import com.spring.processor.StudentItemProcessor;
import com.spring.writer.MongoDBItemWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean
    public FlatFileItemReader<Student> reader() {
        FlatFileItemReader<Student> reader = new FlatFileItemReader<>();
        reader.setResource(new FileSystemResource("students.csv"));

        DefaultLineMapper<Student> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setNames("name", "email", "dob");

        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
            setTargetType(Student.class);
        }});

        reader.setLineMapper(lineMapper);
        return reader;
    }

    @Bean
    public StudentItemProcessor processor() {
        return new StudentItemProcessor();
    }

    @Bean
    public MongoDBItemWriter writer() {
        MongoDBItemWriter writer = new MongoDBItemWriter();
        writer.setTemplate(mongoTemplate);
        writer.setCollection("students");
        return writer;
    }

    @Bean
    public Step step1() {
        return new StepBuilder("step1", jobRepository)
                .<Student, Student>chunk(10, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public Job importStudentJob(JobCompletionNotificationListener listener) {
        return new JobBuilder("importStudentJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .start(step1())
                .build();
    }


}

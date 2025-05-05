package com.spring.config;


import java.text.SimpleDateFormat;

import javax.sql.DataSource;

import com.spring.listener.JobCompletionListener;
import com.spring.model.Student;
import com.spring.processor.StudentItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Bean
    public JdbcCursorItemReader<Student> reader(DataSource dataSource) {
        return new JdbcCursorItemReaderBuilder<Student>()
                .dataSource(dataSource)
                .sql("SELECT id, name, email, dob FROM students")
                .rowMapper((rs, rowNum) -> new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDate("dob")))
                .name("studentReader")
                .build();
    }

    @Bean
    public StudentItemProcessor processor() {
        return new StudentItemProcessor();
    }

    /*
    @Bean
    public FlatFileItemWriter<Student> writer() {
        FlatFileItemWriter<Student> writer = new FlatFileItemWriter<>();
       // writer.setResource(new FileSystemResource("C:\\Users\\Saikumar\\Downloads"));
        writer.setResource(new FileSystemResource("C:/Users/Saikumar/Downloads/students.csv"));

        BeanWrapperFieldExtractor<Student> extractor = new BeanWrapperFieldExtractor<>();
        extractor.setNames(new String[]{"id", "name", "email", "dob"});

        DelimitedLineAggregator<Student> aggregator = new DelimitedLineAggregator<>();
        aggregator.setDelimiter(",");
        aggregator.setFieldExtractor(extractor);

        writer.setLineAggregator(aggregator);

        return writer;
    }
*/
    
    @Bean
    public Step step1(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager,
                      JdbcCursorItemReader<Student> reader,
                      FlatFileItemWriter<Student> writer,
                      StudentItemProcessor processor) {
        return new StepBuilder("step1", jobRepository)
                .<Student, Student>chunk(5, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

/*
    @Bean
    public FlatFileItemWriter<Student> writer() {
        FlatFileItemWriter<Student> writer = new FlatFileItemWriter<>();
        writer.setResource(new FileSystemResource("C:/Users/Saikumar/Downloads/students.csv"));

        writer.setLineAggregator(student -> {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // or any format
            String dob = student.getDob() != null ? sdf.format(student.getDob()) : "";
            return student.getId() + "," + student.getName() + "," + student.getEmail() + "," + dob;
        });

        return writer;
    }
*/

    @Bean
    public FlatFileItemWriter<Student> writer() {
        FlatFileItemWriter<Student> writer = new FlatFileItemWriter<>();
        writer.setResource(new FileSystemResource("C:/Users/Saikumar/Downloads/students.csv"));

        // Use a custom line aggregator to format the student object into CSV format
        writer.setLineAggregator(student -> {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // format date to yyyy-MM-dd
            String dob = student.getDob() != null ? sdf.format(student.getDob()) : ""; // handle null dob
            return student.getId() + "," + student.getName() + "," + student.getEmail() + "," + dob;
        });

        return writer;
    }

    @Bean
    public Job job(JobRepository jobRepository,
                   Step step1,
                   JobCompletionListener listener) {
        return new JobBuilder("exportStudentJob", jobRepository)
                .listener(listener)
                .start(step1)
                .build();
    }
}

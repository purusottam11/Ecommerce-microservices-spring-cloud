package com.example.purusottam.blkdataimport.importdta;

import com.example.purusottam.blkdataimport.model.Demo;
import com.example.purusottam.blkdataimport.model.DemoDto;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;

import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;

    @Bean
    public FlatFileItemReader<Demo> reader() {
        FlatFileItemReader<Demo> reader = new FlatFileItemReader<Demo>();
        reader.setResource(new ClassPathResource("flipkart_com-ecommerce_sample.csv"));

        reader.setLineMapper(new DefaultLineMapper<Demo>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[]{"uniq_id", "crawl_timestamp", "product_url", "product_name", "product_category_tree", "pid", "retail_price", "discounted_price", "image", "is_FK_Advantage_product", "description", "product_rating", "overall_rating", "brand", "product_specifications"});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper() {{
                setTargetType(Demo.class);
            }});
        }});
        return reader;
    }


    @Bean
    public DemoProcesser processor() {
        return new DemoProcesser();
    }

    @Bean
    public JdbcBatchItemWriter<DemoDto> writer() {
        JdbcBatchItemWriter<DemoDto> writer = new JdbcBatchItemWriter<DemoDto>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        writer.setSql("INSERT INTO demo (uniq_id,crawl_timestamp,product_url,product_name,product_category_tree,pid,retail_price,discounted_price,image,is_FK_Advantage_product,description,product_rating,overall_rating,brand,product_specifications) " +
                "VALUES (:uniq_id,:crawl_timestamp,:product_url,:product_name,:product_category_tree,pid,:retail_price,discounted_price,:image,is_FK_Advantage_product,:description,product_rating,:overall_rating,:brand,:product_specifications)");
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    public Job importUserJob(JobListener listener) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Demo, DemoDto>chunk(5)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

}
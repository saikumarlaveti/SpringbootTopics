package com.spring.writer;



import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.spring.model.Student;

import java.util.List;

public class MongoDBItemWriter implements ItemWriter<Student> {

    private MongoTemplate mongoTemplate;
    private String collection;

    public void setTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

	@Override
	public void write(Chunk<? extends Student> chunk) throws Exception {
		// TODO Auto-generated method stub
		
	}

 

	
}

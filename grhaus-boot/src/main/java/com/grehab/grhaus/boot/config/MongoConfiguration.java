package com.grehab.grhaus.boot.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EntityScan("com.grehab.grhaus.infrastructure")
@EnableMongoRepositories("com.grehab.grhaus.infrastructure")
public class MongoConfiguration {

}

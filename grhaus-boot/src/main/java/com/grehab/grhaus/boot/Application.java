package com.grehab.grhaus.boot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = "com.grehab.grhaus")
@ComponentScan("com.grehab.grhaus")
@EntityScan("com.grehab.grhaus.infrastructure")
@EnableMongoRepositories("com.grehab.grhaus.infrastructure")
public class Application {

  public static void main(String[] args) {
    createSpringApplication().run( args);
  }

  private static SpringApplication createSpringApplication() {
    return new SpringApplication(Application.class);
  }

}

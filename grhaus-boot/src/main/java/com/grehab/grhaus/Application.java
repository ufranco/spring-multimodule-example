package com.grehab.grhaus;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
  "com.grehab.grhaus.infrastructure",
  "com.grehab.grhaus.use-cases",
  "com.grehab.grhaus.api-rest"
})
public class Application {

  public static void main(String[] args) {
    createSpringApplication().run( args);
  }

  private static SpringApplication createSpringApplication() {
    return new SpringApplication(Application.class);
  }

}

package com.grehab.grhaus.boot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    createSpringApplication().run( args);
  }

  private static SpringApplication createSpringApplication() {
    return new SpringApplication(Application.class);
  }

}

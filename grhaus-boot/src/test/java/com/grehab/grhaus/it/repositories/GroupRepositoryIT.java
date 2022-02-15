package com.grehab.grhaus.it.repositories;


import static org.assertj.core.api.Assertions.assertThat;

import com.grehab.grhaus.boot.config.ApplicationConfiguration;
import com.grehab.grhaus.boot.config.MongoConfiguration;
import com.grehab.grhaus.infrastructure.repositories.GroupRepository;
import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;

@SpringBootTest(classes = {
      ApplicationConfiguration.class,
      MongoConfiguration.class
})
public class GroupRepositoryIT {

  @Autowired
  private GroupRepository repository;

  private static final MongoDBContainer container = new MongoDBContainer("mongo:4.2.16")
      .withExposedPorts(27017);

  @DynamicPropertySource
  public static void overrideProps(final DynamicPropertyRegistry registry) {
    registry.add("spring.data.mongodb.uri", container::getReplicaSetUrl);
  }

  @BeforeAll
  public static void setUp() {
    container.start();
  }

  @AfterEach
  void cleanUp() {
    repository.deleteAll();
  }

  @Test
  void whenUsingACleanDB_thenFindAllShouldBeReturningNothing() {
    val result = repository.findAll();
    assertThat(result)
        .isNotNull()
        .isEmpty();
  }

}

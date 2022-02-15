package com.grehab.grhaus.it.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import com.grehab.grhaus.infrastructure.repositories.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.MongoDBContainer;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(initializers = TaskRepositoryIT.MongoDbInitializer.class)
@Log4j2
public class TaskRepositoryIT {

  @Autowired
  private UserRepository userRepository;

  private final static MongoDBContainer mongoDbContainer = new MongoDBContainer("mongo:4.2.16")
      .withExposedPorts(27017);

  @BeforeAll
  public static void startContainerAndPublicPortIsAvailable() {
    mongoDbContainer.start();
  }

  @Test
  void containerStartsAndPublicPortIsAvailable() {
    assertThat(userRepository.findAll().size())
        .isEqualTo(0);
  }

  public static class MongoDbInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
      log.info("Overriding Spring Properties for mongodb !!!!!!!!!");

      TestPropertyValues values = TestPropertyValues.of("spring.data.mongodb.host=" + mongoDbContainer.getReplicaSetUrl()
      );
      values.applyTo(configurableApplicationContext);
    }
  }
}

package com.grehab.grhaus;

import static org.assertj.core.api.Assertions.assertThat;

import com.grehab.grhaus.apirest.controllers.UserApiController;
import com.grehab.grhaus.boot.config.ApplicationConfiguration;
import com.grehab.grhaus.boot.config.MongoConfiguration;
import com.grehab.grhaus.domain.usecases.user.CreateUserUseCase;
import com.grehab.grhaus.infrastructure.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {
		ApplicationConfiguration.class,
		MongoConfiguration.class
})
class ApplicationTest {

	@Autowired
	private UserApiController userController;

	@Autowired
	private CreateUserUseCase createUserUseCase;

	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {

		assertThat(userController)
				.isNotNull();

		assertThat(createUserUseCase)
				.isNotNull();

		assertThat(userRepository)
				.isNotNull();
	}

}

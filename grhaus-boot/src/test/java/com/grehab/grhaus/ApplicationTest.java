package com.grehab.grhaus;

import static org.assertj.core.api.Assertions.assertThat;

import com.grehab.grhaus.domain.usecases.task.GetTaskByIdUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTest {

	@Autowired
	private GetTaskByIdUseCase randomBean;

	@Test
	void contextLoads() {
		assertThat(randomBean)
				.isNotNull();
	}

}

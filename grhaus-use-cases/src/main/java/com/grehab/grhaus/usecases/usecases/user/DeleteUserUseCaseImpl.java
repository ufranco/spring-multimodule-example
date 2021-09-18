package com.grehab.grhaus.usecases.usecases.user;

import com.grehab.grhaus.domain.usecases.user.DeleteUserUseCase;
import com.grehab.grhaus.infrastructure.repositories.TaskRepository;
import com.grehab.grhaus.infrastructure.repositories.UserRepository;
import com.grehab.grhaus.usecases.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Log4j2
@RequiredArgsConstructor
public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

  private final UserRepository useRepository;

  private final TaskRepository taskRepository;

  private final UserMapper mapper;

  @Override
  public void deleteUser(String username) {
    // TODO document why this method is empty
  }
}

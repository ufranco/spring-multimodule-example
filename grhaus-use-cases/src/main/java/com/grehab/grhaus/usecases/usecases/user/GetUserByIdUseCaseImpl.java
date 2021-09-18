package com.grehab.grhaus.usecases.usecases.user;

import com.grehab.grhaus.domain.commands.user.UserOutCommand;
import com.grehab.grhaus.domain.usecases.user.GetUserByIdUseCase;
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
public class GetUserByIdUseCaseImpl implements GetUserByIdUseCase {

  private final UserRepository repository;

  private final UserMapper mapper;

  @Override
  public UserOutCommand getUserById(String username) {
    return null;
  }
}

package com.grehab.grhaus.apirest.controllers;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import com.grehab.grhaus.apirest.api.UserApi;
import com.grehab.grhaus.apirest.mappers.RestUserMapper;
import com.grehab.grhaus.apirest.model.UserIn;
import com.grehab.grhaus.apirest.model.UserOut;
import com.grehab.grhaus.domain.enums.BusinessRuleEnum;
import com.grehab.grhaus.domain.exceptions.GRHausException;
import com.grehab.grhaus.domain.usecases.user.CreateUserUseCase;
import com.grehab.grhaus.domain.usecases.user.DeleteUserUseCase;
import com.grehab.grhaus.domain.usecases.user.GetUserByIdUseCase;
import com.grehab.grhaus.domain.usecases.user.UpdateUserUseCase;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
@Validated
public class UserApiController implements UserApi {

  private final GetUserByIdUseCase getUserByIdUseCase;

  private final CreateUserUseCase createUserUseCase;

  private final UpdateUserUseCase updateUserUseCase;

  private final DeleteUserUseCase deleteUserUseCase;

  private final RestUserMapper mapper;

  @Override
  public ResponseEntity<UserOut> createUser(UserIn userIn) throws GRHausException {
    val userOut = Optional.ofNullable(userIn)
        .map(mapper::mapToUserInCommand)
        .map(createUserUseCase::createUser)
        .map(mapper::mapToUserOut)
        .orElseThrow(() ->
            new GRHausException(BusinessRuleEnum.UNEXPECTED_ERROR)
        );

    return new ResponseEntity<>(userOut, CREATED);
  }

  @Override
  public ResponseEntity<Void> deleteUser(String id) throws NotFoundException {
    deleteUserUseCase.deleteUser(id);

    return new ResponseEntity<>(NO_CONTENT);
  }

  @Override
  public ResponseEntity<UserOut> getUser(String id) throws GRHausException, NotFoundException {
    return Optional.ofNullable(getUserByIdUseCase.getUserById(id))
        .map(mapper::mapToUserOut)
        .map(ResponseEntity::ok)
        .orElseThrow(() ->
            new GRHausException(BusinessRuleEnum.UNEXPECTED_ERROR)
        );
  }

  @Override
  public ResponseEntity<UserOut> updateUser(UserIn userIn) throws GRHausException, NotFoundException {
    val inCommand = Optional.ofNullable(userIn)
        .map(mapper::mapToUserInCommand)
        .orElseThrow(() -> new GRHausException(BusinessRuleEnum.UNEXPECTED_ERROR));

    return Optional.of(updateUserUseCase.updateUser(inCommand))
        .map(mapper::mapToUserOut)
        .map(ResponseEntity::ok)
        .orElseThrow(() -> new GRHausException(BusinessRuleEnum.UNEXPECTED_ERROR));
  }
}

package com.grehab.grhaus.apirest.controllers;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import com.grehab.grhaus.apirest.api.GroupApi;
import com.grehab.grhaus.apirest.mappers.RestGroupMapper;
import com.grehab.grhaus.apirest.model.GroupIn;
import com.grehab.grhaus.apirest.model.GroupOut;
import com.grehab.grhaus.domain.enums.BusinessRuleEnum;
import com.grehab.grhaus.domain.exceptions.GRHausException;
import com.grehab.grhaus.domain.usecases.group.CreateGroupUseCase;
import com.grehab.grhaus.domain.usecases.group.DeleteGroupUseCase;
import com.grehab.grhaus.domain.usecases.group.GetGroupByIdUseCase;
import com.grehab.grhaus.domain.usecases.group.UpdateGroupUseCase;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Log4j2
@Validated
public class GroupApiController implements GroupApi {

  private final GetGroupByIdUseCase getGroupByIdUseCase;

  private final CreateGroupUseCase createGroupUseCase;

  private final UpdateGroupUseCase updateTaskUseCase;

  private final DeleteGroupUseCase deleteGroupUseCase;

  private final RestGroupMapper mapper;

  @Override
  public ResponseEntity<Void> createGroup(GroupIn groupIn) throws GRHausException {
    Optional.of(groupIn)
        .map(mapper::mapToGroupInCommand)
        .map(createGroupUseCase::createGroup)
        .map(mapper::mapToGroupOut)
        .orElseThrow(() ->
            new GRHausException(BusinessRuleEnum.UNEXPECTED_ERROR)
        );

    return new ResponseEntity<>(CREATED);
  }

  @Override
  public ResponseEntity<Void> deleteGroup(String id) {
    deleteGroupUseCase.deleteGroup(id);
    return new ResponseEntity<>(NO_CONTENT);
  }

  @Override
  public ResponseEntity<GroupOut> getGroup(String id) throws GRHausException {
    return Optional.of(id)
        .map(getGroupByIdUseCase::getGroupById)
        .map(mapper::mapToGroupOut)
        .map(ResponseEntity::ok)
        .orElseThrow(() ->
            new GRHausException(BusinessRuleEnum.UNEXPECTED_ERROR)
        );
  }

  @Override
  public ResponseEntity<GroupOut> updateGroup(String id, GroupIn groupIn) throws GRHausException {
    return Optional.of(groupIn)
        .map(group -> mapper.mapToGroupInCommand(id, group))
        .map(updateTaskUseCase::updateGroup)
        .map(mapper::mapToGroupOut)
        .map(ResponseEntity::ok)
        .orElseThrow(() -> new GRHausException(BusinessRuleEnum.UNEXPECTED_ERROR));
  }
}

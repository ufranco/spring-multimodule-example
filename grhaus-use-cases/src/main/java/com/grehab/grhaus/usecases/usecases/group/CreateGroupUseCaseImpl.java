package com.grehab.grhaus.usecases.usecases.group;

import com.grehab.grhaus.domain.commands.group.GroupInCommand;
import com.grehab.grhaus.domain.commands.group.GroupOutCommand;
import com.grehab.grhaus.domain.usecases.group.CreateGroupUseCase;
import com.grehab.grhaus.infrastructure.repositories.GroupRepository;
import com.grehab.grhaus.usecases.mappers.GroupMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Log4j2
@RequiredArgsConstructor
public class CreateGroupUseCaseImpl implements CreateGroupUseCase {

  private final GroupRepository repository;

  private final GroupMapper mapper;

  @Override
  public GroupOutCommand createGroup(GroupInCommand inCommand) {
    return null;
  }

}

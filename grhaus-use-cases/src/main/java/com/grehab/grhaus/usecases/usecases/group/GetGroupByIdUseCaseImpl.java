package com.grehab.grhaus.usecases.usecases.group;

import com.grehab.grhaus.domain.commands.group.GroupOutCommand;
import com.grehab.grhaus.domain.usecases.group.GetGroupByIdUseCase;
import com.grehab.grhaus.infrastructure.repositories.GroupRepository;
import com.grehab.grhaus.usecases.mappers.GroupMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Log4j2
@RequiredArgsConstructor
public class GetGroupByIdUseCaseImpl implements GetGroupByIdUseCase {

  private final GroupRepository repository;

  private final GroupMapper mapper;

  @Override
  public GroupOutCommand getGroupById(String id) throws NotFoundException {
    return repository.findById(id)
        .map(mapper::mapGroupEntityToGroupOutCommand)
        .orElseThrow(NotFoundException::new);
  }
}

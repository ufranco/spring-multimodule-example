package com.grehab.grhaus.usecases.usecases.group;

import com.grehab.grhaus.domain.usecases.group.DeleteGroupUseCase;
import com.grehab.grhaus.infrastructure.repositories.GroupRepository;
import com.grehab.grhaus.infrastructure.repositories.TaskRepository;
import com.grehab.grhaus.infrastructure.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Log4j2
@RequiredArgsConstructor
public class DeleteGroupUseCaseImpl implements DeleteGroupUseCase {

  private final GroupRepository groupRepository;

  private final UserRepository userRepository;

  private final TaskRepository taskRepository;

  @Override
  public void deleteGroup(String id) throws NotFoundException {
    // TODO document why this method is empty
  }
}

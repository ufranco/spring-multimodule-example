package com.grehab.grhaus.domain.usecases.group;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public interface DeleteGroupUseCase {

  void deleteGroup(String id) throws NotFoundException;

}

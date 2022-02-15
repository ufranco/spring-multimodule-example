package com.grehab.grhaus.domain.usecases.user;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public interface DeleteUserUseCase {

  void deleteUser(String username) throws NotFoundException;

}

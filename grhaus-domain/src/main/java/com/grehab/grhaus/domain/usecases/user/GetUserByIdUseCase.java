package com.grehab.grhaus.domain.usecases.user;

import com.grehab.grhaus.domain.commands.user.UserOutCommand;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public interface GetUserByIdUseCase {

  UserOutCommand getUserById(String username) throws NotFoundException;

}

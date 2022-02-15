package com.grehab.grhaus.domain.usecases.user;

import com.grehab.grhaus.domain.commands.user.UserInCommand;
import com.grehab.grhaus.domain.commands.user.UserOutCommand;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public interface UpdateUserUseCase {

  UserOutCommand updateUser(UserInCommand inCommand) throws NotFoundException;

}

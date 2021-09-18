package com.grehab.grhaus.domain.usecases.user;

import com.grehab.grhaus.domain.commands.user.UserInCommand;
import com.grehab.grhaus.domain.commands.user.UserOutCommand;

public interface CreateUserUseCase {

  UserOutCommand createUser(final UserInCommand inCommand);

}

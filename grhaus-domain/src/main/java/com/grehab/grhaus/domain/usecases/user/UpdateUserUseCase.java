package com.grehab.grhaus.domain.usecases.user;

import com.grehab.grhaus.domain.commands.user.UserInCommand;
import com.grehab.grhaus.domain.commands.user.UserOutCommand;

public interface UpdateUserUseCase {

  UserOutCommand updateUser(final UserInCommand inCommand);

}

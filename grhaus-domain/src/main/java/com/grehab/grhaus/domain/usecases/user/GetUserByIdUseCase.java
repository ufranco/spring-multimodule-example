package com.grehab.grhaus.domain.usecases.user;

import com.grehab.grhaus.domain.commands.user.UserOutCommand;

public interface GetUserByIdUseCase {

  UserOutCommand getUserById(final String username);

}

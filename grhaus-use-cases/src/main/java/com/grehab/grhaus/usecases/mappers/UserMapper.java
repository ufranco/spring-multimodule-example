package com.grehab.grhaus.usecases.mappers;

import com.grehab.grhaus.domain.commands.user.UserInCommand;
import com.grehab.grhaus.domain.commands.user.UserOutCommand;
import com.grehab.grhaus.infrastructure.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserEntity mapUserInCommandToUserEntity(UserInCommand inCommand);

  UserOutCommand mapUserEntityToUserOutCommand(UserEntity entity);

}

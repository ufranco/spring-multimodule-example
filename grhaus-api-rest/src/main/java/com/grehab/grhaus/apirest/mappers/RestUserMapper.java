package com.grehab.grhaus.apirest.mappers;

import com.grehab.grhaus.apirest.model.UserIn;
import com.grehab.grhaus.apirest.model.UserOut;
import com.grehab.grhaus.domain.commands.user.UserInCommand;
import com.grehab.grhaus.domain.commands.user.UserOutCommand;
import org.mapstruct.Mapper;

@Mapper
public interface RestUserMapper {

  UserInCommand mapToUserInCommand(UserIn userIn);

  UserOut mapToUserOut(UserOutCommand outCommand);

}

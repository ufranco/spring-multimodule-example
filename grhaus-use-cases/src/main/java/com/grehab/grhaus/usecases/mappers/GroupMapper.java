package com.grehab.grhaus.usecases.mappers;

import com.grehab.grhaus.domain.commands.group.GroupInCommand;
import com.grehab.grhaus.domain.commands.group.GroupOutCommand;
import com.grehab.grhaus.infrastructure.entities.GroupEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroupMapper {

  GroupEntity mapGroupInCommandToGroupEntity(final GroupInCommand inCommand);

  GroupOutCommand mapGroupEntityToGroupOutCommand(final GroupEntity entity);

}

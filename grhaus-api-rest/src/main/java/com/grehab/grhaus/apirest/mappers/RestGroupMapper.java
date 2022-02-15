package com.grehab.grhaus.apirest.mappers;


import com.grehab.grhaus.apirest.model.GroupIn;
import com.grehab.grhaus.apirest.model.GroupOut;
import com.grehab.grhaus.domain.commands.group.GroupInCommand;
import com.grehab.grhaus.domain.commands.group.GroupOutCommand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RestGroupMapper {

  @Mapping(target = "id", ignore = true)
  GroupInCommand mapToGroupInCommand(GroupIn groupIn);

  GroupInCommand mapToGroupInCommand(String id, GroupIn groupIn);

  @Mapping(source = "members", target = "members")
  @Mapping(source = "tasks", target = "tasks")
  GroupOut mapToGroupOut(GroupOutCommand group);
}

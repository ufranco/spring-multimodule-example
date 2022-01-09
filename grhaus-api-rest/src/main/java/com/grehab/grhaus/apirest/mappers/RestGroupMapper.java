package com.grehab.grhaus.apirest.mappers;


import com.grehab.grhaus.apirest.model.GroupIn;
import com.grehab.grhaus.apirest.model.GroupOut;
import com.grehab.grhaus.domain.commands.group.GroupInCommand;
import com.grehab.grhaus.domain.commands.group.GroupOutCommand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface RestGroupMapper {

  GroupInCommand mapToGroupInCommand(GroupIn groupIn);

  GroupInCommand mapToGroupInCommand(String id, GroupIn groupIn);

  @Mapping(target = "id", source = "")
  GroupOut mapToGroupOut(GroupOutCommand group);
}

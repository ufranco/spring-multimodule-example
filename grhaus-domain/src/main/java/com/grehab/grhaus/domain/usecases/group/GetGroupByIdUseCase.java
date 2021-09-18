package com.grehab.grhaus.domain.usecases.group;

import com.grehab.grhaus.domain.commands.group.GroupOutCommand;

public interface GetGroupByIdUseCase {

  GroupOutCommand getGroupById(final String id);

}

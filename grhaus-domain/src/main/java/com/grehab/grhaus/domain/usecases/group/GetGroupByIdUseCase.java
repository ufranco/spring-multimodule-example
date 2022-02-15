package com.grehab.grhaus.domain.usecases.group;

import com.grehab.grhaus.domain.commands.group.GroupOutCommand;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public interface GetGroupByIdUseCase {

  GroupOutCommand getGroupById(String id) throws NotFoundException;

}

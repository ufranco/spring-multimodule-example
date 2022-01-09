package com.grehab.grhaus.domain.usecases.group;

import com.grehab.grhaus.domain.commands.group.GroupInCommand;
import com.grehab.grhaus.domain.commands.group.GroupOutCommand;

public interface UpdateGroupUseCase {

  GroupOutCommand updateGroup(GroupInCommand inCommand);

}

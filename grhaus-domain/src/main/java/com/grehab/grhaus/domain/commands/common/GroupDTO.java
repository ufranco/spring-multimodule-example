package com.grehab.grhaus.domain.commands.common;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class GroupDTO {

  String id;

  String name;

  String description;

}

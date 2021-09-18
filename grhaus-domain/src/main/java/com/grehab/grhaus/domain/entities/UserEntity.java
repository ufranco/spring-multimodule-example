package com.grehab.grhaus.domain.entities;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("User")
@Value
@EqualsAndHashCode
@Builder(toBuilder = true)
public class UserEntity {

  @Id
  @NotBlank(message = "Username is mandatory")
  @Pattern(regexp = "[a-zA-Z0-9]{6,24}")
  String username;

  @Pattern(regexp = "[0-9a-fA-F]{24}")
  String groupId;

}

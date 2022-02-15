package com.grehab.grhaus.infrastructure.entities;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("User")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder(toBuilder = true)
public class UserEntity {

  @Id
  @Pattern(regexp = "[0-9a-fA-F]{24}")
  @EqualsAndHashCode.Include
  String id;

  @NotBlank(message = "Username is mandatory")
  @Pattern(regexp = "[a-zA-Z0-9]{6,24}")
  String username;

  @Pattern(regexp = "[0-9a-fA-F]{24}")
  String groupId;

}

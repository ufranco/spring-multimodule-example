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
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Task")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder(toBuilder = true)
@ToString
public class GroupEntity {

  @Id
  @Pattern(regexp = "[0-9a-fA-F]{24}")
  @EqualsAndHashCode.Include
  String id;

  @NotBlank(message = "Name is mandatory")
  @Pattern(regexp = "[\\w\\s&]{6,50}")
  String name;

  @NotBlank(message = "Description is mandatory")
  @Pattern(regexp = "[\\w\\s.,]{0,300}")
  String description;

}

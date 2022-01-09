package com.grehab.grhaus.infrastructure.entities;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Task")
@Value
@EqualsAndHashCode
@Builder(toBuilder = true)
public class GroupEntity {

  @Id
  String id;

  @NotBlank(message = "Name is mandatory")
  @Pattern(regexp = "[\\w\\s&]{6,50}")
  String name;

  @NotBlank(message = "Description is mandatory")
  @Pattern(regexp = "[\\w\\s.,]{0,300}")
  String description;

}

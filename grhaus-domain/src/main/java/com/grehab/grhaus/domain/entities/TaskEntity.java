package com.grehab.grhaus.domain.entities;

import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
public class TaskEntity {

  @Id
  String id;

  @NotBlank
  @Pattern(regexp = "[0-9a-fA-F]{24}")
  String groupId;

  @NotBlank
  @Pattern(regexp = "[\\w\\s.,]{0,300}")
  String description;

  @Pattern(regexp = "[a-zA-Z0-9]{6,24}")
  String assignedTo;

  @Min(1)
  @Max(10)
  Integer effort;

  Boolean done;

  Date dueDate;

}

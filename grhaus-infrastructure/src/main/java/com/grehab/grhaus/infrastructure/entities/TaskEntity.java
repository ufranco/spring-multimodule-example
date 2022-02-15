package com.grehab.grhaus.infrastructure.entities;

import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
public class TaskEntity {

  @Id
  @Pattern(regexp = "[0-9a-fA-F]{24}")
  @EqualsAndHashCode.Include
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

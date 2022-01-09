package com.grehab.grhaus.infrastructure.repositories;

import com.grehab.grhaus.infrastructure.entities.TaskEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<TaskEntity, String> {

  TaskEntity getByAssignedTo(String assignedTo);

  TaskEntity getByGroupId(String groupId);

}
package com.grehab.grhaus.infrastructure.repositories;

import com.grehab.grhaus.infrastructure.entities.GroupEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends MongoRepository<GroupEntity, String> {

}

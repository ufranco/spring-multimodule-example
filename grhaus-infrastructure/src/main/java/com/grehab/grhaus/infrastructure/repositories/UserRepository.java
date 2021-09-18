package com.grehab.grhaus.infrastructure.repositories;

import com.grehab.grhaus.domain.entities.UserEntity;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {

  List<UserEntity> findByGroupId(final String groupId);
}
